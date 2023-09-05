package hr.kristiankliskovic.bt_sender_basic_control.utils.di

import hr.kristiankliskovic.bt_sender_basic_control.basicBTcontrol
import hr.kristiankliskovic.bt_sender_basic_control.utils.BluetoothCommunication
import org.koin.dsl.module

val btModule = module {
    single {
        BluetoothCommunication(
            basicBTcontrol.application.applicationContext
        )
    }
}
