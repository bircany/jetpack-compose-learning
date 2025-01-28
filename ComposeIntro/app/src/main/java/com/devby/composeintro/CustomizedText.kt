package com.devby.composeintro

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun customizedText(text:String){
    Text(modifier = Modifier.clickable {
        println("text tıklandı")
    }
        .background(color = Color.Black)
        .fillMaxWidth(0.9f)
        .padding(top=10.dp, start = 3.dp, end = 3.dp, bottom = 5.dp)
        //.width(200.dp)  non-relative
        //.height(100.dp)



        ,
        text = text,
        color = Color.White,
        textAlign = TextAlign.Center,
        fontSize = 26.sp

    )

}
@Preview(showBackground = true)
@Composable
fun PrivatePreview(){
    customizedText(text = "Merhaba Compose")

}
