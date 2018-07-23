package io.github.starryzoo.mvvmarchsample.injection.module;

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.starryzoo.mvvmarchsample.MainActivity
import io.github.starryzoo.mvvmarchsample.ui.main.MainModule
import io.github.starryzoo.mvvmarchsample.injection.scope.ActivityScoped

@Module
abstract class ActivityModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [(MainModule::class)])
    abstract fun mainActivity(): MainActivity

}
