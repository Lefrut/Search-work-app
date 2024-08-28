package com.example.search_work_app

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.login.LoginScreen
import com.example.navigation.Screen
import com.example.resources.R
import com.example.ui.theme.Colors
import com.example.ui.theme.Fonts
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.androidx.compose.koinViewModel

@Composable
fun MenuScreen() {
    val viewModel = koinViewModel<MenuViewModel>()
    val currentMenuItem by viewModel.currentMenuItem.collectAsState()
    val currentScreen by viewModel.currentScreen.collectAsState()

    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        {
            when (currentScreen) {
                Screen.Login -> {
                    LoginScreen()
                }

                Screen.Home -> {

                }
            }
        }
        Menu(currentItem = currentMenuItem)
    }
}

enum class MenuItem(
    @DrawableRes
    val imageId: Int,
    @StringRes
    val textId: Int
) {
    Home(R.drawable.search, R.string.search),
    Favorite(R.drawable.heart, R.string.favorite),
    Response(R.drawable.mail, R.string.response),
    Messages(R.drawable.message, R.string.messages),
    Profile(R.drawable.profile, R.string.profile)
}

class MenuViewModel : ViewModel() {

    val currentMenuItem = MutableStateFlow(MenuItem.Home)
    val currentScreen = MutableStateFlow(Screen.Login)

}


@Composable
fun Menu(modifier: Modifier = Modifier, currentItem: MenuItem) {

    val menuItems = remember {
        MenuItem.values()
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = Colors.surfaceVariant)
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        menuItems.forEach { menuItem ->
            MenuIcon(
                menuItem = menuItem, modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1.2f),
                selected = menuItem == currentItem
            )
        }
    }
}

@Composable
fun MenuIcon(menuItem: MenuItem, modifier: Modifier = Modifier, selected: Boolean) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(3.dp, Alignment.CenterVertically)
    ) {
        Icon(
            painter = painterResource(id = menuItem.imageId),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .padding(2.dp),
            tint = if (!selected) Colors.tab else Colors.secondary

        )
        Text(
            text = stringResource(menuItem.textId),
            style = Fonts.tabText,
            color = if (!selected) Colors.tab else Colors.secondary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}