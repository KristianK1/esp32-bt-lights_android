package hr.kristiankliskovic.bt_sender_basic_control.ui.home.mapper

import hr.kristiankliskovic.bt_sender_basic_control.model.RGBWState
import hr.kristiankliskovic.bt_sender_basic_control.ui.home.HomeScreenViewState

interface HomeScreenMapper {
    fun toHomeScreenViewState(offButtonState: Boolean, policeButtonState: Boolean, leftRGBWstate: RGBWState, rightRGBWstate: RGBWState): HomeScreenViewState
}
