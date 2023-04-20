package com.example.snapfood

sealed class Screen (val route:String) {
    object Home_page:Screen("home_page")
    object Category_detail:Screen("category_detail")
}