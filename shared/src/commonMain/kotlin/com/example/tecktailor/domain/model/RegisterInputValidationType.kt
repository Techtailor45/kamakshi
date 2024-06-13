package com.example.tecktailor.domain.model

enum class RegisterInputValidationType {
    EmptyField,
    NoName,
    NoEmail,
    PasswordNumberMissing,
    PasswordTooShort,
    Valid
}