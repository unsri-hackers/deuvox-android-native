package com.deuvox.deuvoxapp.base.extension

import android.widget.EditText
import com.jakewharton.rxbinding4.widget.textChangeEvents
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun EditText.setOnDebounceSearchListener(onSearch: (text: String) -> Unit) {
    this.textChangeEvents()
        .debounce(1000, TimeUnit.MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe { onSearch(it.text.toString()) }
}