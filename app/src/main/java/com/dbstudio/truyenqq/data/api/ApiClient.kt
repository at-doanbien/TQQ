package com.dbstudio.truyenqq.data.api

import com.dbstudio.truyenqq.BuildConfig
import com.dbstudio.truyenqq.Common.Constant
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Copyright © 2017 AsianTech inc.
 * @author doan.bien on 3/26/18.
 */
object ApiClient {

    val instance : ApiService by lazy {
        val httpClient = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }
        val retrofit = Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .create()))
                .client(httpClient.build())
                .build()
        retrofit.create(ApiService::class.java)
    }
}
