package com.sample.wireviewer.data.repository

import com.sample.wireviewer.data.CharacterListResponse
import com.sample.wireviewer.util.Resource

interface MainRepository {
    suspend fun getCharData() : Resource<CharacterListResponse>
}