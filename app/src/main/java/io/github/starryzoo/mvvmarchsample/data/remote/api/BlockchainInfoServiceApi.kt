package io.github.starryzoo.mvvmarchsample.data.remote.api


import io.github.starryzoo.mvvmarchsample.data.remote.model.MarketPriceInfo
import io.reactivex.Observable
import retrofit2.http.GET


interface BlockchainInfoServiceApi {

    @GET("ticker")
    fun getMarketPrice(): Observable<MarketPriceInfo>

}