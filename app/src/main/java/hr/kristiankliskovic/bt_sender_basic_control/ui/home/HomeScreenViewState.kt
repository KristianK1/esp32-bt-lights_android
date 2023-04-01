package hr.kristiankliskovic.bt_sender_basic_control.ui.home

import hr.kristiankliskovic.bt_sender_basic_control.model.LightsStatesEnum
import hr.kristiankliskovic.bt_sender_basic_control.ui.components.RGBWSlidersViewState

data class HomeScreenViewState(
    val connectedState: Boolean,
    val lightsState: LightsStatesEnum,
    val leftRGBWstate: RGBWSlidersViewState,
    val rightRGBWstate: RGBWSlidersViewState,
){
    companion object{
        fun empty(): HomeScreenViewState{
            return HomeScreenViewState(
                connectedState = false,
                lightsState = LightsStatesEnum.OFF,
                leftRGBWstate = RGBWSlidersViewState.empty(),
                rightRGBWstate = RGBWSlidersViewState.empty(),
            )
        }
    }
}
