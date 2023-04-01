package hr.kristiankliskovic.bt_sender_basic_control.ui.settings.di

import hr.kristiankliskovic.bt_sender_basic_control.ui.settings.SettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val settingsModule = module{
    viewModel {
        SettingsViewModel(
            mainRepository = get(),
        )
    }
}
