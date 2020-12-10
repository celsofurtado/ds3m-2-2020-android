package com.example.instagames_ds3m.model

data class Console (
    val id: Long,
    val consoleName: String = "",
    val consoleMaker: String = "",
    val releaseDate: String = "",
    val urlConsoleImage: String = "",
    val price: Double = 0.0
) {

    override fun toString(): String {
        return consoleName
    }

}
