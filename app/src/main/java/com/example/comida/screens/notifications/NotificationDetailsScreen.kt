package com.example.comida.screens.notifications

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.comida.components.CustomTopAppTitleBar
import com.example.comida.models.AppNotification
import com.example.comida.models.appNotifications
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.PrimaryButtonColor
import com.example.comida.ui.theme.PrimaryTextColor
import com.example.comida.ui.theme.SmallLabelTextColor
import com.example.comida.ui.theme.bebasFamily
import com.example.comida.ui.theme.poppinsFamily
import com.example.comida.ui.theme.sofiaFamily
import com.example.comida.viewmodels.notifications.NotificationDetailsViewModel


@Composable
fun NotificationDetailsScreen(
    modifier: Modifier = Modifier,
    onBackButtonClicked: () -> Unit,
    onMarkAsReadClicked: (AppNotification) -> Unit
){

    val viewModel: NotificationDetailsViewModel = hiltViewModel()
    val notification = viewModel.notification.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        viewModel.fetNotification()
    }

    Scaffold(
        modifier = modifier
            .fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
        ) {
            CustomTopAppTitleBar(
                title = "Notification",
                haveBackButton = true,
                onBackButtonPressed = onBackButtonClicked
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = notification.value.title,
                    fontFamily = poppinsFamily,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryTextColor
                )

                TextButton(
                    onClick = {
                        onMarkAsReadClicked(notification.value)
                    }
                ) {
                    Text(
                        "Mark as read",
                        fontFamily = poppinsFamily,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        color = PrimaryButtonColor
                    )
                }
            }

            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                text = notification.value.description,
                fontFamily = sofiaFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = SmallLabelTextColor
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = notification.value.date,
                    fontFamily = bebasFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = PrimaryButtonColor.copy(alpha = 0.7f)
                )
            }
        }
    }
}



@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun NotificationDetailsScreenPreview(){
    ComidaTheme {
        NotificationDetailsScreen(
            onBackButtonClicked = {},
            onMarkAsReadClicked = {}
        )
    }
}