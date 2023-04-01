package hr.kristiankliskovic.bt_sender_basic_control.utils.mapper

import hr.kristiankliskovic.bt_sender_basic_control.model.TotalLightsState

class bluetoothMapperImpl: bluetoothMapper {
    override fun dataToBTpackage(data: TotalLightsState): String{
        return "THIS NEEDS DATA PROTOCOL" //TODO implement this
    }
}
