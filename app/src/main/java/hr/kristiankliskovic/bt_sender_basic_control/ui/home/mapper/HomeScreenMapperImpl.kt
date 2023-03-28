package hr.kristiankliskovic.bt_sender_basic_control.ui.home.mapper

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import hr.kristiankliskovic.bt_sender_basic_control.model.RGBWState
import hr.kristiankliskovic.bt_sender_basic_control.ui.components.RGBWSlidersViewState
import hr.kristiankliskovic.bt_sender_basic_control.ui.components.SliderWithTitleViewState
import hr.kristiankliskovic.bt_sender_basic_control.ui.home.HomeScreenViewState

class HomeScreenMapperImpl: HomeScreenMapper {
    override fun toHomeScreenViewState(
        offButtonState: Boolean,
        policeButtonState: Boolean,
        leftRGBWstate: RGBWState,
        rightRGBWstate: RGBWState,
    ): HomeScreenViewState {
        return HomeScreenViewState(
            offButtonState = offButtonState,
            policeButtonState = policeButtonState,
            leftRGBWstate = RGBWSlidersViewState(
                title = "Left side",
                stateR = SliderWithTitleViewState(
                    text = "R",
                    mainColor = Color.Red,
                    currentValue = mutableStateOf(leftRGBWstate.R)
                ),
                stateG = SliderWithTitleViewState(
                    text = "G",
                    mainColor = Color.Green,
                    currentValue = mutableStateOf(leftRGBWstate.G)
                ),
                stateB = SliderWithTitleViewState(
                    text = "B",
                    mainColor = Color.Blue,
                    currentValue = mutableStateOf(leftRGBWstate.B)
                ),
                stateW = SliderWithTitleViewState(
                    text = "W",
                    mainColor = Color.White,
                    currentValue = mutableStateOf(leftRGBWstate.W)
                ),
            ),
            rightRGBWstate = RGBWSlidersViewState(
                title = "Right side",
                stateR = SliderWithTitleViewState(
                    text = "R",
                    mainColor = Color.Red,
                    currentValue = mutableStateOf(rightRGBWstate.R)
                ),
                stateG = SliderWithTitleViewState(
                    text = "G",
                    mainColor = Color.Green,
                    currentValue = mutableStateOf(rightRGBWstate.G)
                ),
                stateB = SliderWithTitleViewState(
                    text = "B",
                    mainColor = Color.Blue,
                    currentValue = mutableStateOf(rightRGBWstate.B)
                ),
                stateW = SliderWithTitleViewState(
                    text = "W",
                    mainColor = Color.White,
                    currentValue = mutableStateOf(rightRGBWstate.W)
                ),
            )
        )
    }
}
