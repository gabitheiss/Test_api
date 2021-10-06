package com.example.marvel_app.repository

import com.example.marvel_app.services.MarvelServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class MarvelRepository @Inject constructor(private val service : MarvelServices) {

    suspend fun fetchCharacter() : Character? {
        return withContext(Dispatchers.Default){
            val response = service.getAll(ts = "1", apikey = "cee505bb39748d332c295036d51393b9", hash = "2ab26aa6e773b91466ed1da1140c922d")
            val processedResponse = processData(response)
            println(processedResponse)
            processedResponse
        }
    }
    private fun <T> processData(response: Response<T>) : T?{
        return if (response.isSuccessful) response.body()
        else null
    }
}