package hr.kristiankliskovic.bt_sender_basic_control.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import hr.kristiankliskovic.bt_sender_basic_control.R

enum class ConnectedStates {
    DISCONNECTED,
    CONNECTED,
    CONNECTING,
}

@Composable
fun ConnectedStateButton(
    state: ConnectedStates,
    onClick: () -> Unit
){
    Text(
        text = stringResource(
            id = if(state == ConnectedStates.CONNECTED) R.string.connectedButton_CONNECTED else if (state == ConnectedStates.DISCONNECTED) R.string.connectedButton_DISCONNECTED else R.string.connectedButton_CONNECTING),
        modifier = Modifier
//            .padding(20.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(
                color = if(state == ConnectedStates.CONNECTED) Color.Green.copy(alpha = 0.3f) else if (state == ConnectedStates.DISCONNECTED) Color.Red.copy(alpha = 0.3f) else Color.Yellow.copy(alpha = 0.3f)
            )
            .padding(20.dp)
            .clickable {
                onClick()
            }
    )
}
