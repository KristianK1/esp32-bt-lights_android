package hr.kristiankliskovic.bt_sender_basic_control.ui.settings

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hr.kristiankliskovic.bt_sender_basic_control.ui.components.OutlineTextWrapper

@Composable
fun SettingsRoute(
    viewModel: SettingsViewModel,
    navigateBack: () -> Unit,
){
    SettingsScreen(
        startMac = viewModel.getMac(),
        saveMac = {
          viewModel.saveMac(it)
        },
        navigateBack = navigateBack
    )
}

@Composable
fun SettingsScreen(
    startMac: String,
    saveMac: (String) -> Unit,
    navigateBack: () -> Unit,
){
    Log.i("sviki", "startMac $startMac")
    var value by remember {
        mutableStateOf(startMac)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Spacer(
            modifier = Modifier.height(100.dp)
        )

        Text(
            text = "Settings",
            fontSize = 60.sp,
        )

        Spacer(
            modifier = Modifier.height(50.dp)
        )

        OutlineTextWrapper(
            initValue = startMac,
            label = "MAC address of device",
            placeholder = "XX:XX:XX:XX:XX:XX",
            onChange = {
                value = it
            }
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = "Save",
            fontSize = 30.sp,
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .background(Color.Red)
                .clickable {
                    saveMac(value)
                    navigateBack()
                }
                .padding(10.dp)
        )
    }
}

