package com.tahir.pessl_instruments.Models

data class DeviceInfo(
    val config: Config,
    val dates: Dates,
    val flags: Flags,
    val info: Info,
   // val licenses: Boolean,
    //val meta: Meta,
    val metaUnits: String,
    val metadata: Metadata,
    val name: Name,
    val networking: Networking,
    val note: String,
    val position: Position,
    val rights: String,
    val warnings: Warnings
)