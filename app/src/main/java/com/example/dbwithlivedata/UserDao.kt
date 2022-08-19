package com.example.dbwithlivedata

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM User")
    fun getDetails():List<User>

    @Insert
    fun addUser(user:User)

}