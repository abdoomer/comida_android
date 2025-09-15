package com.example.comida.domain.dao

import androidx.fragment.app.FragmentActivity
import com.example.comida.models.ResourceResult
import com.example.comida.models.firebase.SignUpResult
import kotlinx.coroutines.flow.Flow

interface FirebaseDao {

    suspend fun createNewUserWithEmailPassword(email: String, password: String, onComplete: (Boolean, String?) -> Unit)

    suspend fun signInUserWithEmailPassword(email: String, password: String, onComplete: (Boolean, String?) -> Unit)

    suspend fun signInUserWithGoogle(onComplete: (Boolean, String?) -> Unit)

    suspend fun signInUserWithFacebook(onComplete: (Boolean, String?) -> Unit)

    suspend fun signOutUserWithEmailPassword(onComplete: (Boolean, String?) -> Unit)

    suspend fun signOutUserWithGoogleSignUp(onComplete: (Boolean, String?) -> Unit)

    suspend fun signOut(onComplete: (Boolean, String?) -> Unit)

    suspend fun getAllCollections()

    suspend fun getCollection(id: String)

    suspend fun updateCollection(id: String)

    suspend fun removeCollection(id: String)

    suspend fun getDocument(id: String)

    suspend fun updateDocument(id: String)

    suspend fun removeDocument(id: String)
}