package com.onuryasarkaraduman

import com.onuryasarkaraduman.common.BadRequestException
import com.onuryasarkaraduman.common.NetworkException
import com.onuryasarkaraduman.common.NotFoundException
import com.onuryasarkaraduman.common.Resource
import com.onuryasarkaraduman.common.UnknownException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import retrofit2.HttpException
import java.io.IOException

suspend fun <T : Any> safeApiCall(apiToBeCalled: suspend () -> T): Resource<T> {
    return withContext(Dispatchers.IO) {
        try {
            Resource.Success(apiToBeCalled())
        } catch (e: HttpException) { // HTTP hataları (400, 401, 404, vs.) burada yakalanır
            val errorBody = e.response()?.errorBody()?.string().orEmpty()
            val message = try {
                // Gelen JSON içindeki "error" nesnesinin içerisinden "message" değerini alıyoruz.
                val jsonElement = Json.parseToJsonElement(errorBody)
                jsonElement.jsonObject["error"]?.jsonObject?.get("message")?.jsonPrimitive?.content.orEmpty()
            } catch (ex: Exception) {
                ""
            }.ifEmpty {
                "An unknown error occurred, please try again later."
            }

            when (e.code()) {
                400 -> Resource.Error(BadRequestException(message))
//                401 -> Resource.Error(AuthorizationException(message))
                404 -> Resource.Error(NotFoundException(message))
                else -> Resource.Error(UnknownException(message))
            }
        } catch (e: IOException) {
            Resource.Error(NetworkException())
        } catch (e: Exception) {
            Resource.Error(UnknownException())
        }
    }
}