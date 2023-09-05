package hr.kristiankliskovic.bt_sender_basic_control.data.repository

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
