package hr.kristiankliskovic.bt_sender_basic_control.utils.mapper

import hr.kristiankliskovic.bt_sender_basic_control.model.TotalLightsState

interface bluetoothMapper {
    fun dataToBTpackage(data: TotalLightsState): String
}
