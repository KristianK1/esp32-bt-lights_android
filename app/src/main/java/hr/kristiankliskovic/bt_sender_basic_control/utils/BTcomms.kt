package hr.kristiankliskovic.bt_sender_basic_control.utils

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class BluetoothComunication{

    private val connectedInternal: MutableStateFlow<Boolean> = MutableStateFlow(false);
    val connected: StateFlow<Boolean> = connectedInternal.asStateFlow();

    fun connect(){

    }

    fun disconnect(){

    }

    fun sendData(data: String){

    }

}
