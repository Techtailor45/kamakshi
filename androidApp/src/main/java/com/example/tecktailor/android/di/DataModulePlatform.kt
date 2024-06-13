package com.example.tecktailor.android.di

import com.example.tecktailor.data.repository.LoginDataSourceRepositoryImpl
import com.example.tecktailor.data.repository.RegisterDataSourceRepositoryImpl
import com.example.tecktailor.domain.repository.LoginDataSourceRepository
import com.example.tecktailor.domain.repository.RegisterDataSourceRepository
import org.koin.dsl.module

val DataModulePlatform = module {

    //TODO  shi jgh rkhna hai file ko
//    single<FirebaseEventDataSourceRepository> {
//        FirebaseEventDataSourceImpl()
//    }

    single<LoginDataSourceRepository> {
        LoginDataSourceRepositoryImpl(get())
    }
    single<RegisterDataSourceRepository> {
        RegisterDataSourceRepositoryImpl(get())
    }
}
