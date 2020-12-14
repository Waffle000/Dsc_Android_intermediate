package com.example.dsc.UserData

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name: String,
    val address: String,
    val age: String
)