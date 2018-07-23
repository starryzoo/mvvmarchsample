package io.github.starryzoo.mvvmarchsample.data.remote.model

import com.google.gson.annotations.SerializedName

class MarketPriceInfo(@SerializedName("USD") val usd: Price,
                      @SerializedName("JPY") val jpy: Price,
                      @SerializedName("CNY") val cny: Price,
                      @SerializedName("SGD") val sgd: Price,
                      @SerializedName("HKD") val hkd: Price,
                      @SerializedName("CAD") val cad: Price,
                      @SerializedName("NZD") val nzd: Price,
                      @SerializedName("AUD") val aud: Price,
                      @SerializedName("CLP") val clp: Price,
                      @SerializedName("GBP") val gbp: Price,
                      @SerializedName("DKK") val dkk: Price,
                      @SerializedName("SEK") val sek: Price,
                      @SerializedName("ISK") val isk: Price,
                      @SerializedName("CHF") val chf: Price,
                      @SerializedName("BRL") val brl: Price,
                      @SerializedName("EUR") val eur: Price,
                      @SerializedName("RUB") val rub: Price,
                      @SerializedName("PLN") val pln: Price,
                      @SerializedName("THB") val thb: Price,
                      @SerializedName("KRW") val krw: Price,
                      @SerializedName("TWD") val twd: Price) {

    inner class Price(@SerializedName("15m") val interval: Double,
                      @SerializedName("last") val last: Double,
                      @SerializedName("buy") val buy: Double,
                      @SerializedName("sell") val sell: Double,
                      @SerializedName("symbol") val symbol: String)
    }

