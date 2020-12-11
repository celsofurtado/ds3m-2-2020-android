package com.example.instagames_ds3m.constants

import android.content.Context
import com.example.instagames_ds3m.model.User

class SharedPreferencesProfile {

    companion object {
        fun getUser(context: Context) : User {
            val userProfile = context.getSharedPreferences("instaGamesProfile", Context.MODE_PRIVATE)
            val user = User()
            user.id = userProfile.getLong("userId", 0L)
            user.name = userProfile.getString("userName", "").toString()
            user.email = userProfile.getString("userEmail", "").toString()
            user.token = userProfile.getString("token", "").toString()
            return user
        }
    }

}