package com.deuvox.data.network

import com.deuvox.data.vo.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataNetworkRepository @Inject constructor(
    private val dataNetworkInterface: DataNetworkInterface
    ) {
    suspend fun loginRequest(username : String, password : String) : Flow<Resource<List<String>>> {
        return flow {
            emit(Resource.Loading)
            try {
                val result = dataNetworkInterface.loginRequest(username, password)
                emit(Resource.Success(result))
            }catch (e: Exception) {
                emit(Resource.Error("Ada Kesalahan"))
            }
        }
    }
}