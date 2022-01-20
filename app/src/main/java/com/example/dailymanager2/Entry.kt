package com.example.dailymanager2

import java.io.Serializable

data class Entry(
    val date: String,
    val time: String,
    val name: String,
    val location: String,
    val note: String
): Serializable
