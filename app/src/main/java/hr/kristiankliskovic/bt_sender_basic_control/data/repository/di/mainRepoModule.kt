package hr.kristiankliskovic.bt_sender_basic_control.data.repository.di

import hr.kristiankliskovic.bt_sender_basic_control.data.repository.Repository
import hr.kristiankliskovic.bt_sender_basic_control.data.repository.RepositoryImpl
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val mainRepositoryModule = module{
    single<Repository>{
        RepositoryImpl(
            bluetoothCommunication = get(),
            preferencesManager = get(),
            bluetoothMapper = get(),
            bgDispatcher = Dispatchers.IO,
        )
    }
}
