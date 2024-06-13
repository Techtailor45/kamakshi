package com.example.tecktailor.domain.usecase

import com.example.tecktailor.core.Resource

actual class ValidateLoginInputUseCase {
    actual suspend operator fun invoke(
        email: String,
        password: String
    ): Resource<String> {
        TODO("Not yet implemented")
    }
}