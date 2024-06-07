package com.zobaze.polyverse.presentation.logout

data class LogoutDetailsState(
    val isLoading: Boolean = false,
    val data: String? = null,
    val error: String = ""
)
