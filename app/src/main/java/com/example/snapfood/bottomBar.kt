package com.example.snapfood

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.snapfood.ui.theme.ActiveColor
import com.example.snapfood.ui.theme.best


@Composable
fun bottomBar() {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(
        modifier = Modifier.fillMaxWidth(),

        backgroundColor = Color.White,
        contentColor = Color.Black,
        elevation = 8.dp//your elevation value in Dp
    ) {


        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.Home, "")
            },
            label = { Text(text = "خانه", fontFamily = best) },
            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
            },
            selectedContentColor = ActiveColor,
            unselectedContentColor = Color.Black,
        )

        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.Info, "")
            },
            label = { Text(text = "سفارش ها", fontFamily = best) },
            selected = (selectedIndex.value == 1),
            onClick = {
                selectedIndex.value = 1
            },
            selectedContentColor = ActiveColor,
            unselectedContentColor = Color.Black,
        )


        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.Person, "")
            },
            label = { Text(text = "پروفایل", fontFamily = best) },
            selected = (selectedIndex.value == 2),
            onClick = {
                selectedIndex.value = 2
            },
            selectedContentColor = ActiveColor,
            unselectedContentColor = Color.Black,
        )


    }
}