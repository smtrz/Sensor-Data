package com.tahir.pessl_instruments.Configurations

import android.app.Application
import com.tahir.pessl_instruments.Components.AppLevelComponent
import com.tahir.pessl_instruments.Components.DaggerAppLevelComponent
import com.tahir.pessl_instruments.Modules.ContextModule
import com.tahir.pessl_instruments.Modules.DateModule


class App : Application() {
    lateinit var appLevelComponent: AppLevelComponent


    override fun onCreate() {
        super.onCreate()
        app = this
        // we only have to set constructor modules or context modules.
        appLevelComponent = DaggerAppLevelComponent.builder()
            .contextModule(ContextModule(this))
            //.dbRepoModule(DbRepoModule())
           // .netModule(NetModule("https://github-trending-api.now.sh/"))
            .dateModule(DateModule())
            .build()


    }

    companion object {
        lateinit var app: App
    }


}
