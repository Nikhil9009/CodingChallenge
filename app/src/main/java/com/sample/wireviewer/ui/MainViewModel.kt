package com.sample.wireviewer.ui


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.wireviewer.data.CharacterListResponse
import com.sample.wireviewer.data.Meta
import com.sample.wireviewer.data.RelatedTopic
import com.sample.wireviewer.data.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(
   private val repository: MainRepository
) : ViewModel() {

    private var _charactersLiveData = MutableLiveData<CharacterListResponse>()
    var charactersLiveData = _charactersLiveData
     var relatedTopic: List<RelatedTopic>? = null

    private var _selectedCharacterLiveData = MutableLiveData<RelatedTopic>()
    var selectedCharacterLiveData = _selectedCharacterLiveData

    fun getCharacterData() {
        viewModelScope.launch {
            charactersLiveData.value = repository.getCharData().data
            relatedTopic = charactersLiveData.value?.relatedTopics
        }
    }

    fun setSelectedCharacter(selectedCharacter: RelatedTopic?) {
        selectedCharacterLiveData.value = selectedCharacter
    }
}