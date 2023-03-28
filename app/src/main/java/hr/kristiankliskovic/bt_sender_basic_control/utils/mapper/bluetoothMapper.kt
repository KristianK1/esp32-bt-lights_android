package hr.kristiankliskovic.bt_sender_basic_control.utils.mapper

import hr.kristiankliskovic.bt_sender_basic_control.model.RGBWState

interface bluetoothMapper {
    fun dataToBTpackage(offButton: Boolean, policeButton:Boolean, leftSlider: RGBWState, rightSlider: RGBWState): String
}
