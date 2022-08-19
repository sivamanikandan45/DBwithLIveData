package com.example.dbwithlivedata

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListViewModel(application: Application):AndroidViewModel(application) {
   lateinit var allUser:MutableLiveData<List<User>>
   init {
       allUser= MutableLiveData()
   }

    fun getAllUserObservers():MutableLiveData<List<User>>
    {
        return allUser
    }

    fun getAllUsers(){
        val dao=UserDB.getDB(getApplication<Application?>().applicationContext).getDao()
        val list=dao.getDetails()
        allUser.postValue(list)
    }

    fun insertUser(user: User){
        UserDB.getDB(getApplication<Application?>().applicationContext).getDao().addUser(user)
        getAllUsers()
    }
}