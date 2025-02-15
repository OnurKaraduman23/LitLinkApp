package com.onuryasarkaraduman.litlinkapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.onuryasarkaraduman.litlinkapp.ui.theme.LitLinkAppTheme
import com.onuryasarkaraduman.navigation.AppBottomBar
import com.onuryasarkaraduman.navigation.AppNavGraph
import com.onuryasarkaraduman.navigation.NavigationItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
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

            }
        }
    }
}

