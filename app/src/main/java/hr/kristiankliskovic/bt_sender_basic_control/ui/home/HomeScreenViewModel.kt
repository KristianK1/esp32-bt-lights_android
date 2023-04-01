package hr.kristiankliskovic.bt_sender_basic_control.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hr.kristiankliskovic.bt_sender_basic_control.data.repository.Repository
import hr.kristiankliskovic.bt_sender_basic_control.model.ColorEnum
import hr.kristiankliskovic.bt_sender_basic_control.model.LightsStatesEnum
import hr.kristiankliskovic.bt_sender_basic_control.model.PositionEnum
import hr.kristiankliskovic.bt_sender_basic_control.model.TotalLightsState
import hr.kristiankliskovic.bt_sender_basic_control.ui.home.mapper.HomeScreenMapper
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    val mainRepository: Repository,
    val homeScreenMapper: HomeScreenMapper,
): ViewModel()
{
    val state: StateFlow<HomeScreenViewState> = combine(
        mainRepository.connectedState,
        mainRepository.lightsState
    ) { connectedState: Boolean, lightsState: TotalLightsState ->
        Log.i("sviki", "new home screen view state ${lightsState.leftRGBWstate.R}")

        homeScreenMapper.toHomeScreenViewState(
            connectedState = connectedState,
            totalLightsState = lightsState
        )
    }.stateIn(viewModelScope, SharingStarted.Lazily, HomeScreenViewState.empty())

    fun changedState(lightsState: LightsStatesEnum){
        viewModelScope.launch {
            mainRepository.changeState(lightsState)
        }
    }

    fun changeColorValue(position: PositionEnum, color: ColorEnum, value: Float){
        viewModelScope.launch {
            mainRepository.changeColorValue(position,color,value)
        }
    }

    fun changeConnect() {
        if(mainRepository.connectedState.value){
            connect()
        }
        else{
            disconnect()
        }
    }

    private fun connect(){
        viewModelScope.launch {

        }
    }

    private fun disconnect(){
        viewModelScope.launch {

        }
    }
}
