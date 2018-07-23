package io.github.starryzoo.mvvmarchsample.application

import android.app.Application
import android.content.Context
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.github.starryzoo.mvvmarchsample.injection.component.DaggerAppComponent
import timber.log.Timber

class SampleApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

    init {
        instance = this
    }

    companion object {
        private var instance: SampleApplication? = null

        @JvmStatic fun applicationContext() : Context = instance!!.applicationContext
        @JvmStatic fun application() : Application = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        // initialize for any
        initialize()

    }

    private fun initialize() {
        Timber.uprootAll()
        Timber.plant(Timber.DebugTree())
    }



}
