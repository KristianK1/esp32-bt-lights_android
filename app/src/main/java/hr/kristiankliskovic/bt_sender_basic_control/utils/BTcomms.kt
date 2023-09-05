package hr.kristiankliskovic.bt_sender_basic_control.utils

import android.Manifest
import android.bluetooth.*
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import hr.kristiankliskovic.bt_sender_basic_control.basicBTcontrol
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.nio.ByteBuffer
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.util.*
import kotlin.experimental.and
import kotlin.experimental.or

class BluetoothCommunication(
    private val context: Context,
) {
    private var myMac: String? = null
    private var myUUID: UUID? = null
    private var myCarUUID: UUID? = null

    private val connectedInternal: MutableStateFlow<Boolean> = MutableStateFlow(false);
    val connected: StateFlow<Boolean> = connectedInternal.asStateFlow();

    private val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()
    private var bluetoothGatt: BluetoothGatt? = null

    private var dataCharacteristic: BluetoothGattCharacteristic? = null

    fun connectToDevice() {
        val device = bluetoothAdapter?.getRemoteDevice(myMac)
        bluetoothGatt = device?.connectGatt(context, false, gattCallback)
    }


    private val gattCallback = object : BluetoothGattCallback() {
        override fun onConnectionStateChange(gatt: BluetoothGatt, status: Int, newState: Int) {
            super.onConnectionStateChange(gatt, status, newState)

            if (newState == BluetoothProfile.STATE_CONNECTED) {
                connectedInternal.value = true
                gatt.discoverServices()
            } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                connectedInternal.value = false
            }
        }

        override fun onServicesDiscovered(gatt: BluetoothGatt, status: Int) {
            super.onServicesDiscovered(gatt, status)
            if (myUUID != null && myCarUUID != null) {
                if (status == BluetoothGatt.GATT_SUCCESS) {
                    val service = gatt.getService(myUUID)
                    dataCharacteristic = service?.getCharacteristic(myCarUUID)
                }
            }
        }
    }

//    private fun sendData(data: ByteArray) {
//        dataCharacteristic?.let {
//            it.setValue(data)
//            it.writeType =
//                BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT // or WRITE_TYPE_NO_RESPONSE
//            bluetoothGatt?.writeCharacteristic(it)
//        }
//    }
//
//    fun sendData(data: String) {
//        Log.i("sviki_sendData", data)
//        val dataBytes = data.toByteArray(Charsets.UTF_8)
//        sendData(dataBytes)
//    }

    fun close() {
        bluetoothGatt?.close()
    }

    fun setMACAddress(MAC: String) {
        Log.i("sviki_setMAC_BTCOMMS", MAC)
//        myUUID = generateUuidFromMac(MAC)
//        Log.i("sviki_setMAC_BTCOMMS_UUID", "wwww")
//        myCarUUID = generateCharacteristicUuidFromMac(MAC)
//        Log.i("sviki_setMAC_BTCOMMS_CAR_UUID", "wwww")
        myMac = MAC
//        Log.i("sviki_setMAC_BTCOMMS", MAC)
    }

//    private fun generateUuidFromMac(macAddress: String): UUID {
//        Log.i("sviki", "step1")
//        val macBytes = macAddress.replace(":", "").toUpperCase().toByteArray(StandardCharsets.UTF_8)
//        Log.i("sviki", "step2")
//
//        val md = MessageDigest.getInstance("SHA-1")
//        Log.i("sviki", "step3")
//        val namespaceBytes = md.digest(macBytes)
//        Log.i("sviki", "step4")
//
//        val derivedUuidBytes = md.digest(namespaceBytes)
//        Log.i("sviki", "step5")
//        derivedUuidBytes[6] = (derivedUuidBytes[6] and 0x0F.toByte() or 0x50.toByte()) // Set version (5) and variant bits
//        Log.i("sviki", "step6")
//        derivedUuidBytes[8] = (derivedUuidBytes[8] and 0x3F.toByte() or 0x80.toByte()) // Set variant bits
//        Log.i("sviki", "step7")
//
//        val mostSigBits = ByteBuffer.wrap(derivedUuidBytes.copyOfRange(0, 8)).long
//        val leastSigBits = ByteBuffer.wrap(derivedUuidBytes.copyOfRange(8, 16)).long
//        Log.i("sviki", "step8")
//
//        return UUID(mostSigBits, leastSigBits)
//    }
//
//    private fun generateCharacteristicUuidFromMac(macAddress: String): UUID {
//        val namespaceUuid = UUID.fromString("6ba7b810-9dad-11d1-80b4-00c04fd430c8") // UUID for DNS namespace
//        Log.i("sviki", "step1")
//        val macBytes = macAddress.replace(":", "").toByteArray(StandardCharsets.UTF_8)
//
//        Log.i("sviki", "step1")
//        val byteBuffer = ByteBuffer.wrap(ByteArray(16))
//        Log.i("sviki", "step1")
//        byteBuffer.putLong(namespaceUuid.mostSignificantBits)
//        Log.i("sviki", "step1")
//        byteBuffer.putLong(namespaceUuid.leastSignificantBits)
//        Log.i("sviki", "step1")
//        byteBuffer.put(macBytes)
//
//        Log.i("sviki", "step1")
//        val derivedUuidBytes = byteBuffer.array()
//        Log.i("sviki", "step1")
//        derivedUuidBytes[6] = (derivedUuidBytes[6] and 0x0F.toByte() or 0x48.toByte()) // Set version (4) and variant bits
//        Log.i("sviki", "step1")
//        derivedUuidBytes[8] = (derivedUuidBytes[8] and 0x3F.toByte() or 0x80.toByte()) // Set variant bits
//
//        Log.i("sviki", "step1")
//        val mostSigBits = ByteBuffer.wrap(derivedUuidBytes.copyOfRange(0, 8)).long
//        Log.i("sviki", "step1")
//        val leastSigBits = ByteBuffer.wrap(derivedUuidBytes.copyOfRange(8, 16)).long
//
//        Log.i("sviki", "step1")
//        return UUID(mostSigBits, leastSigBits)
//    }


    fun sendData(send: String) {
        try {
            var bt_adresa: String
//        val btManager: BluetoothManager? = getSystemService(BluetoothManager::class.java)
            val bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
            val enableBluetoothIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            Log.i("btFind", "" + myMac);
            val myDevice = bluetoothAdapter.getRemoteDevice(myMac)
            Log.i("btFind", "here4");


            Log.i("btFind", myDevice.name)
            val x = myDevice.createBond()
            Log.i("btFind_bond", "" + x);




            myDevice.uuids.size
            val socket = myDevice.createRfcommSocketToServiceRecord(myDevice.uuids[0].uuid)
            socket.connect()

            val outputStream = socket.outputStream
            val inStream = socket.inputStream
            outputStream.write(send.toByteArray())
            val time1: Long = current_miliseconds()
            var reply = ""
            while (current_miliseconds() - time1 < 3000) {  //PONOC fix this
                while (inStream.available() > 0) reply += inStream.read().toChar()
                if (reply.contains("Da")) break
                if (reply.contains("T=222,")) break
                if (reply.contains("Error")) break
            }
            Log.i("btsend", "done")
            socket.close()
            Log.i("btsend", "done2")
            var print = reply;
            if (0 === print.length) {
                print = "Bluetooth comm failed"
            }
            Log.i("btsend_reply", reply)
            Log.i("btsend_print", print)

//            Toast.makeText(context, print, Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            Log.i("btsend_error", e.message!!)
//            Toast.makeText(
//                context,
//                "Bluetooth comm failed",
//                Toast.LENGTH_LONG
//            ).show()
        }
    }

    private fun current_miliseconds(): Long {
        val cal = Calendar.getInstance()
        return cal.timeInMillis
    }

}
