package hr.kristiankliskovic.bt_sender_basic_control.ui.settings

import androidx.lifecycle.ViewModel
import hr.kristiankliskovic.bt_sender_basic_control.data.repository.Repository

class SettingsViewModel(
    val mainRepository: Repository
): ViewModel() {

    fun getMac(): String{
        return mainRepository.getMac()
    }

    fun saveMac(mac: String){
        mainRepository.saveMac(mac)
    }
}
