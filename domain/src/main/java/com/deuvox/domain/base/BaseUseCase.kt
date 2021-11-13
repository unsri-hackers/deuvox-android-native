package com.deuvox.domain.base

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.functions.Action
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class BaseUseCase<Type : Any, Param>(
    private val jobScheduler: Scheduler = Schedulers.io(),
    private val postScheduler: Scheduler = AndroidSchedulers.mainThread()
) {
    private val disposable = CompositeDisposable()

    abstract fun buildUseCase(params: Param): Observable<Type>

    fun execute(
        params: Param,
        onSuccess: (Type) -> Unit,
        onError: (t: Throwable) -> Unit = {},
    ) {
        doOnExecute(params, onSuccess, onError, {}, {})
    }

    fun execute(
        params: Param,
        onSuccess: (Type) -> Unit,
        onError: (t: Throwable) -> Unit = {},
        onComplete: () -> Unit = {}
    ) {
        doOnExecute(params, onSuccess, onError, onComplete, {})
    }

    private fun doOnExecute(
        params: Param,
        onSuccess: (Type) -> Unit,
        onError: (t: Throwable) -> Unit = {},
        onComplete: () -> Unit = {},
        onDispose: Action = Action {}
    ) {
        buildUseCase(params)
            .subscribeOn(jobScheduler)
            .observeOn(postScheduler)
            .doOnDispose(onDispose)
            .subscribe({
                onSuccess(it)
            }, {
                onError(it)
                dispose()
            }, {
                onComplete()
                dispose()
            })
            .run {
                disposable.add(this)
            }
    }

    fun dispose() {
        disposable.clear()
    }
}