package com.example.tecktailor.data.repository

import com.example.tecktailor.domain.repository.LoginDataSourceRepository

actual class LoginDataSourceRepositoryImpl : LoginDataSourceRepository {
    override suspend fun loginUser(email: String, password: String): String {
        TODO("Not yet implemented")
    }
}