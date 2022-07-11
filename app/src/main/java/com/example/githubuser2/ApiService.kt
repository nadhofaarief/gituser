package com.example.githubuser2

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getSearchUser(
        @Query("q") query: String
    ): Call<ListUsersResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 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")
    fun getUserDetail(
        @Path("username") username: String?
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
}