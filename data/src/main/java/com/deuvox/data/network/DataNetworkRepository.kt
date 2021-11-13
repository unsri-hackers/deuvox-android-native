package com.deuvox.data.network

import com.deuvox.data.vo.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataNetworkRepository @Inject constructor(
    private val dataNetworkInterface: DataNetworkInterface) {
    suspend fun loginRequest() : Flow<Resource<List<String>>> {
        return flow {
            emit(Resource.loading())
            try {
                val result = dataNetworkInterface.loginRequest()
                emit(Resource.success(result))
            }catch (e: Exception) {
                emit(Resource.error("Ada Kesalahan"))
            }
        }
    }
}