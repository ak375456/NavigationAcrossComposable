package com.example.afterfp.userStorage.presentation.screens.detailScreen

import MyAppBar
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.afterfp.ViewModelForDetails
import com.example.afterfp.userStorage.presentation.screens.homeScreen.component.UserCard


@Composable
fun DetailScreen(navHostController: NavHostController,viewModel: ViewModelForDetails){
    Scaffold (
        topBar = {MyAppBar(
            title = "Detail Screen",
            showNavigationIcon = true,
            onNavigationClick = { navHostController.popBackStack()}
        )},

    ){innerPadding->
        LazyColumn (
            modifier = Modifier.padding(innerPadding)
        ){
            items(viewModel.users.size){index->
                val user = viewModel.getUser(index)
                UserCard(
                    users = user,
                    onDelete = {
                        viewModel.removeUser(user)
                    }
                )
                    }
        }
    }
}