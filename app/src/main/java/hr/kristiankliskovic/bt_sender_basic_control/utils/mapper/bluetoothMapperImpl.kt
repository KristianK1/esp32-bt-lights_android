package hr.kristiankliskovic.bt_sender_basic_control.utils.mapper

import hr.kristiankliskovic.bt_sender_basic_control.model.RGBWState

class bluetoothMapperImpl: bluetoothMapper {
    override fun dataToBTpackage(
        offButton: Boolean,
        policeButton: Boolean,
        leftSlider: RGBWState,
        rightSlider: RGBWState,
    ): String{
    return "THIS NEEDS DATA PROTOCOL";
    }
}
