package com.example.tecktailor.domain.repository


interface LoginDataSourceRepository {

    suspend fun loginUser(email: String, password:String): String

}