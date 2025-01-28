package com.devby.foodrecipescompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devby.foodrecipescompose.model.Food
import com.devby.foodrecipescompose.ui.theme.FoodRecipesComposeTheme

@Composable
fun DetailsScreen(food: Food){
    Box(modifier = Modifier.fillMaxSize()
        .background(color = MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
    ){
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = food.name,
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier.padding(5.dp),
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
                )
            Image(bitmap = ImageBitmap.imageResource(id = food.image),
                contentDescription = food.name,
                modifier = Modifier.padding(16.dp)
                    .size(300.dp,200.dp)
            )
            Text(text = food.ingredients,
                style=MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(2.dp),
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}
