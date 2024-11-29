package com.example.afterfp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.afterfp.ui.theme.AfterFpTheme
import com.example.afterfp.userStorage.presentation.screens.SetupNavGraph


class MainActivity : ComponentActivity() {
    private lateinit var navController:NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AfterFpTheme {

                navController = rememberNavController()
                SetupNavGraph(navController = navController )
            }
        }
    }
}

