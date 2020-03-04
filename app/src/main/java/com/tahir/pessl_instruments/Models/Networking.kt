package com.tahir.pessl_instruments.Models

import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2020 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class Networking (

	@SerializedName("type") val type : String,
	@SerializedName("mcc") val mcc : Int,
	@SerializedName("mnc") val mnc : Int,
	@SerializedName("mcc_sim") val mcc_sim : Int,
	@SerializedName("mnc_sim") val mnc_sim : Int,
	@SerializedName("country") val country : String,
	@SerializedName("apn") val apn : String,
	@SerializedName("usernme") val usernme : String,
	@SerializedName("password") val password : String,
//	@SerializedName("simid") val simid : Int,
	@SerializedName("rssi_pct") val rssi_pct : String,
	//@SerializedName("imei") val imei : Int,
	@SerializedName("modem") val modem : Modem,
	@SerializedName("provider") val provider : String,
	@SerializedName("provider_sim") val provider_sim : String
)