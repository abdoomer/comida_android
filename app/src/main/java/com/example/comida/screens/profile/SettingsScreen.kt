package com.example.comida.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.comida.R
import com.example.comida.components.CustomTopAppTitleBar
import com.example.comida.models.profile.SettingsHeaderTile
import com.example.comida.models.profile.SettingsHeaderTileType
import com.example.comida.ui.theme.ComidaTheme
import com.example.comida.ui.theme.PrimaryButtonColor
import com.example.comida.ui.theme.SmallLabelColor
import com.example.comida.ui.theme.poppinsFamily
import com.example.comida.viewmodels.profile.SettingsViewModel


@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    onBackButtonClicked: () -> Unit
){

    val viewModel: SettingsViewModel = hiltViewModel()
    val settingsHeaderTiles = viewModel.settingsHeaderTiles.collectAsStateWithLifecycle()

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
                title = "Settings",
                haveBackButton = true,
                onBackButtonPressed = onBackButtonClicked
            )

            Image(
                painter = painterResource(R.drawable.ic_settings_screen_icon),
                contentDescription = "Settings Screen image",
                modifier = Modifier
                    .size(300.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(settingsHeaderTiles.value){ tile ->
                    SettingsTile(
                        tile = tile,
                        showTileOptions = tile.showOptions,
                        onTileClicked = {
                            viewModel.onTileTapped(it)
                        }
                    )
                }
            }
        }
    }
}


@Composable
private fun SettingsTile(
    modifier: Modifier = Modifier,
    tile: SettingsHeaderTile,
    showTileOptions: Boolean,
    onTileClicked: (SettingsHeaderTile) -> Unit
){
    Column(
        modifier = modifier
    ) {
        Card(
            modifier = Modifier
                .clickable{
                    onTileClicked(tile)
                },
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Icon(
                        painter = painterResource(tile.image),
                        contentDescription = tile.title,
                        tint = PrimaryButtonColor,
                        modifier = Modifier
                            .size(20.dp)
                    )

                    Text(
                        text = tile.title,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = poppinsFamily,
                        fontSize = 18.sp,
                        color = SmallLabelColor
                    )
                }

                Icon(
                    painter = painterResource(
                        if (showTileOptions) R.drawable.up_arrow_icon else R.drawable.down_arrow_icon
                    ),
                    contentDescription = tile.title,
                    tint = SmallLabelColor,
                    modifier = Modifier
                        .size(20.dp)
                )
            }
        }

//        if (tile.showOptions){
//            SettingsCard(
//                type = tile.type
//            )
//        }
    }
}


@Composable
private fun SettingsCard(
    modifier: Modifier = Modifier,
    type: SettingsHeaderTileType
){
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        when(type){
            SettingsHeaderTileType.Appearance -> {}
            SettingsHeaderTileType.Notification -> {}
        }
    }
}



@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun SettingsScreenPreview(){
    ComidaTheme {
        SettingsScreen(
            onBackButtonClicked = {}
        )
    }
}