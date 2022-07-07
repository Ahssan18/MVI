package com.example.mvi_architecture_android_beginners.data.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvi_architecture_android_beginners.data.repository.UserRepository
import com.example.mvi_architecture_android_beginners.ui.MainIntent
import com.example.mvi_architecture_android_beginners.ui.MainState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consume
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import java.lang.Exception

@ExperimentalCoroutinesApi
class UsersModel(val repository: UserRepository):ViewModel() {
    val userIntent = Channel<MainIntent>(Channel.UNLIMITED)
    private val _state = MutableStateFlow<MainState>(MainState.Idle)
    val state:StateFlow<MainState>
    get() {
      return  _state
    }
    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            userIntent.consumeAsFlow().collect {
                when (it) {
                    is MainIntent.FetchUser -> fetchUser()
                }
            }
        }
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            _state.value=MainState.Loading
            _state.value=try {
                MainState.Users(repository.getUser())
            }catch (e:Exception)
            {
                MainState.Error(e.localizedMessage)
            }
        }
    }
}