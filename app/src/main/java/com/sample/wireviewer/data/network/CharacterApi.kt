package com.sample.wireviewer.data.network

import com.sample.wireviewer.data.CharacterListResponse
import com.sample.wireviewer.util.Resource
import retrofit2.http.GET

interface CharacterApi {
    @GET
    suspend fun getCharacters(): Resource<CharacterListResponse>
}