package com.onuryasarkaraduman.navigation

import com.onuryasarkaraduman.ui.Search
import com.onuryasarkaraduman.ui.navigation.Discover
import com.onuryasarkaraduman.ui.navigation.Favorites
import com.onuryasarkaraduman.ui.navigation.Home
import com.onuryasarkaraduman.ui.navigation.Profile
import com.onuryasarkaraduman.ui.navigation.Screen

sealed class NavigationItem(
    var route: Screen,
    var title: Int,
    val icon: Int,
) {

    data object HomeScreen : NavigationItem(
        route = Home,
        title = R.string.home,
        icon = R.drawable.ic_home
    )

    data object SearchScreen : NavigationItem(
        route = Search,
        title = R.string.search,
        icon = R.drawable.ic_search
    )

    data object FavoritesScreen : NavigationItem(
        route = Favorites,
        title = R.string.favorites,
        icon = R.drawable.ic_favorite
    )

    data object ProfileScreen : NavigationItem(
        route = Profile,
        title = R.string.profile,
        icon = R.drawable.ic_profile
    )

    data object DiscoverScreen : NavigationItem(
        route = Discover,
        title = R.string.discover,
        icon = R.drawable.ic_discover
    )

    companion object {
        fun getNavigationRoutes() = listOf(
            HomeScreen.route.getRoute(),
            SearchScreen.route.getRoute(),
            FavoritesScreen.route.getRoute(),
            ProfileScreen.route.getRoute(),
            DiscoverScreen.route.getRoute()
        )

        fun getNavigationItems() = listOf(
            HomeScreen, SearchScreen, FavoritesScreen, ProfileScreen,
            DiscoverScreen
        )
    }
}