package io.github.starryzoo.mvvmarchsample.ui.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import io.github.starryzoo.mvvmarchsample.BitcoinRepository

class MainViewModelFactory(val bitcoinRepository: BitcoinRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return MainViewModel(bitcoinRepository) as T
    }

}

