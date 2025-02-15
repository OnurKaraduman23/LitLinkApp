package com.onuryasarkaraduman.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.onuryasarkaraduman.ui.extensions.boldBorder
import com.onuryasarkaraduman.ui.extensions.conditional
import com.onuryasarkaraduman.ui.extensions.noRippleClickable

@Composable
fun AppBottomBar(
    navController: NavController,
) {
    val tabList = NavigationItem.getNavigationItems()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        modifier = Modifier.padding(horizontal = 16.dp),
        containerColor = Color.White,
    ) {
        tabList.forEach { navItem ->
            val isSelected = currentRoute == navItem.route.getRoute()
            key(navItem.route.getRoute()) {
                Column(
                    modifier = Modifier
                        .wrapContentSize()
                        .weight(if (isSelected) 0.6f else 0.3f)
                        .background(
                            color = if (isSelected) colorResource(id = R.color.lightGray) else Color.White,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .conditional(isSelected) { boldBorder(color = colorResource(id = R.color.yellow_selection_border)) }
                        .noRippleClickable {
                            navController.navigate(navItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                        .padding(
                            horizontal = if (isSelected) 10.dp else 0.dp,
                            vertical = 8.dp,
                        ),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        modifier = Modifier.size(if (isSelected) 18.dp else 22.dp),
                        painter = painterResource(id = navItem.icon),
                        tint = if (isSelected) Color.White else Color.Black,
                        contentDescription = null,
                    )
                    AnimatedVisibility(isSelected) {
                        Text(text = stringResource(id = navItem.title), fontSize = 12.sp)
                    }
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun AppBottomBarPreview() {
    AppBottomBar(
        navController = rememberNavController(),
    )
}