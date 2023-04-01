package hr.kristiankliskovic.bt_sender_basic_control.ui.home.mapper

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import hr.kristiankliskovic.bt_sender_basic_control.model.RGBWState
import hr.kristiankliskovic.bt_sender_basic_control.model.TotalLightsState
import hr.kristiankliskovic.bt_sender_basic_control.ui.components.RGBWSlidersViewState
import hr.kristiankliskovic.bt_sender_basic_control.ui.components.SliderWithTitleViewState
import hr.kristiankliskovic.bt_sender_basic_control.ui.home.HomeScreenViewState

class HomeScreenMapperImpl: HomeScreenMapper {
    override fun toHomeScreenViewState(
        connectedState: Boolean,
        totalLightsState: TotalLightsState
    ): HomeScreenViewState {
        return HomeScreenViewState(
            connectedState = connectedState,
            lightsState = totalLightsState.lightsState,
            leftRGBWstate = RGBWSlidersViewState(
                title = "Left side",
                stateR = SliderWithTitleViewState(
                    text = "R",
                    mainColor = Color.Red,
                    currentValue = mutableStateOf(totalLightsState.leftRGBWstate.R)
                ),
                stateG = SliderWithTitleViewState(
                    text = "G",
                    mainColor = Color.Green,
                    currentValue = mutableStateOf(totalLightsState.leftRGBWstate.G)
                ),
                stateB = SliderWithTitleViewState(
                    text = "B",
                    mainColor = Color.Blue,
                    currentValue = mutableStateOf(totalLightsState.leftRGBWstate.B)
                ),
                stateW = SliderWithTitleViewState(
                    text = "W",
                    mainColor = Color.White,
                    currentValue = mutableStateOf(totalLightsState.leftRGBWstate.W)
                ),
            ),
            rightRGBWstate = RGBWSlidersViewState(
                title = "Right side",
                stateR = SliderWithTitleViewState(
                    text = "R",
                    mainColor = Color.Red,
                    currentValue = mutableStateOf(totalLightsState.rightRGBWstate.R)
                ),
                stateG = SliderWithTitleViewState(
                    text = "G",
                    mainColor = Color.Green,
                    currentValue = mutableStateOf(totalLightsState.rightRGBWstate.G)
                ),
                stateB = SliderWithTitleViewState(
                    text = "B",
                    mainColor = Color.Blue,
                    currentValue = mutableStateOf(totalLightsState.rightRGBWstate.B)
                ),
                stateW = SliderWithTitleViewState(
                    text = "W",
                    mainColor = Color.White,
                    currentValue = mutableStateOf(totalLightsState.rightRGBWstate.W)
                ),
            )
        )
    }
}
