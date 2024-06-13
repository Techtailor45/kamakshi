package com.example.tecktailor.data.repository

import android.content.Context
import com.example.tecktailor.R
import com.example.tecktailor.domain.repository.LoginDataSourceRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

actual class LoginDataSourceRepositoryImpl(
    private val context: Context
) : LoginDataSourceRepository {
    override suspend fun loginUser(email: String, password: String): String {
        return suspendCoroutine { continuation ->
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        try {
                            throw task.exception!!
                        } catch (invalidEmail: FirebaseAuthInvalidUserException) {
                            continuation.resume(context.getString(R.string.emailNotExists))
                        } catch (wrongPassword: FirebaseAuthInvalidCredentialsException) {
                            continuation.resume(context.getString(R.string.invalidEmailPassword))
                        } catch (e: Exception) {
                            continuation.resumeWithException(IllegalStateException(e.message))
                        }
                    } else {
                        continuation.resume("login Success")
                    }
                }.addOnFailureListener {
//                    continuation.resumeWithException(IllegalStateException(it.message))

                }
        }
    }

}