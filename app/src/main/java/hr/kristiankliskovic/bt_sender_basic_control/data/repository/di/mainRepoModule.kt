package hr.kristiankliskovic.bt_sender_basic_control.data.repository.di

import hr.kristiankliskovic.bt_sender_basic_control.data.repository.Repository
import hr.kristiankliskovic.bt_sender_basic_control.data.repository.RepositoryImpl
import org.koin.dsl.module

val mainRepositoryModule = module{
    single<Repository>{
        RepositoryImpl(
            bluetoothComunication = get(),
            preferencesManager = get(),
            bluetoothMapper = get(),
        )
    }
}
