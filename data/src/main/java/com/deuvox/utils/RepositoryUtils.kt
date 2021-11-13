package com.deuvox.utils

import com.deuvox.domain.base.Resource
import io.reactivex.rxjava3.core.Observable

inline fun <T, R> Observable<Resource<T>>.mapResource(crossinline transform: (value: T?) -> R): Observable<Resource<R>> {
    return map { resource ->
        when (resource) {
            is Resource.Success -> Resource.Success(transform(resource.data))
            is Resource.Error.BadRequest -> resource
            is Resource.Error.ConnectionError -> resource
            is Resource.Error.ConnectionTimeout -> resource
            is Resource.Error.ServerError -> resource
            is Resource.Error.Unknown -> resource
            Resource.Loading -> Resource.Loading
        }
    }
}
