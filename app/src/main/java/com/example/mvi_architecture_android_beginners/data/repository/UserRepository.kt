package com.example.mvi_architecture_android_beginners.data.repository

import com.example.mvi_architecture_android_beginners.data.api.ApiHelper

class UserRepository(val apiHelper: ApiHelper) {
    suspend fun getUser()=apiHelper.getUsers()
}