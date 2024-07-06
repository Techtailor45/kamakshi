package com.example.tecktailor.android.landingScreen

import androidx.lifecycle.ViewModel
import com.example.tecktailor.android.common.base.BaseSharedPreference
import com.example.tecktailor.utils.Constants.IS_USER_LOGGED_IN

class SignOutViewModel(
    private val sharedPreference: BaseSharedPreference,
) : ViewModel() {

    fun signOut() {
        sharedPreference.put(IS_USER_LOGGED_IN, false)
    }
}