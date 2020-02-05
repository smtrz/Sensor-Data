package com.tahir.pessl_instruments.Modules


import android.content.Context
import com.tahir.pessl_instruments.Repository.DbRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DbRepoModule {


    @Provides
    @Singleton
    fun getRepository(c: Context): DbRepository {

        return DbRepository(c)

    }


}