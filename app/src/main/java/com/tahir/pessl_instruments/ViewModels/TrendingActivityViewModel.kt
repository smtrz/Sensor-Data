package com.tahir.pessl_instruments.ViewModels

/*import com.tahir.pessl_instruments.Database.DbRepository
import com.tahir.pessl_instruments.Models.BaseTrending*/
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.tahir.pessl_instruments.Configurations.App
import com.tahir.pessl_instruments.Models.DeviceInfo
import com.tahir.pessl_instruments.Repository.DbRepository
import javax.inject.Inject

class TrendingActivityViewModel(application: Application) : AndroidViewModel(application) {

    // injecting repository
    @Inject
    lateinit var dbrepo: DbRepository


    init {


        App.app.appLevelComponent.inject(this)
    }
/*
    fun ifDataIsloading(): MutableLiveData<Boolean> {
        return dbrepo!!.ifDataIsloading()

    }*/
    // just refresh the data based on the result.

    fun callNewsAPI(): MutableLiveData<List<DeviceInfo>> {
     return   dbrepo!!.getallArticles()

    }

}


