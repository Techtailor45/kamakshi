package com.example.tecktailor.android.events

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

//class EventsViewModel(private val firebaseEventUseCase: FirebaseEventUseCase) : ViewModel() {
//
//    fun addEvent(eventName: String, bundle: Bundle? = null) {
//        viewModelScope.launch {
//            firebaseEventUseCase.logEvent(eventName,bundle)
//        }
//    }
//}