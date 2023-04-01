package hr.kristiankliskovic.bt_sender_basic_control.data.repository

import hr.kristiankliskovic.bt_sender_basic_control.data.sharedPrefs.PreferencesManager
import hr.kristiankliskovic.bt_sender_basic_control.model.ColorEnum
import hr.kristiankliskovic.bt_sender_basic_control.model.PositionEnum
import hr.kristiankliskovic.bt_sender_basic_control.model.RGBWState
import hr.kristiankliskovic.bt_sender_basic_control.utils.BluetoothComunication
import hr.kristiankliskovic.bt_sender_basic_control.utils.mapper.bluetoothMapper

//class MainRepository(
//    val bluetoothComunication: BluetoothComunication,
//    val preferencesManager: PreferencesManager,
//    val bluetoothMapper: bluetoothMapper,
//) {
//    var offButtonState: Boolean = false
//    var policeButtonState: Boolean = false
//
//    var leftRGBWstate: RGBWState = RGBWState(0f,0f,0f,0f)
//    var rightRGBWstate: RGBWState = RGBWState(0f,0f,0f,0f)
//
//
//
//    fun changeColorValue(position: PositionEnum, color: ColorEnum, value: Float){
//
//        sendData();
//    }
//
//    fun sendData(){
//        val mac = preferencesManager.getMac();
//        bluetoothComunication.sendData(bluetoothMapper.dataToBTpackage(offButtonState, policeButtonState, leftRGBWstate, rightRGBWstate))
//    }
//
//    fun saveMac(mac: String){
//        preferencesManager.saveMac(mac);
//    }
//}
