package com.devby.userapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.devby.userapp.model.Address
import com.devby.userapp.model.Company
import com.devby.userapp.model.Geo
import com.devby.userapp.model.User
import com.devby.userapp.screens.DetailScreen
import com.devby.userapp.screens.UserList
import com.devby.userapp.ui.theme.UserAppTheme
import com.devby.userapp.viewmodel.DetailViewModel
import com.devby.userapp.viewmodel.UserViewModel
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val viewModel : UserViewModel by viewModels<UserViewModel>()
    private val detailViewModel : DetailViewModel by viewModels<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()


            UserAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){
                        NavHost(navController = navController, startDestination ="liste_ekrani"){
                            composable("liste_ekrani"){
                                viewModel.getUsers()
                                UserList(userList = viewModel.userList.value,navController = navController)
                            }
                            composable("detay_ekrani/{choosenUser}",
                                arguments = listOf(
                                    navArgument("choosenUser"){
                                        type = NavType.IntType
                                    }
                                )
                            ) {
                                val userIndex = remember {
                                    it.arguments?.getInt("choosenUser")
                                }
                                /* val choosenUser = remember {
                                    mutableStateOf(User(1,"","","", Address("","","","",Geo("","")),"",
                                        "",Company("","","")))
                                }
                                LaunchedEffect(key1 = Unit) {
                                    choosenUser.value = detailViewModel.getSingleUser(userIndex?:0)
                                }
                                 */

                                val choosenUser = produceState(initialValue = User(1,"","","", Address("","","","",Geo("","")),"",
                                    "",Company("","","")
                                )) {
                                    value = detailViewModel.getSingleUser(userIndex?:0)
                                }
                                DetailScreen(user = choosenUser.value)

                            }
                        }
                    }
                }
            }
        }
    }
}
