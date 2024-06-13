package com.example.tecktailor.data.repository

import android.content.Context
import com.example.tecktailor.R
import com.example.tecktailor.domain.repository.RegisterDataSourceRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

actual class RegisterDataSourceRepositoryImpl(
    private val context: Context
) : RegisterDataSourceRepository {
    override suspend fun registerUser(name: String, email: String, password: String): String {
        return suspendCoroutine { continuation ->
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        try {
                            throw task.exception!!
                        } catch (weakPassword: FirebaseAuthWeakPasswordException) {
                            continuation.resume(context.getString(R.string.weakPasswordError))
                        } catch (malformedEmail: FirebaseAuthInvalidCredentialsException) {
                            continuation.resume(context.getString(R.string.malformedEmailError))
                        } catch (existEmail: FirebaseAuthUserCollisionException) {
                            continuation.resume(context.getString(R.string.emailAlreadyExistsError))
                        } catch (e: java.lang.Exception) {
                            continuation.resumeWithException(IllegalStateException(e.message))
                        }
                    } else {
                        continuation.resume("success")
                    }
                }.addOnFailureListener {
//                    continuation.resumeWithException(IllegalStateException(it.message))
                }
        }
    }
}

