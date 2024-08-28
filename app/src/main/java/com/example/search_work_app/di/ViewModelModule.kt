package com.example.search_work_app.di

import com.example.login.LoginViewModel
import com.example.search_work_app.MenuViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val ViewModelModule = module {

    viewModelOf(::MenuViewModel)
    viewModelOf(::LoginViewModel)

}