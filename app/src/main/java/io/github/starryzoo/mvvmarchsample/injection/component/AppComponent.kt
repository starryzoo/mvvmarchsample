package io.github.starryzoo.mvvmarchsample.injection.component;


import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import io.github.starryzoo.mvvmarchsample.injection.module.ActivityModule
import io.github.starryzoo.mvvmarchsample.injection.module.ApplicationModule
import io.github.starryzoo.mvvmarchsample.injection.module.NetworkDataModule
import io.github.starryzoo.mvvmarchsample.injection.module.RepositoryModule
import io.github.starryzoo.mvvmarchsample.application.SampleApplication
import javax.inject.Singleton


@Singleton
@Component(modules = [
    (ApplicationModule::class),
    (ActivityModule::class),
    (NetworkDataModule::class),
    (RepositoryModule::class),
    (AndroidSupportInjectionModule::class)])

interface AppComponent : AndroidInjector<SampleApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder
        fun build(): AppComponent
    }
}
