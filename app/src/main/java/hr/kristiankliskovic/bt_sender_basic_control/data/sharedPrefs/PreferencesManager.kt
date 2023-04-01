package hr.kristiankliskovic.bt_sender_basic_control.data.sharedPrefs

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey


const val PREFS_FILE = "MyPreferences"
const val macAddressKey = "MAC_ADDRESS"

class PreferencesManager(
    context: Context,
) {
    private val sharedPreferences: SharedPreferences

    init {
        val masterKey: MasterKey = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        sharedPreferences = EncryptedSharedPreferences.create(
            context,
            PREFS_FILE,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    fun getMac(): String {
        return getString(macAddressKey)?:""
    }

    fun saveMac(mac: String){
        saveString(macAddressKey, mac)
    }

    private fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    private fun saveString(key: String, token: String) {
        sharedPreferences.edit().putString(key, token).apply()
    }

    private fun deleteString(key: String) {
        sharedPreferences.edit().putString(key, null).apply()
    }
}
