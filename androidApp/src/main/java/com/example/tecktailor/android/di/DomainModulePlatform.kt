package com.example.tecktailor.android.di

import com.example.tecktailor.domain.usecase.ValidateLoginInputUseCase
import com.example.tecktailor.domain.usecase.ValidateRegisterInputUseCase
import com.google.firebase.auth.FirebaseAuth
import org.koin.core.module.Module
import org.koin.dsl.module

val DomainModulePlatform: Module = module {
    //TODO  shi jgh rkhna hai file ko
//    single {
//        FirebaseAuth.getInstance()
//    }

    single {
        ValidateLoginInputUseCase(get(),get())
    }
    single {
        ValidateRegisterInputUseCase(get(),get())
    }
//    single {
//        ResetPasswordUseCase(get(),get())
//    }
//    single {
//        LogoutUseCase(get())
//    }

}