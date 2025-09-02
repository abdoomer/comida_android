package com.example.comida.screens.auth

import android.annotation.SuppressLint
import android.view.KeyEvent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.comida.R
import com.example.comida.components.MainTextButton
import com.example.comida.models.OTPAction
import com.example.comida.models.OTPState
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.PrimaryButtonColor
import com.example.comida.ui.theme.PrimaryTextColor
import com.example.comida.ui.theme.TextFieldBackgroundColor
import com.example.comida.ui.theme.bebasFamily
import com.example.comida.ui.theme.poppinsFamily
import com.example.comida.viewmodels.auth.OTPViewmodel


@Composable
fun OTPVerificationScreen(
    modifier: Modifier = Modifier,
    viewModel: OTPViewmodel,
    onBackButtonClicked: () -> Unit
){

    val otpState by viewModel.otpState.collectAsStateWithLifecycle()
    val focusRequesters = remember {
        (1..4).map { FocusRequester() }
    }
    val focusManager = LocalFocusManager.current
    val keyboardManager = LocalSoftwareKeyboardController.current

    LaunchedEffect(otpState.focusedIndex) {
        otpState.focusedIndex?.let { index ->
            focusRequesters.getOrNull(index)?.requestFocus()
        }
    }

    LaunchedEffect(key1 = otpState.otpCode, keyboardManager) {
        val allNumbersEntered = otpState.otpCode.none { it == null }

        if (allNumbersEntered) {
            focusRequesters.forEach { it.freeFocus() }

            focusManager.clearFocus()

            keyboardManager?.hide()
        }
    }


    Box(
        modifier = modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(R.drawable.verfication_code_screen_background_image),
            contentDescription = "OTP Verification Screen Background Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .fillMaxWidth()
                .height(387.dp)
                .background(Color.Black)
        )

        Column(
            modifier = Modifier
                .padding(start = 16.dp, top = 32.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = onBackButtonClicked,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp),
            ) {
                Icon(
                    painter = painterResource(R.drawable.back_button_icon),
                    contentDescription = "Back Button",
                    tint = Color.Black,
                    modifier = Modifier
                        .width(5.dp)
                        .height(9.68.dp)
                )
            }

            Text(
                text = "Verification",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                fontFamily = poppinsFamily,
            )

            Text(
                text = "Please type the code sent \nto email@gmail.com",
                color = Color.White,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                modifier = Modifier
                    .alpha(0.8f)
            )
        }

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .background(Color.White)
                .align(Alignment.BottomEnd)
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OTPTextFields(
                   state = otpState,
                    onAction = { action ->
                        when(action){
                            is OTPAction.OnEnterNumber -> {
                                focusRequesters[action.index].freeFocus()
                            }

                            else -> Unit
                        }
                        viewModel.onAction(action)
                    },
                    focusRequesters = focusRequesters
                )

                TextButton(
                    onClick = {
                        viewModel.resendOTPCode()
                    }
                ) {
                    Text(
                        text = "Resend Again",
                        fontFamily = bebasFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = PrimaryButtonColor
                    )
                }


                MainTextButton(
                    title = "Verify Code",
                    onClicked = {
                        viewModel.verifyOTPCode()
                    }
                )
            }
        }
    }
}


@Composable
private fun OTPTextFields(
    modifier: Modifier = Modifier,
    state: OTPState,
    focusRequesters: List<FocusRequester>,
    onAction: (OTPAction) -> Unit
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
        ) {
            state.otpCode.forEachIndexed { index, number ->
                OTPTextField(
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f),
                    number = number,
                    focusRequester = focusRequesters[index],
                    onNumberChanged = { newNumber ->
                        onAction(OTPAction.OnEnterNumber(newNumber, index))
                    },
                    onFocusChanged = { isFocused ->
                        if (isFocused){
                            onAction(OTPAction.OnChangedFieldFocused(index = index))
                        }
                    },
                    onKeyboardBackButtonPressed = {
                        onAction(OTPAction.OnKeyboardBackButtonPressed)
                    }
                )
            }
        }

        state.isValid?.let { isValid ->
            Text(
                text = if (isValid) "OTP is valid" else "OTP is invalid",
                color = if (isValid) Color.Green else Color.Red,
                fontSize = 16.sp
            )
        }
    }
}


@Composable
private fun OTPTextField(
    modifier: Modifier = Modifier,
    number: Int?,
    focusRequester: FocusRequester,
    onNumberChanged: (Int?) -> Unit,
    onFocusChanged: (Boolean) -> Unit,
    onKeyboardBackButtonPressed: () -> Unit
){

    val text by remember(number) { mutableStateOf(
        TextFieldValue(
            text = number?.toString().orEmpty(),
            selection = TextRange(
                index = if (number != null) 1 else 0
            )
        )
    ) }

    var isFocused by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .border(
                width = 1.dp,
                color = if (isFocused) PrimaryButtonColor else Color.Transparent,
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp))
            .background(TextFieldBackgroundColor),
        contentAlignment = Alignment.Center
    ){
        BasicTextField(
            modifier = Modifier
                .padding(10.dp)
                .focusRequester(focusRequester)
                .onFocusChanged {
                    isFocused = it.isFocused

                    onFocusChanged(it.isFocused)
                }
                .onKeyEvent { event ->
                    val didPressBackButton = event.nativeKeyEvent.keyCode == KeyEvent.KEYCODE_DEL

                    if (didPressBackButton && number == null){
                        onKeyboardBackButtonPressed()
                    }

                    false
                },
            value = text,
            onValueChange = { newText ->
                val newNumber = newText.text

                if (newNumber.length <= 1 && newNumber.isDigitsOnly()){
                    onNumberChanged(newNumber.toIntOrNull())
                }
            },
            singleLine = true,
            cursorBrush = SolidColor(PrimaryButtonColor),
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Light,
                fontSize = 36.sp,
                color = if (isFocused) PrimaryButtonColor else PrimaryTextColor
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword
            ),
            decorationBox = { innerBox ->

                innerBox()

                if(!isFocused && number == null){
                    Text(
                        text = "-",
                        textAlign = TextAlign.Center,
                        color = if (isFocused) PrimaryButtonColor else PrimaryTextColor,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize()
                    )
                }
            }
        )
    }
}



@SuppressLint("ViewModelConstructorInComposable")
@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun OTPVerificationScreenPreview(){
    ComidaTheme {
//        OTPVerificationScreen(
//            viewModel = OTPViewmodel()
//        )
    }
}