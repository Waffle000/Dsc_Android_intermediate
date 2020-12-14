package com.example.dsc.UserData

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val repository : AppRepository
    val getData: LiveData<List<UserEntity>>

    init {
        val userDao = UserDataBase.getDatabase(application).userDao()
        repository = AppRepository(userDao)
        getData = repository.getData
    }

    fun insertData(user : UserEntity) {
        viewModelScope.launch {
            repository.insertData(user)
        }
    }
}