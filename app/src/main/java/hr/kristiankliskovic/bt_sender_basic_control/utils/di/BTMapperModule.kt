package hr.kristiankliskovic.bt_sender_basic_control.utils.di

import hr.kristiankliskovic.bt_sender_basic_control.utils.mapper.bluetoothMapper
import hr.kristiankliskovic.bt_sender_basic_control.utils.mapper.bluetoothMapperImpl
import org.koin.dsl.module

val BTMapperModule = module{
    single<bluetoothMapper>{
        bluetoothMapperImpl()
    }
}
