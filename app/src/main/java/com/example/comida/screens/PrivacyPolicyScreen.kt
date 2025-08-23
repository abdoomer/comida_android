package com.example.comida.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.comida.ui.theme.ComidaTheme


@Composable
fun PrivacyPolicyScreen(
    modifier: Modifier = Modifier
){}



@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun PrivacyPolicyScreenPreview(){
    ComidaTheme {
        PrivacyPolicyScreen()
    }
}