package com.example.githubuser2

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel (private val pref: SettingPreferences): ViewModel() {
    val listUser = MutableLiveData<ArrayList<User>>()

    fun setSearchUser(query: String){
        ApiConfig.apiInstance
            .getSearchUser(query)
            .enqueue(object : Callback<ListUsersResponse>{
                override fun onResponse(
                    call: Call<ListUsersResponse>,
                    response: Response<ListUsersResponse>
                ) {
                    if(response.isSuccessful){
                        listUser.postValue(response.body()?.items)
                    }
                }
                override fun onFailure(call: Call<ListUsersResponse>, t: Throwable){
                    t.message?.let { Log.d("Failure", it) }
                }
            })
    }

    fun getSearchUsers(): LiveData<ArrayList<User>>{
        return listUser
    }

    fun getThemeSettings(): LiveData<Boolean> {
        return pref.getThemeSetting().asLiveData()
    }

    fun saveThemeSetting(isDarkModeActive: Boolean) {
        viewModelScope.launch {
            pref.saveThemeSetting(isDarkModeActive)
        }
    }

}