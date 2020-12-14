package com.example.dsc.UserData

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(user : UserEntity)

    @Query("SELECT * FROM user")
    fun getAllData() : LiveData<List<UserEntity>>
}