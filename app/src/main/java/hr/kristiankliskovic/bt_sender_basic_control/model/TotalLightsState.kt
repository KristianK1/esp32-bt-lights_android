package hr.kristiankliskovic.bt_sender_basic_control.model

data class TotalLightsState(
    var lightsState: LightsStatesEnum,
    var leftRGBWstate: RGBWState,
    var rightRGBWstate: RGBWState,
){
    fun setAllRGBWtoZero(){
        leftRGBWstate.R = 0f;
        leftRGBWstate.G = 0f;
        leftRGBWstate.B = 0f;
        leftRGBWstate.W = 0f;
        rightRGBWstate.R = 0f;
        rightRGBWstate.G = 0f;
        rightRGBWstate.B = 0f;
        rightRGBWstate.W = 0f;
    }

    companion object {
        fun empty(): TotalLightsState {
            return TotalLightsState(
                lightsState = LightsStatesEnum.OFF,
                leftRGBWstate = RGBWState.empty(),
                rightRGBWstate = RGBWState.empty(),
            )
        }
    }
}
