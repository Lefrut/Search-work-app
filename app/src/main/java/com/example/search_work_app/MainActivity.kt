package com.example.search_work_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.search_work_app.di.ViewModelModule
import com.example.ui.theme.SearchworkappTheme
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin{
            androidLogger()
            androidContext(this@MainActivity)
            modules(ViewModelModule)
        }

        setContent {
            SearchworkappTheme {
                MenuScreen()
            }
        }
    }
}
