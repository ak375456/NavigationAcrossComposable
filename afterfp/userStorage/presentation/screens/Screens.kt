package com.example.afterfp.userStorage.presentation.screens

const val HOME_ROUTE = "home"
const val ROOT_ROUTE = "root"

sealed class Screens(val route: String) {
    data object Home: Screens(route = "homeScreen")
    data object Detail: Screens(route = "detailsScreen")
}