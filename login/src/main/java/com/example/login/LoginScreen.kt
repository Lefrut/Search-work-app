package com.example.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.resources.R
import com.example.ui.theme.Colors
import com.example.ui.theme.Fonts
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.androidx.compose.koinViewModel


enum class LoginStage {
    One, Two
}

class LoginViewModel : ViewModel() {

    val currentStage = MutableStateFlow(LoginStage.One)

}

@Composable
fun LoginScreen() {
    val loginViewModel = koinViewModel<LoginViewModel>()
    val loginStage by loginViewModel.currentStage.collectAsState()

    when (loginStage) {
        LoginStage.One -> {
            FirstLoginStage()
        }

        LoginStage.Two -> {
            SecondLoginStage()
        }
    }
}

@Composable
fun FirstLoginStage() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            modifier = Modifier.padding(top = 64.dp),
            text = stringResource(R.string.login_title),
            color = Colors.onSurface,
            style = Fonts.title2,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.weight(1f))
        AppCard {
            Text(
                text = stringResource(R.string.search_work),
                color = Colors.onSurface,
                style = Fonts.title3,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        AppCard {
            Text(
                text = stringResource(R.string.search_persons),
                color = Colors.onSurface,
                style = Fonts.title3,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.weight(1.4f))
    }
}

@Composable
fun AppCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Colors.surfaceVariant, shape = RoundedCornerShape(8.dp))
            .padding(vertical = 24.dp, horizontal = 16.dp)
    ) {
        content()
    }
}

@Composable
fun SecondLoginStage() {

}

