package com.example.dbwithlivedata

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [User::class], version = 1)
abstract class UserDB :RoomDatabase(){
    abstract fun getDao():UserDao
    companion object{
        @Volatile
        private var instance:UserDB?=null

        fun getDB(context: Context?):UserDB{
            val temp= instance
            if(temp != null){
                //dbInstance=Room.databaseBuilder(context, UserDB::class.java, "database-name").build()
                return temp
            }
            synchronized(this){
                val newInstance= Room.databaseBuilder(context!!, UserDB::class.java, "user.db").build()
                instance=newInstance
                return newInstance
            }
            //return dbInstance
        }

    }
}