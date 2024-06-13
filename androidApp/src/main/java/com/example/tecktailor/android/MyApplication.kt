package com.example.tecktailor.android

import android.app.Application
import com.google.firebase.FirebaseApp
import com.example.tecktailor.android.di.setupKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeDependencies()
        FirebaseApp.initializeApp(this)
    }
    private fun initializeDependencies() {
        setupKoin(this)
    }
}