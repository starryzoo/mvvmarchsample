package io.github.starryzoo.mvvmarchsample.ui.main

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import io.github.starryzoo.mvvmarchsample.ui.main.MainViewModelFactory
import io.github.starryzoo.mvvmarchsample.BitcoinRepository
import io.github.starryzoo.mvvmarchsample.injection.scope.ActivityScoped
import io.github.starryzoo.mvvmarchsample.injection.scope.FragmentScoped

@Module
abstract class MainModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun mainFragment(): MainFragment

    @Module
    companion object {
        @Provides
        @ActivityScoped
        @JvmStatic fun provideViewModelFactory(bitcoinRepository: BitcoinRepository) : MainViewModelFactory
                = MainViewModelFactory(bitcoinRepository)
    }

}
