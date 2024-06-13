package com.example.tecktailor.domain.usecase

import android.content.Context
import com.example.tecktailor.R
import com.example.tecktailor.core.Resource
import com.example.tecktailor.domain.repository.RegisterDataSourceRepository
import java.io.IOException

actual class ValidateRegisterInputUseCase(
    private val context: Context,
    private val repository: RegisterDataSourceRepository
) {
    actual suspend operator fun invoke(
        name: String, email: String, password: String,
    ): Resource<String> {
        return try {
            val data = repository.registerUser(name,email, password)
            Resource.Success(data = data)
        } catch (e: IOException) {
            Resource.Error(message = e.localizedMessage ?: context.getString(R.string.checkConnectivityError))
        } catch (e: Exception) {
            Resource.Error(message = context.getString(R.string.unknownError, e.message))
        }
    }
}