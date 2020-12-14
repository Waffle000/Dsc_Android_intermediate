package com.example.dsc.UserData

import androidx.lifecycle.LiveData

class AppRepository(private val userDao : UserDao) {

    suspend fun insertData(user: UserEntity){
        userDao.insertData(user)
    }

    val getData: LiveData<List<UserEntity>> = userDao.getAllData()
}