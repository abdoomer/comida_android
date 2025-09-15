package com.example.comida.domain.repository

import com.example.comida.di.AppCoroutineScope
import com.example.comida.domain.dao.FBDatabaseDao
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class FBDatabaseRepository @Inject constructor(
    private val appCoroutineScope: AppCoroutineScope,
    private val firebaseRepository: FirebaseRepository
): FBDatabaseDao {
    override suspend fun getAllCollections() {
        TODO("Not yet implemented")
    }

    override suspend fun getCollection(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateCollection(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun removeCollection(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getDocument(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateDocument(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun removeDocument(id: String) {
        TODO("Not yet implemented")
    }

}