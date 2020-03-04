package com.tahir.pessl_instruments.Components


import com.tahir.pessl_instruments.Adapters.StationAdapter
import com.tahir.pessl_instruments.Helpers.DateHelper
import com.tahir.pessl_instruments.Modules.ContextModule
import com.tahir.pessl_instruments.Modules.DateModule
import com.tahir.pessl_instruments.Modules.DbRepoModule
import com.tahir.pessl_instruments.Repository.DbRepository
import com.tahir.pessl_instruments.ViewModels.TrendingActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ContextModule::class, DateModule::class, DbRepoModule::class])
@Singleton
interface AppLevelComponent {

    fun inject(ma: TrendingActivityViewModel)
    fun inject(dr: DbRepository)
    fun inject(dr: DateHelper)
    fun inject(dr: StationAdapter)
}
