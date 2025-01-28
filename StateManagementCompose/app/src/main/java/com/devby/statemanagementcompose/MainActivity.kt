package com.devby.statemanagementcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devby.statemanagementcompose.ui.theme.StateManagementComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StateManagementComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){
                        MainScreen()
                    }

                }
            }
        }
    }
}

//State Hoisting (stateles functions)
@Composable
fun MainScreen(){
    var userName = remember { mutableStateOf("Kullanıcı Adi") }
    var email = remember { mutableStateOf("Email") }


    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PrivateText("Kayıt Formu")
        Spacer(modifier = Modifier.padding(10.dp))
        PrivateTextField(userName.value, onValueChangeFunction = {
            userName.value = it
        })
        Spacer(modifier = Modifier.padding(10.dp))
        PrivateTextField(email.value, onValueChangeFunction = {
            email.value = it
        })
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick = {

        }) {
            Text("Kayıt Ol")
        }
























    }
}
@Composable
fun PrivateTextField(string:String,onValueChangeFunction : (String) -> Unit){
    TextField(value = string, onValueChange = onValueChangeFunction, modifier = Modifier.padding(5.dp))
}


@Composable
fun PrivateText(string:String){
    Text(text=string,
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Italic
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StateManagementComposeTheme {
        MainScreen()
    }
}