package com.deuvox.utils

import com.deuvox.base.BaseResponse
import com.deuvox.data.BuildConfig
import com.deuvox.domain.base.Resource
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import timber.log.Timber
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

inline fun <reified T : Any> networkCall(crossinline block: () -> Observable<Response<BaseResponse<T>>>): Observable<Resource<T>> {
    return try {
        Observable.create { emitter ->
            emitter.onNext(Resource.Loading)

            val response = block().blockingSingle()
            when (response.code()) {
                in 200..226,
                in 300..308 -> {
                    emitter.onNext(Resource.Success(response.body()?.data))
                }
                in 400..451 -> {
                    Timber.e(response.getError())
                    emitter.onNext(Resource.Error.BadRequest(response.body().getError()))
                }
                in 500..511 -> {
                    val error = response.getError()
                    Timber.e(error)

                    if (BuildConfig.DEBUG) {
                        emitter.onNext(Resource.Error.ServerError(error))
                    } else {
                        emitter.onNext(Resource.Error.ServerError("Sorry, there was an error on the server"))
                    }
                }
                else -> throw IllegalArgumentException("Unknown HTTP Status Code: ${response.code()}")
            }
        }
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
