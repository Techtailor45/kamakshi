package com.example.tecktailor.data.repository

import com.example.tecktailor.domain.repository.RegisterDataSourceRepository

actual class RegisterDataSourceRepositoryImpl : RegisterDataSourceRepository {
    override suspend fun registerUser(name: String, email: String, password: String): String {
        TODO("Not yet implemented")
    }
}