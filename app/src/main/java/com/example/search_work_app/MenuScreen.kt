package com.example.search_work_app

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MenuScreen(
    content: () -> Unit
) {
    Column {

    }
}


enum class MenuItem(
    @DrawableRes
    val imageId: Int,
    @StringRes
    val textId: Int
) {

}

@Composable
fun Menu(modifier: Modifier, currentItem: MenuItem) {

}