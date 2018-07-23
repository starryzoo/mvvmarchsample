package io.github.starryzoo.mvvmarchsample.data.remote

import io.github.starryzoo.mvvmarchsample.data.remote.model.MarketPriceInfo
import io.reactivex.Observable

interface BlockChainInfoSource {

    fun getMarketPrice() : Observable<MarketPriceInfo>

}