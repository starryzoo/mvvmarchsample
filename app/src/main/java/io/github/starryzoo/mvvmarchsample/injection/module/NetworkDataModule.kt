package io.github.starryzoo.mvvmarchsample.injection.module;

import android.app.Application
import dagger.Module
import dagger.Provides
import io.github.starryzoo.mvvmarchsample.application.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import javax.security.cert.CertificateException


@Module
class NetworkDataModule {

    @Provides
    @Named("test")
    @Singleton
    fun provideRestAdapter(application : Application, okHttpClient : OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl(Constants.TESTNET_BLOCHAIN_INFO_URL)
                .build()
    }

    @Provides
    @Named("real")
    @Singleton
    fun provideRestRealAdapter(application : Application, okHttpClient : OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl(Constants.REAL_BLOCHAIN_INFO_URL)
                .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(sslSocketFactory : SSLSocketFactory, trustAllCerts : Array<TrustManager>): OkHttpClient {
        val builder = OkHttpClient.Builder().apply {
            sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            hostnameVerifier { _, _ -> true }
            readTimeout(Constants.READ_TIMEOUT_MILLISECONDS, TimeUnit.MILLISECONDS)
            writeTimeout(Constants.WRITE_TIMEOUT_MILLISECONDS, TimeUnit.MILLISECONDS)
            connectTimeout(Constants.CONNECT_TIMEOUT_MILLISECONDS, TimeUnit.MILLISECONDS)
            addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
        }
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideSSLSocketFactory(trustAllCerts : Array<TrustManager>) : SSLSocketFactory {
        // Install the all-trusting trust manager
        val sslContext = SSLContext.getInstance("SSL").apply {
            init(null, trustAllCerts, java.security.SecureRandom())
        }
        // Create an ssl socket factory with our all-trusting manager
        return sslContext.socketFactory
    }

    @Provides
    @Singleton
    fun provideTrustAllCerts() : Array<TrustManager> {
        return arrayOf(object : X509TrustManager {
            @Throws(CertificateException::class)
            override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
            }

            @Throws(CertificateException::class)
            override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
            }

            override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
        })
    }


}
