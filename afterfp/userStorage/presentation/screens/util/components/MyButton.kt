package com.example.afterfp.userStorage.presentation.screens.util.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Save
import com.composables.icons.lucide.Trash

@Composable
fun SaveButton(onClick:()->Unit){
    OutlinedButton(
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        content = {
            Text(text = "Save!")
            Spacer(modifier = Modifier.padding(horizontal = 8.dp))
            Icon(Lucide.Save,"Save")
        }
    )
}

@Composable
fun DeleteButton(
    onClick: () -> Unit
){
    IconButton(
        onClick = onClick
    ) {
        Icon(Lucide.Trash,"Delete")
    }
}