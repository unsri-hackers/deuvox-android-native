package com.deuvox.utils

import com.deuvox.base.BaseResponse
import com.deuvox.data.BuildConfig
import com.deuvox.domain.base.Resource
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response
import timber.log.Timber
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

inline fun <reified T : Any> networkCall(block: () -> Observable<Response<BaseResponse<T>>>): Observable<Resource<T>> {
    return try {
        Observable.just(Resource.Loading)

        block().map { response ->
            when (response.code()) {
                in 200..226,
                in 300..308 -> {
                    Resource.Success(response.body()?.data)
                }
                in 400..451 -> {
                    Timber.e(response.getError())
                    Resource.Error.BadRequest(response.body().getError())
                }
                in 500..511 -> {
                    val error = response.getError()
                    Timber.e(error)

                    if (BuildConfig.DEBUG) {
                        Resource.Error.ServerError(error)
                    } else {
                        Resource.Error.ServerError("Sorry, there was an error on the server")
                    }
                }
                else -> throw IllegalArgumentException("Unknown HTTP Status Code: ${response.code()}")
            }
        }.subscribeOn(Schedulers.io())
    } catch (e: SocketTimeoutException) {
        Timber.e(e)
        Observable.just(Resource.Error.ConnectionTimeout("The connection has timed out"))
    } catch (e: Exception) {
        when (e) {
            is ConnectException, is UnknownHostException -> {
                Timber.e(e)
                Observable.just(
                    Resource.Error.ConnectionError(
                        "Unable to connect to server, please check your internet connection"
                    )
                )
            }
            else -> throw e
        }
    } catch (e: Exception) {
        Timber.e(e)
        Observable.just(Resource.Error.Unknown("Sorry, an unexpected error occurred"))
    }
}

fun Response<*>.getError(): String {
    return errorBody()?.charStream()?.readText() ?: "Failed to parse error message"
}

fun BaseResponse<*>?.getError(): String {
    return this?.message ?: "Failed to make a request"
}
