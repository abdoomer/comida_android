package com.example.comida.domain.dao

interface FBDatabaseDao {

    suspend fun getAllCollections()

    suspend fun getCollection(id: String)

    suspend fun updateCollection(id: String)

    suspend fun removeCollection(id: String)

    suspend fun getDocument(id: String)

    suspend fun updateDocument(id: String)

    suspend fun removeDocument(id: String)
}