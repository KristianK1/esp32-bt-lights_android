package hr.kristiankliskovic.bt_sender_basic_control.data.repository

import android.util.Log
import hr.kristiankliskovic.bt_sender_basic_control.data.sharedPrefs.PreferencesManager
import hr.kristiankliskovic.bt_sender_basic_control.model.ColorEnum
import hr.kristiankliskovic.bt_sender_basic_control.model.LightsStatesEnum
import hr.kristiankliskovic.bt_sender_basic_control.model.PositionEnum
import hr.kristiankliskovic.bt_sender_basic_control.model.TotalLightsState
import hr.kristiankliskovic.bt_sender_basic_control.utils.BluetoothCommunication
import hr.kristiankliskovic.bt_sender_basic_control.utils.mapper.bluetoothMapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class RepositoryImpl(
    private val bluetoothCommunication: BluetoothCommunication,
    private val preferencesManager: PreferencesManager,
    private val bluetoothMapper: bluetoothMapper,
    private val bgDispatcher: CoroutineDispatcher,
) : Repository {

    private val lightsStateInternal: MutableStateFlow<TotalLightsState> =
        MutableStateFlow(TotalLightsState.empty())
    override val lightsState: StateFlow<TotalLightsState> = lightsStateInternal.asStateFlow()
    override val connectedState: StateFlow<Boolean> = bluetoothCommunication.connected

    init{
        val mac = preferencesManager.getMac()
        if(mac.isNotEmpty()){
            bluetoothCommunication.setMACAddress(mac)
        }
    }

    override suspend fun changeColorValue(position: PositionEnum, color: ColorEnum, value: Float) {
        Log.i("sviki", "changeColor ${position.name} ${color.name} $value");
        val oldState = lightsStateInternal.value
        val newState = oldState.copy(
            lightsState = oldState.lightsState,
            leftRGBWstate = oldState.leftRGBWstate.copy(
                R = oldState.leftRGBWstate.R,
                G = oldState.leftRGBWstate.G,
                B = oldState.leftRGBWstate.B,
                W = oldState.leftRGBWstate.W,
            ),
            rightRGBWstate = oldState.rightRGBWstate.copy(
                R = oldState.rightRGBWstate.R,
                G = oldState.rightRGBWstate.G,
                B = oldState.rightRGBWstate.B,
                W = oldState.rightRGBWstate.W,
            ),
        )
        if (value > 0) {
            newState.lightsState = LightsStatesEnum.COLORS_INGAGED
        }
        when (position) {
            PositionEnum.LEFT -> {
                when (color) {
                    ColorEnum.RED -> {
                        newState.leftRGBWstate.R = value
                        if (value > 0) {
                            newState.leftRGBWstate.W = 0f
                        }
                    }
                    ColorEnum.GREEN -> {
                        newState.leftRGBWstate.G = value
                        if (value > 0) {
                            newState.leftRGBWstate.W = 0f
                        }
                    }
                    ColorEnum.BLUE -> {
                        newState.leftRGBWstate.B = value
                        if (value > 0) {
                            newState.leftRGBWstate.W = 0f
                        }
                    }
                    ColorEnum.WHITE -> {
                        if (newState.leftRGBWstate.W == 0f && value > 0f) {
                            newState.leftRGBWstate.R = 0f
                            newState.leftRGBWstate.G = 0f
                            newState.leftRGBWstate.B = 0f
                        }
                        newState.leftRGBWstate.W = value
                    }
                }
            }
            PositionEnum.RIGHT -> {
                when (color) {
                    ColorEnum.RED -> {
                        newState.rightRGBWstate.R = value
                        if (value > 0) {
                            newState.rightRGBWstate.W = 0f
                        }
                    }
                    ColorEnum.GREEN -> {
                        newState.rightRGBWstate.G = value
                        if (value > 0) {
                            newState.rightRGBWstate.W = 0f
                        }
                    }
                    ColorEnum.BLUE -> {
                        newState.rightRGBWstate.B = value
                        if (value > 0) {
                            newState.rightRGBWstate.W = 0f
                        }
                    }
                    ColorEnum.WHITE -> {
                        if (newState.rightRGBWstate.W == 0f && value > 0f) {
                            newState.rightRGBWstate.R = 0f
                            newState.rightRGBWstate.G = 0f
                            newState.rightRGBWstate.B = 0f
                        }
                        newState.rightRGBWstate.W = value
                    }
                }
            }
        }
        lightsStateInternal.value = newState
        CoroutineScope(bgDispatcher).launch{
            sendData()
        }
    }

    override fun changeState(state: LightsStatesEnum) {
        val newValue = lightsStateInternal.value.copy(lightsState = state)
        if (state != LightsStatesEnum.COLORS_INGAGED) {
            newValue.setAllRGBWtoZero()
        }
        lightsStateInternal.value = newValue
        CoroutineScope(bgDispatcher).launch{
            sendData()
        }
    }

    override fun saveMac(mac: String) {
        preferencesManager.saveMac(mac)
        bluetoothCommunication.setMACAddress(mac)
    }

    override fun getMac(): String = preferencesManager.getMac()

    override suspend fun sendData() {
        bluetoothCommunication.sendData(bluetoothMapper.dataToBTpackage(lightsStateInternal.value))
    }

    override fun connect(){
        bluetoothCommunication.connectToDevice()
    }

    override fun disconnect(){
        bluetoothCommunication.close()
    }
}
