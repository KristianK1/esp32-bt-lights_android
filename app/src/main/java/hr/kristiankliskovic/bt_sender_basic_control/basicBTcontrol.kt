package hr.kristiankliskovic.bt_sender_basic_control

import android.app.Application
import hr.kristiankliskovic.bt_sender_basic_control.data.repository.di.mainRepositoryModule
import hr.kristiankliskovic.bt_sender_basic_control.data.sharedPrefs.di.prefsModule
import hr.kristiankliskovic.bt_sender_basic_control.utils.di.btModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class basicBTcontrol: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@basicBTcontrol)
            modules(
                btModule,
                prefsModule,
                mainRepositoryModule,

            )
        }
    }
}
