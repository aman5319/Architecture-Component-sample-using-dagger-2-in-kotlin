package com.amidezcod.androidarchdemousingeverything

import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

object Util {
    fun <T> executeAsynchronously(back: () -> T, front: T.() -> Unit = {}) {
        lateinit var dis: Disposable

        Single.fromCallable { back() }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<T?> {
                    override fun onSuccess(t: T) {
                        front(t)
                        dis.dispose()
                    }

                    override fun onSubscribe(d: Disposable) {
                        dis = d
                    }

                    override fun onError(e: Throwable) {}
                })
    }

}