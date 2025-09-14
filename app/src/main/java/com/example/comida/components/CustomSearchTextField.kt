package com.example.comida.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.comida.R
import com.example.comida.ui.theme.IconsColor
import com.example.comida.ui.theme.PrimaryButtonColor
import com.example.comida.ui.theme.SearchLabelTextColor
import com.example.comida.ui.theme.TextFieldBackgroundColor
import com.example.comida.ui.theme.poppinsFamily


@Composable
fun CustomSearchTextField(
    modifier: Modifier = Modifier,
    searchText: String,
    placeHolderText: String,
    onSearchTextChanged: (String) -> Unit,
    onSearchButtonClicked: () -> Unit,
){
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        value = searchText,
        shape = RoundedCornerShape(16.dp),
        onValueChange = onSearchTextChanged,
        placeholder = {
            Text(
                text = placeHolderText,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                color = SearchLabelTextColor
            )
        },
        leadingIcon = {
            Button(
                onClick = onSearchButtonClicked,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )
            ) {
                Icon(
                    painter = painterResource(R.drawable.search_icon),
                    contentDescription = "Search TextField Icon",
                    tint = IconsColor,
                    modifier = Modifier
                        .size(24.dp)
                )
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = TextFieldBackgroundColor,
            unfocusedContainerColor = TextFieldBackgroundColor,
            focusedBorderColor = PrimaryButtonColor,
            unfocusedBorderColor = Color.Transparent,
            errorBorderColor = Color.Transparent,
            disabledBorderColor = Color.Transparent,
        )
    )
}