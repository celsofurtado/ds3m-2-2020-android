package com.example.instagames_ds3m.model

data class GamePost(
    val id: Long,
    val userPostName: String,
    val consoleName: String,
    val consoleMaker: String,
    val postTitle: String,
    val postText: String,
    val totalLikes: Int,
    val totalComments: Int,
    val postTime: String,
    val statusGame: String
) {
    override fun toString(): String {
        return "GamePost(id=$id, userPostName='$userPostName', totalLikes=$totalLikes, totalComments=$totalComments)"
    }
}