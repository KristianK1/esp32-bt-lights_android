package hr.kristiankliskovic.bt_sender_basic_control

import android.app.Activity
import android.app.Application
import android.util.Log
import hr.kristiankliskovic.bt_sender_basic_control.data.repository.di.mainRepositoryModule
import hr.kristiankliskovic.bt_sender_basic_control.data.sharedPrefs.di.prefsModule
import hr.kristiankliskovic.bt_sender_basic_control.ui.home.homeModule
import hr.kristiankliskovic.bt_sender_basic_control.ui.settings.di.settingsModule
import hr.kristiankliskovic.bt_sender_basic_control.utils.di.BTMapperModule
import hr.kristiankliskovic.bt_sender_basic_control.utils.di.btModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class basicBTcontrol: Application() {

    override fun onCreate() {
        super.onCreate()
        application = this
        Log.i("koin", "KOIN STARTED")
        startKoin {
            androidContext(this@basicBTcontrol)
            modules(
                btModule,
                prefsModule,
                mainRepositoryModule,
                homeModule,
                settingsModule,
                BTMapperModule,
            )
        }
    }

    companion object{
        lateinit var application: Application
    }


}
