package com.example.tecktailor.domain.repository


interface RegisterDataSourceRepository {

    suspend fun registerUser(name:String, email:String, password: String):String
}