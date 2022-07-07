package com.example.mvi_architecture_android_beginners.ui

import com.example.mvi_architecture_android_beginners.data.model.User

sealed class MainState {
    object Idle : MainState()
    object Loading : MainState()
    data class Users(val user: List<User>) : MainState()
    data class Error(val error: String?) : MainState()
}