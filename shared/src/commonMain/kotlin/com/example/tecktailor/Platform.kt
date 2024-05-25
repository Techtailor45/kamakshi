package com.example.tecktailor

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform