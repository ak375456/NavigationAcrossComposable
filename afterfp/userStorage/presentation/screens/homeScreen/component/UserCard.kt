package com.example.afterfp.userStorage.presentation.screens.homeScreen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.composables.icons.lucide.Figma
import com.composables.icons.lucide.Lucide
import com.example.afterfp.userStorage.domain.model.Users
import com.example.afterfp.userStorage.presentation.screens.util.components.DeleteButton
import com.example.afterfp.R

@Composable
fun UserCard(users: Users, onDelete: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.onSecondary,
                shape = RoundedCornerShape(15.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        // Layer the painted background separately
        Box(
            modifier = Modifier
                .matchParentSize()
                .paint(
                    painter = painterResource(R.drawable.rb),
                    contentScale = ContentScale.FillBounds,
                    colorFilter = ColorFilter.tint(Color.White.copy(alpha = 0.3f))
                )
        )
        Column(
            modifier = Modifier.padding(16.dp) // Add padding for inner content
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Person, contentDescription = null)
                Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                Text(text = "${users.name} ${users.lastName}")
            }
            Spacer(modifier = Modifier.padding(vertical = 4.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                    Icon(Lucide.Figma, contentDescription = null)
                    Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                    Text(text = users.number)
                }
                DeleteButton(onClick = onDelete) // Place the delete button at the end
            }
        }
    }
}

