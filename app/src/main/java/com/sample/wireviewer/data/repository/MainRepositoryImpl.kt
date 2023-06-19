package com.sample.wireviewer.data.repository

import com.sample.wireviewer.data.CharacterListResponse
import com.sample.wireviewer.data.network.RetrofitInstance
import com.sample.wireviewer.util.Resource

class MainRepositoryImpl : MainRepository {
    override suspend fun getCharData(): Resource<CharacterListResponse> {
        return RetrofitInstance.api.getCharacters()
    }
}