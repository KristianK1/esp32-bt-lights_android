package hr.kristiankliskovic.bt_sender_basic_control.ui.home

import hr.kristiankliskovic.bt_sender_basic_control.ui.components.RGBWSlidersViewState

data class HomeScreenViewState(
    val offButtonState: Boolean,
    val policeButtonState: Boolean,
    val leftRGBWstate: RGBWSlidersViewState,
    val rightRGBWstate: RGBWSlidersViewState,
)

fun HomeScreen(
    viewModel: HomeScreenViewModel
){
    val viewState:
}
