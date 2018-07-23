package io.github.starryzoo.mvvmarchsample

import io.github.starryzoo.mvvmarchsample.data.remote.BlockChainInfoSource
import io.github.starryzoo.mvvmarchsample.data.remote.api.BlockchainInfoServiceApi
import io.reactivex.schedulers.Schedulers

class BitcoinRepository(var blockchainInfoServiceApi: BlockchainInfoServiceApi) : BlockChainInfoSource {

    override fun getMarketPrice() = blockchainInfoServiceApi.getMarketPrice().subscribeOn(Schedulers.io())


}
