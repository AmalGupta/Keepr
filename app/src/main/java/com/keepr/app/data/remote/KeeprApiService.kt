package com.keepr.app.data.remote

import retrofit2.http.GET

interface KeeprApiService {
    
    @GET("health")
    suspend fun healthCheck(): String
    
    // Add your API endpoints here
}
