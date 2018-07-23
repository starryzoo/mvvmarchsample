package io.github.starryzoo.mvvmarchsample.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.github.starryzoo.mvvmarchsample.BitcoinRepository
import io.github.starryzoo.mvvmarchsample.data.remote.model.MarketPriceInfo
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class MainViewModel @Inject constructor(private val bitcoinRepository: BitcoinRepository) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val currentMarketPrice = MutableLiveData<MarketPriceInfo>()

    init {
        loadData()
    }

    private fun loadData() {
        Observable.interval(0, 5, TimeUnit.SECONDS)
                .flatMap {
                    bitcoinRepository.getMarketPrice()
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    currentMarketPrice.postValue(it)
                })
                .apply { compositeDisposable.add(this) }
    }

    fun getCurrentMarketPrice(): MutableLiveData<MarketPriceInfo> = currentMarketPrice

}
