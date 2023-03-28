package hr.kristiankliskovic.bt_sender_basic_control.data.sharedPrefs.di

import hr.kristiankliskovic.bt_sender_basic_control.data.sharedPrefs.PreferencesManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val prefsModule = module{
    single {
        PreferencesManager(
            context = androidContext()
        )
    }
}
