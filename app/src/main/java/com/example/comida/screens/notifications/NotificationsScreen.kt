package com.example.comida.screens.notifications

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.comida.components.CustomTopAppTitleBar
import com.example.comida.models.notifications.AppNotification
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.PrimaryButtonColor
import com.example.comida.ui.theme.PrimaryTextColor
import com.example.comida.ui.theme.SmallLabelTextColor
import com.example.comida.ui.theme.poppinsFamily
import com.example.comida.ui.theme.sofiaFamily
import com.example.comida.viewmodels.notifications.NotificationsViewModel


@Composable
fun NotificationsScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    onBackButtonClicked: () -> Unit,
    onNotificationClicked: (AppNotification) -> Unit
){

    val viewModel: NotificationsViewModel = hiltViewModel()
    val notifications = viewModel.appNotifications.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        viewModel.fetchAllNotifications()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(Color.White)
    ) {
        CustomTopAppTitleBar(
            title = "Notifications",
            haveBackButton = false,
            onBackButtonPressed = onBackButtonClicked
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(notifications.value){ notification ->
                AppNotificationCard(
                    notification = notification,
                    onClicked = {
                        onNotificationClicked(it)
                    }
                )
            }
        }
    }
}


@Composable
private fun AppNotificationCard(
    modifier: Modifier = Modifier,
    notification: AppNotification,
    onClicked: (AppNotification) -> Unit
){
    Card(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .clickable{
                onClicked(notification)
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource( if (notification.isRead) notification.readImage else notification.unreadImage),
                contentDescription = if (notification.isRead) "Read Notification Icon" else "Unread Notification Icon",
                modifier = Modifier
                    .size(60.dp)
            )

            Column() {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp, top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = notification.title,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        color = PrimaryTextColor
                    )

                    Text(
                        text = notification.date,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 11.sp,
                        color = PrimaryButtonColor
                    )
                }

                Text(
                    text = notification.description,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = sofiaFamily,
                    color = SmallLabelTextColor,
                    maxLines = 4
                )
            }
        }
    }
}



@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun NotificationsScreenPreview(){
    ComidaTheme {
        NotificationsScreen(
            paddingValues = PaddingValues(0.dp),
            onNotificationClicked = {},
            onBackButtonClicked = {}
        )
    }
}