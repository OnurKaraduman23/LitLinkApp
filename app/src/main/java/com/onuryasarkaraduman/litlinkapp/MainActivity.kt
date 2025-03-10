package com.onuryasarkaraduman.litlinkapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.onuryasarkaraduman.core.ui.R
import com.onuryasarkaraduman.litlinkapp.ui.theme.LitLinkAppTheme
import com.onuryasarkaraduman.navigation.AppBottomBar
import com.onuryasarkaraduman.navigation.AppNavGraph
import com.onuryasarkaraduman.navigation.NavigationItem
import com.onuryasarkaraduman.ui.components.AppDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val uiState by viewModel.uiState.collectAsStateWithLifecycle()

            val navController = rememberNavController()

            val visibleBottomSheetScreen = NavigationItem.getNavigationRoutes()

            val bottomBarVisibility =
                navController.currentBackStackEntryAsState().value?.destination?.route in visibleBottomSheetScreen
            LitLinkAppTheme {

                Box {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        containerColor = Color.White,
                        content = { innerPadding ->
                            AppNavGraph(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(innerPadding),
                                navController = navController,
                            )
                        },
                        bottomBar = {
                            AnimatedVisibility(bottomBarVisibility) {
                                Column {
                                    HorizontalDivider(
                                        thickness = 2.dp,
                                        color = colorResource(id = R.color.yellow_selection_border),
                                    )
                                    AppBottomBar(
                                        navController = navController,
                                    )
                                }
                            }
                        }
                    )
                }
                if (uiState.isShowNoNetworkDialog) {
                    AppDialog(
                        isSuccess = false,
                        isCancelable = false,
                        message = stringResource(R.string.no_network_connection),
                        onButtonClick = {
                            viewModel.updateUiState { copy(isShowNoNetworkDialog = false) }
                        }
                    )
                }

            }
        }
    }
}

