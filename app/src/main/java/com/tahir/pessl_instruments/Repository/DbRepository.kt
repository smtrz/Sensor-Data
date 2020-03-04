package com.tahir.pessl_instruments.Repository


import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tahir.pessl_instruments.Configurations.App
import com.tahir.pessl_instruments.Helpers.DateHelper
import com.tahir.pessl_instruments.Models.DeviceInfo
import java.io.IOException
import java.nio.charset.Charset
import java.util.*
import javax.inject.Inject

class DbRepository {
    // lateinit var trendingDao: TrendingRepoDao
    /*  @Inject
      lateinit var retrofit: Retrofit*/
    internal var deviceInfoLivedata = MutableLiveData<List<DeviceInfo>>()

    @Inject
    lateinit var c: Context
    /*  @Inject
      lateinit var db: AppDB*/
    @Inject
    lateinit var now: Date
    @Inject
    lateinit var dh: DateHelper

    internal constructor() {
        // empty constructor

    }

    constructor(application: Context) {
        App.app.appLevelComponent.inject(this@DbRepository)

    }


    fun getallArticles(): MutableLiveData<List<DeviceInfo>> {
        getData()
        return deviceInfoLivedata

    }


    // network call to get all the news
    fun getData() {

        val data: String? = getAssetJsonData(c);
        val gson: Gson = Gson()
        val arrayTutorialType = object : TypeToken<List<DeviceInfo>>() {}.type
        val device_info_list: List<DeviceInfo> = gson.fromJson(data, arrayTutorialType)
        //  deviceInfoLivedata.postValue(device_info_list)
        deviceInfoLivedata.value = device_info_list

/*
        dataLoading.value = true
        //  pd.show();
        val endpoints = retrofit!!.create(EndpointsInterface::class.java)
        endpoints.getNewsList("", "daily").enqueue(object : Callback<List<BaseTrending>> {
            override fun onResponse(
                call: Call<List<BaseTrending>>,
                response: Response<List<BaseTrending>>
            ) {
                dataLoading.value = false

                if (response.isSuccessful) {
                    //purging items
                    deleteAllitems()
                    // storing the date
                    Sp_Get_Store_Data.storeStringData(now.toString(), "data-time", c)



                    insertItems(response.body())
                } else {
                }
            }

            override fun onFailure(call: Call<List<BaseTrending>>, t: Throwable) {
                dataLoading.value = false

            }
        })*/
    }


    fun shouldFetchData() {
        //   var fetchdate = Sp_Get_Store_Data.getStringData(c, "data-time");
        // if (fetchdate != null) {


        // val diff: Long = dh.calculateDateDifference(fetchdate)


        // if (diff > 2) {
        getData();

        //   }

        //} else {

        //  Sp_Get_Store_Data.storeStringData(now.toString(), "data-time", c)
        //getData();
        //}

    }

    fun getAssetJsonData(context: Context): String? {
        var json: String? = null
        json = try {
            val inp = context.assets.open("stations.json")
            val size = inp.available()
            val buffer = ByteArray(size)
            inp.read(buffer)
            inp.close()
            val charset: Charset = Charsets.UTF_8
            String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        //    Log.e("data", json)
        return json
    }


}
