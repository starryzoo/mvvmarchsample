package io.github.starryzoo.mvvmarchsample.injection.module;


import dagger.Module
import dagger.Provides
import io.github.starryzoo.mvvmarchsample.BitcoinRepository
import io.github.starryzoo.mvvmarchsample.data.remote.api.BlockchainInfoServiceApi
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton


@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideBitcoinRepository(@Named("real") restAdapter: Retrofit): BitcoinRepository =
            BitcoinRepository(restAdapter.create(BlockchainInfoServiceApi::class.java))



}
