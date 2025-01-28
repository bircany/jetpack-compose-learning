package com.devby.foodrecipescompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.devby.foodrecipescompose.model.Food
import com.devby.foodrecipescompose.ui.theme.FoodRecipesComposeTheme
import com.google.gson.Gson

@Composable
fun FoodList(foods : List<Food>,navController: NavController){
    LazyColumn (contentPadding = PaddingValues(5.dp),
        modifier = Modifier.fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
        ) {
        items(foods){
            FoodRow(food = it, navController = navController)
        }
    }
}
@Composable
fun FoodRow(food: Food, navController: NavController){
    Column(modifier = Modifier.fillMaxWidth()
        .background(color = MaterialTheme.colorScheme.background)
        .clickable {
            navController.navigate("detay_ekrani/${Gson().toJson(food)}")


        }
    ) {
        Text(text = food.name,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.padding(5.dp),
            fontWeight = FontWeight.Bold

            )
        Text(text = food.ingredients,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(5.dp),
            fontWeight = FontWeight.Normal
            )

    }
}

