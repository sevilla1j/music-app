package com.jsevilla.musicapp.data.common

import android.content.Context
import com.google.gson.GsonBuilder
import com.jsevilla.musicapp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiService internal constructor(private val baseUrl: String?) {
    fun <S> create(clazz: Class<S>?): S {
        return create(
            null, clazz, baseUrl, null
        )
    }

    fun <S> create(clazz: Class<S>?, baseUrl: String?): S {
        return create(
            null, clazz, baseUrl, null
        )
    }

    fun <S> create(clazz: Class<S>?, baseUrl: String?, token: String?): S {
        return create(
            null, clazz, baseUrl, token
        )
    }

    fun <S> create(
        context: Context?, clazz: Class<S>?, baseUrl: String?, token: String?
    ): S {
        val retrofit = createBuilder(baseUrl)
            .client(createClient(token))
            .build()
        return retrofit.create(clazz!!)
    }

    private fun createClient(token: String?): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level =
            if (BuildConfig.IS_DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
            token?.let {
                requestBuilder.addHeader("Authorization", it)
            }

            val request = requestBuilder.build()
            chain.proceed(request)
        }

        httpClient.connectTimeout(30, TimeUnit.SECONDS)
        httpClient.readTimeout(30, TimeUnit.SECONDS)
        httpClient.writeTimeout(30, TimeUnit.SECONDS)
        httpClient.addNetworkInterceptor(logging)

        return httpClient.build()
    }

    private fun createBuilder(baseUrl: String?): Retrofit.Builder {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .baseUrl(baseUrl!!)
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    class Builder {
        private var baseUrl: String? = null
        private var connectTimeout = CONNECT_TIMEOUT
        private var readTimeout = READ_TIMEOUT
        private var writeTimeout = WRITE_TIMEOUT

        fun baseUrl(baseUrl: String?): Builder {
            this.baseUrl = baseUrl
            return this
        }

        fun connectTimeout(connectTimeout: Long): Builder {
            this.connectTimeout = connectTimeout
            return this
        }

        fun readTimeout(readTimeout: Long): Builder {
            this.readTimeout = readTimeout
            return this
        }

        fun writeTimeout(writeTimeout: Long): Builder {
            this.writeTimeout = writeTimeout
            return this
        }

        fun build(): ApiService {
            return ApiService(
                baseUrl
            )
        }
    }

    companion object {
        private const val CONNECT_TIMEOUT: Long = 120
        private const val READ_TIMEOUT: Long = 120
        private const val WRITE_TIMEOUT: Long = 120
    }
}
