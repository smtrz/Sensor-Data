package com.tahir.pessl_instruments.Modules

import com.tahir.pessl_instruments.Helpers.DateHelper
import dagger.Module
import dagger.Provides
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Named
import javax.inject.Singleton

@Module
class DateModule {

    @Provides
    @Singleton
    fun getDate(): Date {

        return Date()
    }

    @Provides
    @Singleton
    @Named("device_time")

    fun getDateFormat(): SimpleDateFormat {

        // return SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy")
        return SimpleDateFormat("yyyy-MM-DD HH:mm:ss")

    }

    @Provides
    @Singleton
    @Named("current_time")

    fun getDateFormat_for_current_time(): SimpleDateFormat {

        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)
        // return SimpleDateFormat("yyyy-MM-DD HH:mm:ss")

    }

    @Provides
    @Singleton
    fun getDateHelper(): DateHelper {

        return DateHelper()
    }


}

