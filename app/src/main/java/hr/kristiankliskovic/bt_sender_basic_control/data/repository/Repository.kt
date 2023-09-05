package hr.kristiankliskovic.bt_sender_basic_control.data.repository

import hr.kristiankliskovic.bt_sender_basic_control.model.ColorEnum
import hr.kristiankliskovic.bt_sender_basic_control.model.LightsStatesEnum
import hr.kristiankliskovic.bt_sender_basic_control.model.PositionEnum
import hr.kristiankliskovic.bt_sender_basic_control.model.TotalLightsState
import kotlinx.coroutines.flow.StateFlow

interface Repository {
    val lightsState: StateFlow<TotalLightsState>
    val connectedState: StateFlow<Boolean>
    suspend fun changeColorValue(position: PositionEnum, color: ColorEnum, value: Float)
    fun changeState(state: LightsStatesEnum)
    fun saveMac(mac: String)
    fun getMac(): String

    fun connect()
    fun disconnect()
    suspend fun sendData()
}
