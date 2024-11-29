package com.example.afterfp.userStorage.presentation.screens

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.afterfp.ViewModelForDetails
import com.example.afterfp.userStorage.presentation.screens.homeScreen.homeNavGraph

//private const val TIME_DURATION = 300
//
//val enterTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition = {
//    slideInHorizontally(
//        initialOffsetX = { it },
//        animationSpec = tween(durationMillis = TIME_DURATION, easing = LinearOutSlowInEasing)
//    )
//}
@Composable
fun SetupNavGraph(navController: NavHostController) {
    val viewModel:ViewModelForDetails = viewModel()
    NavHost(
        startDestination = HOME_ROUTE,
        navController = navController,
        route = ROOT_ROUTE,
        enterTransition = {
            // you can change whatever you want transition
            EnterTransition.None
        },
        exitTransition = {
            // you can change whatever you want transition
            ExitTransition.None
        }


    ) {
        homeNavGraph(navHostController = navController,viewModel = viewModel)
    }
}