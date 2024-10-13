package com.example.mp

import retrofit2.http.GET

interface ParliamentApiService {
    @GET("seating.json")
    suspend fun getParliamentMembers(): List<ParliamentMember>
}