package hr.kristiankliskovic.bt_sender_basic_control.ui.home

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hr.kristiankliskovic.bt_sender_basic_control.model.ColorEnum
import hr.kristiankliskovic.bt_sender_basic_control.model.LightsStatesEnum
import hr.kristiankliskovic.bt_sender_basic_control.model.PositionEnum
import hr.kristiankliskovic.bt_sender_basic_control.ui.components.ConnectedStateButton
import hr.kristiankliskovic.bt_sender_basic_control.ui.components.ConnectedStates
import hr.kristiankliskovic.bt_sender_basic_control.ui.components.RGBWSliders
import hr.kristiankliskovic.bt_sender_basic_control.ui.components.StateButton

@Composable
fun HomeRoute(
    viewModel: HomeScreenViewModel,
    navigateToSettings: () -> Unit,
){
    val homeScreenViewstate by viewModel.state.collectAsState();
    HomeScreen(
        state = homeScreenViewstate,
        connectButtonClick = {
            viewModel.changeConnect()
        },
        changeState = {
          viewModel.changedState(it)
        },
        changeRGBWstate = { it1, it2, it3 ->
            viewModel.changeColorValue(it1, it2, it3)
        },
        navigateToSettings = navigateToSettings,
    )
}

@Composable
fun HomeScreen(
    state: HomeScreenViewState,
    connectButtonClick: () -> Unit,
    changeState: (LightsStatesEnum) -> Unit,
    changeRGBWstate:(PositionEnum, ColorEnum, Float) -> Unit,
    navigateToSettings: () -> Unit,
) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            Row() {
                StateButton(
                    state = state.lightsState == LightsStatesEnum.OFF,
                    text = "Off",
                    onClick = {
                        changeState(LightsStatesEnum.OFF)
                    },
                    modifier = Modifier
                        .weight(1f)
                )
                StateButton(
                    state = state.lightsState == LightsStatesEnum.POLICE,
                    text = "Police",
                    onClick = {
                        changeState(LightsStatesEnum.POLICE)
                    },
                    modifier = Modifier
                        .weight(1f)
                )
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .height(60.dp)
//                .weight(0.01f)
            ) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .clickable {
                            navigateToSettings()
                        }
                )
                ConnectedStateButton(
                    state = if (state.connectedState) ConnectedStates.CONNECTED else ConnectedStates.DISCONNECTED,
                    onClick = connectButtonClick,
                    modifier = Modifier
                        .weight(1f)
                )
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(
                        bottom = 60.dp
                    )
            ) {
                val scrollState = rememberScrollState()
                Column(
                    modifier = Modifier
                        .verticalScroll(state = scrollState)
                ) {
                    RGBWSliders(
                        item = state.leftRGBWstate,
                        emitStateR = {
                            changeRGBWstate(PositionEnum.LEFT, ColorEnum.RED, it)
                        },
                        emitStateG = {
                            changeRGBWstate(PositionEnum.LEFT, ColorEnum.GREEN, it)
                        },
                        emitStateB = {
                            changeRGBWstate(PositionEnum.LEFT, ColorEnum.BLUE, it)
                        },
                        emitStateW = {
                            changeRGBWstate(PositionEnum.LEFT, ColorEnum.WHITE, it)
                        }
                    )
                    RGBWSliders(
                        item = state.rightRGBWstate,
                        emitStateR = {
                            Log.i("sviki", "hellox");
                            changeRGBWstate(PositionEnum.RIGHT, ColorEnum.RED, it)
                        },
                        emitStateG = {
                            changeRGBWstate(PositionEnum.RIGHT, ColorEnum.GREEN, it)
                        },
                        emitStateB = {
                            changeRGBWstate(PositionEnum.RIGHT, ColorEnum.BLUE, it)
                        },
                        emitStateW = {
                            changeRGBWstate(PositionEnum.RIGHT, ColorEnum.WHITE, it)
                        }
                    )
                }
            }

        }
    )
}
