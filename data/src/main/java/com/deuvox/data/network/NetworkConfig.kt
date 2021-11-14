package com.deuvox.data.network

import com.deuvox.deuvoxapp.di.module.HttpNetworkModule

class NetworkConfig {
    companion object {
        private const val BASE_URL = "https://private-bcf5ac-deuvox.apiary-mock.com"

        fun getNetworkInterface() : DataNetworkInterface {
            val httpClient = HttpNetworkModule().providesHttpClient()
            val retrofit = HttpNetworkModule().providesRetrofit(httpClient)
            return retrofit.create(DataNetworkInterface::class.java)
        }
    }
}