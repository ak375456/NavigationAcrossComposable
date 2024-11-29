package com.example.afterfp.userStorage.presentation.screens.homeScreen

import MyAppBar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.composables.icons.lucide.Forward
import com.composables.icons.lucide.Hash
import com.composables.icons.lucide.Lucide
import com.example.afterfp.ViewModelForDetails
import com.example.afterfp.userStorage.domain.model.Users
import com.example.afterfp.userStorage.presentation.screens.homeScreen.component.UserCard

import com.example.afterfp.userStorage.presentation.screens.util.components.SaveButton
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(navHostController: NavHostController,viewModel: ViewModelForDetails){

    var nameField by remember { mutableStateOf("") }
    var lastNameField by remember { mutableStateOf("") }
    var numberField by remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current

    val scrollState = rememberScrollState()

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = {MyAppBar("Home Screen")},
        snackbarHost = { SnackbarHost(snackbarHostState) },
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navHostController.navigate(route = "detailsScreen")
                }
            ) {
                Icon(Lucide.Forward, "")
            }
        }
    ) { innerPadding ->

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(state = scrollState)

        ) {
            OutlinedTextField(
                value = nameField,
                onValueChange = { name ->
                    nameField = name
                },
                label = { Text("Name") },
                prefix = { Icon(Icons.Default.Person, " ") }
            )
            OutlinedTextField(
                value = lastNameField,
                onValueChange = { lastName ->
                    lastNameField = lastName
                },
                label = { Text("Last Name") },
                prefix = { Icon(Icons.Default.Person, " ") }
            )
            OutlinedTextField(
                value = numberField,
                onValueChange = { number ->
                    numberField = number
                },
                label = { Text("Number") },
                prefix = { Icon(Lucide.Hash, " ") }
            )
            LazyColumn(
                modifier = Modifier.height(200.dp)
            ) {
                if (viewModel.users.isEmpty()) {
                    item {
                        Text("No Users!", modifier = Modifier.padding(16.dp))
                    }
                } else {
                    items(viewModel.users.size) { index ->

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
            SaveButton {
                if (nameField.isEmpty() || lastNameField.isEmpty() || numberField.isEmpty()) {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            "Snackbar #",
                            duration = SnackbarDuration.Short
                        )
                    }
                } else {
                    viewModel.addUser(Users(nameField, lastNameField, numberField))
                    nameField = ""
                    lastNameField = ""
                    numberField = ""
                    focusManager.clearFocus()
                }
            }
        }
    }
}