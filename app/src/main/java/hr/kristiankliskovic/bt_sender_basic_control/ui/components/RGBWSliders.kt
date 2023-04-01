package hr.kristiankliskovic.bt_sender_basic_control.ui.components

import android.transition.Slide
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class RGBWSlidersViewState(
    val title: String,
    val stateR: SliderWithTitleViewState,
    val stateG: SliderWithTitleViewState,
    val stateB: SliderWithTitleViewState,
    val stateW: SliderWithTitleViewState,
){
    companion object{
        fun empty(): RGBWSlidersViewState{
            return RGBWSlidersViewState(
                title = "",
                stateR = SliderWithTitleViewState.empty(),
                stateG = SliderWithTitleViewState.empty(),
                stateB = SliderWithTitleViewState.empty(),
                stateW = SliderWithTitleViewState.empty(),
            )
        }
    }
}

@Composable
fun RGBWSliders(
    item: RGBWSlidersViewState,
    emitStateR: (Float) -> Unit,
    emitStateG: (Float) -> Unit,
    emitStateB: (Float) -> Unit,
    emitStateW: (Float) -> Unit,
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier
    ){
        Text(
           text = item.title,
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SliderWithTitle(
                item = item.stateR,
                selectValue = emitStateR
            )
            SliderWithTitle(
                item = item.stateG,
                selectValue = emitStateG
            )
            SliderWithTitle(
                item = item.stateB,
                selectValue = emitStateB
            )
            SliderWithTitle(
                item = item.stateW,
                selectValue = emitStateW
            )
        }
    }
}

@Preview
@Composable
fun PreviewRGBWSlider(){
    val stateR by remember {
        mutableStateOf(
            SliderWithTitleViewState(
                text = "R",
                mainColor = Color.Red,
                currentValue = mutableStateOf(0f)
            )
        )
    }

    val stateG by remember {
        mutableStateOf(
            SliderWithTitleViewState(
                text = "G",
                mainColor = Color.Green,
                currentValue = mutableStateOf(0f)
            )
        )
    }

    val stateB by remember {
        mutableStateOf(
            SliderWithTitleViewState(
                text = "B",
                mainColor = Color.Blue,
                currentValue = mutableStateOf(0f)
            )
        )
    }

    val stateW by remember {
        mutableStateOf(
            SliderWithTitleViewState(
                text = "W",
                mainColor = Color.White,
                currentValue = mutableStateOf(0f)
            )
        )
    }

    val state by remember {
        mutableStateOf(
            RGBWSlidersViewState(
                "Left side",
                stateR,
                stateG,
                stateB,
                stateW
            )
        )
    }

    RGBWSliders(
        state,
        emitStateR = {
//            stateR.currentValue = it
        },
        emitStateG = {
//            stateG.currentValue.value = it
        },
        emitStateB = {
//            stateB.currentValue.value = it
        },
        emitStateW = {
//            stateW.currentValue.value = it
        },
        modifier = Modifier
            .padding(10.dp)
            .border(2.dp, Color.Black, RectangleShape)
            .padding(20.dp)
    )
}
