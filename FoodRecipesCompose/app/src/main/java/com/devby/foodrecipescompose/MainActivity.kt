package com.devby.foodrecipescompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.devby.foodrecipescompose.model.Food
import com.devby.foodrecipescompose.ui.theme.FoodRecipesComposeTheme
import com.google.gson.Gson


//Lazy Columng and Navigation
class MainActivity : ComponentActivity() {
    private val foodList = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            FoodRecipesComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){
                        NavHost(navController = navController , startDestination = "liste_ekrani"){
                            composable("liste_ekrani") {
                                createData()
                                FoodList(foods = foodList, navController = navController)
                            }
                            composable("detay_ekrani/{choosenFood}",
                                arguments = listOf(
                                    navArgument("choosenFood"){
                                        type = NavType.StringType
                                    }
                                )
                            ) {
                                val foodString = remember {
                                    it.arguments?.getString("choosenFood")
                                }
                                val choosenFood = Gson().fromJson(foodString,Food::class.java)
                                DetailsScreen(food = choosenFood)
                            }
                        }
                    }
                }
            }
        }
    }


    private fun createData(){
        val pizza = Food("Pizza","Hamur,Peynir,Sucuk",R.drawable.pizza)
        val makarna = Food("Makarna","Penne,Domates,Fesleğen",R.drawable.makarna)
        val kofte = Food("Kofte","Kıyma,Ekmek,Pirinç",R.drawable.kofte)
        val salata = Food("Salata","Domates,Salatalık,Sogan",R.drawable.salata)
        val ekmek = Food("Ekmek","Hamur,Maya",R.drawable.ekmek)

        foodList.add(pizza)
        foodList.add(makarna)
        foodList.add(kofte)
        foodList.add(salata)
        foodList.add(ekmek)

    }
}

