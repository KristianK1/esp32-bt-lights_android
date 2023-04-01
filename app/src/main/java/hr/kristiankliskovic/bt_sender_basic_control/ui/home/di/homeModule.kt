package hr.kristiankliskovic.bt_sender_basic_control.ui.home

import hr.kristiankliskovic.bt_sender_basic_control.ui.home.mapper.HomeScreenMapper
import hr.kristiankliskovic.bt_sender_basic_control.ui.home.mapper.HomeScreenMapperImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module{
    viewModel {
        HomeScreenViewModel(
            mainRepository = get(),
            homeScreenMapper = get()
        )
    }
    single<HomeScreenMapper>{
        HomeScreenMapperImpl()
    }
}
