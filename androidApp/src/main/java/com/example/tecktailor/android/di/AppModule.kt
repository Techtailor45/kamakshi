package com.example.tecktailor.android.di

import com.example.tecktailor.android.common.base.BaseSharedPreference
import org.koin.dsl.module

val AppModule = module {
    single<BaseSharedPreference> { BaseSharedPreference(get()) }
}