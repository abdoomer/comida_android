package com.example.comida.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.comida.R
import com.example.comida.components.CustomTextField
import com.example.comida.components.CustomTopAppTitleBar
import com.example.comida.components.MainTextButton
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.LabelTextColor
import com.example.comida.ui.theme.PrimaryButtonColor
import com.example.comida.ui.theme.PrimaryTextColor
import com.example.comida.ui.theme.SecondarySmallLabelTextColor
import com.example.comida.ui.theme.TextFieldBackgroundColor
import com.example.comida.ui.theme.poppinsFamily
import com.example.comida.viewmodels.profile.TechnicalSupportViewModel


@Composable
fun TechnicalSupportScreen(
    modifier: Modifier = Modifier,
    onBackButtonClicked: () -> Unit
){

    val viewModel: TechnicalSupportViewModel = hiltViewModel()
    val messageTitle = viewModel.messageTitle.collectAsStateWithLifecycle()
    val messageDescription = viewModel.messageDescription.collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier
            .fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CustomTopAppTitleBar(
                title = "Technical Support",
                haveBackButton = true,
                onBackButtonPressed = onBackButtonClicked
            )

            Image(
                painter = painterResource(R.drawable.ic_technical_support_customer_service),
                contentDescription = "Privacy Policy Screen image"
            )

            TechnicalSupportMessage(
                title = messageTitle.value,
                message = messageDescription.value,
                onMessageTitleChanged = {
                    viewModel.onMessageTitleValueChanged(it)
                },
                onMessageDescriptionChanged = {
                    viewModel.onMessageDescriptionValueChanged(it)
                },
                onSendMessageClicked = {}
            )
        }
    }
}


@Composable
private fun TechnicalSupportMessage(
    modifier: Modifier = Modifier,
    title: String,
    message: String,
    onMessageTitleChanged: (String) -> Unit,
    onMessageDescriptionChanged: (String) -> Unit,
    onSendMessageClicked: () -> Unit
){
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTextField(
            labelText = "Title",
            text = title,
            hintText = "Message Title",
            keyboardType = KeyboardType.Text,
            onTogglePasswordStatusClicked = {},
            onTextValueChanged = {
                onMessageTitleChanged(it)
            }
        )

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Message",
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                color = PrimaryTextColor
            )

            Box(
                modifier = Modifier,
            ){
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxHeight(0.6f),
                    value = message,
                    placeholder = {
                        Text(
                            text = "Message Description",
                            color = LabelTextColor,
                            fontFamily = poppinsFamily,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal
                        )
                    },
                    onValueChange = onMessageDescriptionChanged,
                    shape = RoundedCornerShape(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = TextFieldBackgroundColor,
                        unfocusedContainerColor = TextFieldBackgroundColor,
                        focusedBorderColor = PrimaryButtonColor,
                        unfocusedBorderColor = Color.Transparent,
                        errorBorderColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent,
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    )
                )
            }
        }

        MainTextButton(
            title = "Send Message",
            onClicked = {
                onSendMessageClicked()
            }
        )
    }
}



@Composable
@Preview(showBackground = true, showSystemUi = true)
fun TechnicalSupportScreenPreview(){
    ComidaTheme {
        TechnicalSupportScreen(
            onBackButtonClicked = {}
        )
    }
}