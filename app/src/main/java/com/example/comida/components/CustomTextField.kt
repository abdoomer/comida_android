package com.example.comida.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.comida.R
import com.example.comida.ui.theme.LabelTextColor
import com.example.comida.ui.theme.PrimaryButtonColor
import com.example.comida.ui.theme.PrimaryTextColor
import com.example.comida.ui.theme.SecondarySmallLabelTextColor
import com.example.comida.ui.theme.TextFieldBackgroundColor
import com.example.comida.ui.theme.poppinsFamily


@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    text: String,
    hintText: String,
    labelText: String,
    keyboardType: KeyboardType,
    passwordObscured: Boolean = false,
    onTextValueChanged: (String) -> Unit,
    onTogglePasswordStatusClicked: () -> Unit,
){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            text = labelText,
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            color = PrimaryTextColor
        )

        Box(
            modifier = Modifier,
        ){
            OutlinedTextField(
                modifier = Modifier,
                value = text,
                placeholder = {
                    Text(
                        text = hintText,
                        color = LabelTextColor,
                        fontFamily = poppinsFamily,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    )
                },
                onValueChange = onTextValueChanged,
                shape = RoundedCornerShape(16.dp),
                trailingIcon = {
                    if (labelText != "Password") null else {
                        Button(
                            modifier = Modifier
                                .align(Alignment.CenterEnd),
                            onClick = onTogglePasswordStatusClicked,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent
                            )
                        ) {
                            if (passwordObscured){
                                Icon(
                                    painter = painterResource(R.drawable.show_password_icon),
                                    contentDescription = "Show Password",
                                    tint = SecondarySmallLabelTextColor,
                                    modifier = Modifier
                                        .size(24.dp)
                                )
                            } else {
                                Icon(
                                    painter = painterResource(R.drawable.hide_password_icon),
                                    contentDescription = "Show Password",
                                    tint = SecondarySmallLabelTextColor,
                                    modifier = Modifier
                                        .size(24.dp)
                                )
                            }
                        }
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = TextFieldBackgroundColor,
                    unfocusedContainerColor = TextFieldBackgroundColor,
                    focusedBorderColor = PrimaryButtonColor,
                    unfocusedBorderColor = Color.Transparent,
                    errorBorderColor = Color.Transparent,
                    disabledBorderColor = Color.Transparent,
                ),
                visualTransformation = if (passwordObscured) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType
                )
            )
        }
    }
}