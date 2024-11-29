package com.example.afterfp


import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.afterfp.userStorage.domain.model.Users

class ViewModelForDetails: ViewModel() {
    private val _users = mutableStateListOf<Users>()
    val users: List<Users> = _users
    init{
        _users.add(Users("Aftab","Fazal","+923370380008"))
    }
    fun addUser(user: Users) {
        _users.add(user)
    }
    fun removeUser(user: Users) {
        _users.remove(user)
    }
    fun getUser(index: Int): Users {
        return _users[index]
    }


}