package com.deuvox.deuvoxapp.base.extension

import android.view.View
import com.jakewharton.rxbinding4.view.clicks
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

fun View.setThrottleClickListener(onClick: () -> Unit) {
    this.clicks()
        .throttleFirst(1000, TimeUnit.MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe { onClick() }
}