package com.example.githubuser2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.githubuser2.data.local.FavUser
import com.example.githubuser2.data.local.FavUserDao
import com.example.githubuser2.data.local.UserDatabase

class FavoriteViewModel(application: Application): AndroidViewModel(application) {

    private var userDao: FavUserDao?
    private var userDb: UserDatabase?

    init{
        userDb = UserDatabase.getDb(application)
        userDao = userDb?.favUserDao()
    }

    fun getFavUser(): LiveData<List<FavUser>>?{
        return userDao?.getFavUser()
    }

}