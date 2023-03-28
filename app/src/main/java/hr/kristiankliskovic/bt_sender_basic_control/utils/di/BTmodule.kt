package hr.kristiankliskovic.bt_sender_basic_control.utils.di

import hr.kristiankliskovic.bt_sender_basic_control.utils.BluetoothComunication
import org.koin.dsl.module

val btModule = module {
    single {
        BluetoothComunication();
    }
}
