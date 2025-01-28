package com.devby.statemanagementcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devby.statemanagementcompose.ui.theme.StateManagementComposeTheme

//State Management,Recomposition

@Composable
fun OtherExamples(){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var input = remember { mutableStateOf("") }
        var textValue = remember { mutableStateOf("Merhaba Android") }
        var paddingValue = remember { mutableStateOf(10.dp) }
        TextField(value = input.value, onValueChange = {
            input.value = it
        }, placeholder =  {
            Text("Yasinizi Giriniz!")
        })

        Spacer(modifier = Modifier.padding(paddingValue.value))
        Text(text = textValue.value)
        Spacer(modifier = Modifier.padding(paddingValue.value))
        Button(onClick = {
            textValue.value = "Merhaba Bircan"
            paddingValue.value = 20.dp
        }, enabled = true) {
            Text("Ornek Button")
        }
        Spacer(modifier = Modifier.padding(paddingValue.value))
        Image(bitmap = ImageBitmap.imageResource(id = R.drawable.istanbul),
            contentDescription = "Istanbul",
            modifier = Modifier.size(350.dp,220.dp)
        )
        Spacer(modifier = Modifier.padding(paddingValue.value))
        Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_background ),
            contentDescription = "test")
        Spacer(modifier = Modifier.padding(paddingValue.value))
        Image(painter = ColorPainter(Color.Red),
            contentDescription = "red",
            modifier = Modifier.size(100.dp,100.dp)
        )
    }
}
