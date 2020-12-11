package com.example.instagames_ds3m.model

data class User(
    var id: Long = 0L,
    var name: String = "",
    var email: String = "",
    var localization: String = "",
    var password: String = "",
    var token: String = "",
    var urlUserImage: String = ""
) {

    override fun toString(): String {
        return "User(id=$id, name='$name', email='$email', localization='$localization', password='$password', token='$token', urlUserImage='$urlUserImage')"
    }
}