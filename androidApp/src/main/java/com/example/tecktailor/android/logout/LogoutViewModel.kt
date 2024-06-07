package com.example.tecktailor.android.logout

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zobaze.polyverse.presentation.logout.LogoutDetailsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//class LogoutViewModel(
//    private val context: Context,
//    private val logoutUseCase: LogoutUseCase
//) : ViewModel()
//{
//
//    private val _logoutMessage = MutableStateFlow(LogoutDetailsState())
//    val logoutMessage: StateFlow<LogoutDetailsState> = _logoutMessage
//
//    fun logout() {
//        viewModelScope.launch {
//            try {
//                _logoutMessage.value = LogoutDetailsState(isLoading = true)
//                withContext(Dispatchers.IO) {
//                    logoutUseCase.invoke()
//                }
//                _logoutMessage.value =
//                    LogoutDetailsState(data = context.getString(R.string.logoutSuccessful))
//            } catch (e: Exception) {
//                _logoutMessage.value = LogoutDetailsState(
//                    error = context.getString(
//                        R.string.errorLoggingOut,
//                        e.message
//                    )
//                )
//            }
//        }
//    }
//}
