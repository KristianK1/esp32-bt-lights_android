package hr.kristiankliskovic.bt_sender_basic_control.utils.mapper

import com.google.gson.Gson
import hr.kristiankliskovic.bt_sender_basic_control.model.TotalLightsState
import kotlin.math.roundToInt

data class BTJSON(
    val lightsState: Int,
    val left: BTColors,
    val right: BTColors,
)

data class BTColors(
    val R: Int,
    val G: Int,
    val B: Int,
    val W: Int,
)

class bluetoothMapperImpl : bluetoothMapper {
    override fun dataToBTpackage(data: TotalLightsState): String {
        val mappedData = BTJSON(
            lightsState = data.lightsState.ordinal,
            left = BTColors(
                R = data.leftRGBWstate.R.roundToInt(),
                G = data.leftRGBWstate.G.roundToInt(),
                B = data.leftRGBWstate.B.roundToInt(),
                W = data.leftRGBWstate.W.roundToInt(),
            ),
            right = BTColors(
                R = data.rightRGBWstate.R.roundToInt(),
                G = data.rightRGBWstate.G.roundToInt(),
                B = data.rightRGBWstate.B.roundToInt(),
                W = data.rightRGBWstate.W.roundToInt(),
            ),
        )

        return Gson().toJson(mappedData) //TODO implement this
    }
}
