package com.tahir.pessl_instruments.Models

data class Info(
    val device_id: Int,
    val device_name: String,
    val firmware: String,
    val hardware: String,
    val uid: String
)