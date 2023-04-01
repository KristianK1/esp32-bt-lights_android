package hr.kristiankliskovic.bt_sender_basic_control.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Slider
import androidx.compose.material.SliderColors
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class SliderWithTitleViewState(
    val text: String,
    val mainColor: Color,
    val currentValue: MutableState<Float>,
){
    companion object{
        fun empty(): SliderWithTitleViewState{
            return SliderWithTitleViewState(
                text = "",
                mainColor = Color.Black,
                currentValue = mutableStateOf(0f)
            )
        }
    }
}


@Composable
fun SliderWithTitle(
    item: SliderWithTitleViewState,
    selectValue: (Float) -> Unit,
    modifier: Modifier = Modifier,
){
    Column(
        modifier = Modifier
            .size(60.dp, 300.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(Color.LightGray)
            .padding(
                horizontal = 0.dp,
                vertical = 10.dp,
            )
    )   {
        Text(
            text = item.text,
            fontSize = 30.sp,
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(10.dp),
            color = item.mainColor,
            fontWeight = FontWeight.Bold,
        )
        VerticalSlider(
            value = item.currentValue.value,
            onValueChange = { it ->
                item.currentValue.value = it
                Log.i("slider", "$it")
                selectValue(it)
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            colors = SliderDefaults.colors(
                activeTickColor = item.mainColor,
                activeTrackColor = item.mainColor,
                inactiveTickColor = Color.LightGray,
                thumbColor = item.mainColor,
            )
        )
    }
}

@Preview
@Composable
fun PreviewSliderComponent(){

    val state by remember{
        mutableStateOf(
            SliderWithTitleViewState(
                text = "R",
                mainColor = Color.Red,
                currentValue = mutableStateOf(0f),
            )
        )
    }

    SliderWithTitle(
        item = state,
        selectValue = { value ->
            Log.i("slider", "changed To $value")
            state.currentValue.value = value
        }
    )
}


@Composable
fun VerticalSlider(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    valueRange: ClosedFloatingPointRange<Float> = 0f..100f,
    /*@IntRange(from = 0)*/
    steps: Int = 0,
    onValueChangeFinished: (() -> Unit)? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    colors: SliderColors = SliderDefaults.colors()
){
    Slider(
        colors = colors,
        interactionSource = interactionSource,
        onValueChangeFinished = onValueChangeFinished,
        steps = steps,
        valueRange = valueRange,
        enabled = enabled,
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .graphicsLayer {
                rotationZ = 270f
                transformOrigin = TransformOrigin(0f, 0f)
            }
            .layout { measurable, constraints ->
                val placeable = measurable.measure(
                    Constraints(
                        minWidth = constraints.minHeight,
                        maxWidth = constraints.maxHeight,
                        minHeight = constraints.minWidth,
                        maxHeight = constraints.maxHeight,
                    )
                )
                layout(placeable.height, placeable.width) {
                    placeable.place(-placeable.width, 0)
                }
            }
            .then(modifier)
    )
}
