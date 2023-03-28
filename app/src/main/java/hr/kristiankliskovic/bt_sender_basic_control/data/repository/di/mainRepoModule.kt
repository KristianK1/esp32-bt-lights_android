package hr.kristiankliskovic.bt_sender_basic_control.data.repository.di

import hr.kristiankliskovic.bt_sender_basic_control.data.repository.MainRepository
import org.koin.dsl.module

val mainRepositoryModule = module{
    single{
        MainRepository(
            bluetoothComunication = get(),
            preferencesManager = get(),
            bluetoothMapper = get(),
        )
    }
}
