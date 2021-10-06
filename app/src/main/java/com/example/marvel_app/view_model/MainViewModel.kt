package com.example.marvel_app.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel_app.model.Character
import com.example.marvel_app.repository.MarvelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MarvelRepository) : ViewModel(){


    private val _character = MutableLiveData<Character>()
    val character : LiveData<Character> = _character

    fun fetchCharacter(){
        viewModelScope.launch {
            val returnedCharacter = repository.fetchCharacter()
            returnedCharacter?.let {
                _character.value
            }
        }
    }
}