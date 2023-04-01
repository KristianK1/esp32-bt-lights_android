package hr.kristiankliskovic.bt_sender_basic_control.ui.components

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun OutlineTextWrapper(
    initValue: String = "",
    hidden: Boolean = false,
    label: String,
    placeholder: String = "",
    onChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var str by remember { mutableStateOf(TextFieldValue(initValue)) }
    OutlinedTextField(
        value = str,
        onValueChange = { newText: TextFieldValue ->
            str = newText
            onChange(newText.text)
        },
        visualTransformation = if (hidden) PasswordVisualTransformation() else VisualTransformation.None,
        placeholder = {
            Text(
                text = placeholder,
            )
        },
        label = {
            Text(
                text = label
            )
        },
        singleLine = true,
        modifier = modifier,
    )
}
