package com.example.foodordering.Activity.Dashboard

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodordering.R

data class BottomMenuItem(
    val label: String,
    val icon: Painter
)

@Preview
@Composable
fun MyBottomBar(){
    val bottomMenuItemsList = prepareBottomMenu()
    val context = LocalContext.current
    var selectedIem by remember { mutableStateOf("Home") }

    BottomAppBar (
        backgroundColor = colorResource(R.color.grey),
        elevation = 3.dp
    ) {
        bottomMenuItemsList.forEach {
            bottomMenuItem ->
            BottomNavigationItem(
                selected = (selectedIem == bottomMenuItem.label),
                onClick = {
                    selectedIem = bottomMenuItem.label
                },
                icon = {
                    Icon(
                        painter = bottomMenuItem.icon,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .size(20.dp))
                },
            )
        }
    }
}

@Composable
fun prepareBottomMenu(): List<BottomMenuItem> {
    val bottomMenuItemList = arrayListOf<BottomMenuItem>()

    bottomMenuItemList.add(BottomMenuItem(label = "Home", icon = painterResource(R.drawable.btn_1)))
    bottomMenuItemList.add(BottomMenuItem(label = "Cart", icon = painterResource(R.drawable.btn_2)))
    bottomMenuItemList.add(BottomMenuItem(label = "Favorite", icon = painterResource(R.drawable.btn_3)))
    bottomMenuItemList.add(BottomMenuItem(label = "Order", icon = painterResource(R.drawable.btn_4)))
    bottomMenuItemList.add(BottomMenuItem(label = "Profile", icon = painterResource(R.drawable.btn_5)))

    return bottomMenuItemList
}

