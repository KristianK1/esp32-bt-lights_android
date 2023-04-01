package hr.kristiankliskovic.bt_sender_basic_control.ui.home.mapper

import hr.kristiankliskovic.bt_sender_basic_control.model.RGBWState
import hr.kristiankliskovic.bt_sender_basic_control.model.TotalLightsState
import hr.kristiankliskovic.bt_sender_basic_control.ui.home.HomeScreenViewState

interface HomeScreenMapper {
    fun toHomeScreenViewState(
        connectedState: Boolean,
        totalLightsState: TotalLightsState
    ): HomeScreenViewState
}
