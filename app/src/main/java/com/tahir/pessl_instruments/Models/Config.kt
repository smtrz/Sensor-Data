package com.tahir.pessl_instruments.Models

import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2020 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class Config (

	@SerializedName("timezone_offset") val timezone_offset : Int,
	@SerializedName("dst") val dst : Boolean,
	@SerializedName("precision_reduction") val precision_reduction : Double,
	@SerializedName("scheduler") val scheduler : Int,
	@SerializedName("schedulerOld") val schedulerOld : String,
	@SerializedName("fixed_transfer_interval") val fixed_transfer_interval : Int,
	@SerializedName("rain_monitor") val rain_monitor : Int,
	@SerializedName("water_level_monitor") val water_level_monitor : Int,
	@SerializedName("data_interval") val data_interval : Int,
	@SerializedName("activity_mode") val activity_mode : Int,
	@SerializedName("measuring_interval") val measuring_interval : Int,
	@SerializedName("logging_interval") val logging_interval : Int,
	@SerializedName("x_min_transfer_interval") val x_min_transfer_interval : Boolean
)