package com.example.tecktailor.android.di

import com.example.tecktailor.android.loginregisterauth.LoginViewModel
import com.example.tecktailor.android.loginregisterauth.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val PresentationModule = module {
    //TODO  shi jgh rkhna hai file ko
    viewModel {
        LoginViewModel(get(), get())
    }
    viewModel {
        RegisterViewModel(get(), get())
    }
}