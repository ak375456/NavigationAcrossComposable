package com.example.afterfp.userStorage.presentation.screens.homeScreen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.afterfp.ViewModelForDetails
import com.example.afterfp.userStorage.presentation.screens.HOME_ROUTE
import com.example.afterfp.userStorage.presentation.screens.Screens
import com.example.afterfp.userStorage.presentation.screens.detailScreen.DetailScreen

fun NavGraphBuilder.homeNavGraph(navHostController: NavHostController,viewModel: ViewModelForDetails){

    navigation(
        startDestination = Screens.Home.route,
        route = HOME_ROUTE,
        ){
        composable(
            route = Screens.Home.route
        ){
            HomeScreen(navHostController = navHostController, viewModel = viewModel)
        }
        composable(
            route = Screens.Detail.route
        ){
            DetailScreen(navHostController = navHostController, viewModel = viewModel)
        }

    }
}