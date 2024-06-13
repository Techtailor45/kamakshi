package com.example.tecktailor.domain.usecase

import com.example.tecktailor.core.Resource

actual class ValidateRegisterInputUseCase {
    actual suspend operator fun invoke(
        name: String,
        email: String,
        password: String
    ): Resource<String> {
        TODO("Not yet implemented")
    }
}