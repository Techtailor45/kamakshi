package com.example.tecktailor.android.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//class PlaceHolderViewModel constructor(
//    private val getIntroImageUseCase: GetIntroImageUseCase
//) : ViewModel()
//{
//
//    fun getImageUrl(index: Int): LiveData<String> {
//        val imageUrlLiveData = MutableLiveData<String>()
//
//        viewModelScope.launch(Dispatchers.Main) {
//            try {
//                val imageUrl = getIntroImageUseCase.getImageUrl(index)
//                imageUrlLiveData.value = imageUrl
//            } catch (e: Exception) {
//                // Handle the exception
//            }
//        }
//
//        return imageUrlLiveData
//    }
//}