package com.example.navigationsimple

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Third(
    onClick:()->Unit = {},
    onCancelClick:()->Unit,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        OutlinedButton(onClick = onClick) {
            Text(text = "Третий экран")
        }
        OutlinedButton(onClick = onCancelClick) {
            Text(text = "Отменить")
        }
    }

}

@Preview
@Composable
fun ThirdPreview(){
   Third {

   }
}