package com.example.snapfood

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.snapfood.model.Category
import com.google.gson.Gson

@Composable
fun setupNavGraph(
    navController:NavHostController
){
    val cat= Category(name = "",id="", description = " ...", fa_name = "")
    val gson= Gson()
    val catinfo= gson.toJson(cat)
    NavHost(navController = navController, startDestination = Screen.Home_page.route) {
        composable(route=Screen.Home_page.route){ homePage(navController)}
        composable(route=Screen.Category_detail.route+"?cat={cat}", arguments = listOf(
            navArgument("cat"){type=
                NavType.StringType
                defaultValue=catinfo
            },

        )){
            it.arguments?.getString("cat")?.let { it1 -> categoryDetail(cate= it1,navController) }
        }
    }

}