package com.dbstudio.truyenqq.ui.base

import android.support.v7.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Copyright © 2017 AsianTech inc.
 * @author doan.bien on 3/26/18.
 */
abstract class BaseActivity : AppCompatActivity() {

    abstract fun onBindViewModel()

    private val subscription: CompositeDisposable = CompositeDisposable()

    override fun onResume() {
        super.onResume()
        onBindViewModel()
    }

    override fun onPause() {
        super.onPause()
        subscription.clear()
    }

    protected fun addDisposable(vararg ds: Disposable) {
        ds.forEach { subscription.add(it) }
    }
}
