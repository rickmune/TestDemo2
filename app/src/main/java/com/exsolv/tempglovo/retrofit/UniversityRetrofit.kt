package com.exsolv.tempglovo.retrofit

import retrofit2.http.GET

interface UniversityRetrofit {
    @GET("search?country=Kenya")
    suspend fun get(): List<UniversityNetworkEntity>
}