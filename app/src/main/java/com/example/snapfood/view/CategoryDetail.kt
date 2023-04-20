package com.example.snapfood

import android.R.color
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.snapfood.model.Category
import com.example.snapfood.ui.theme.BackCo
import com.example.snapfood.ui.theme.RestaurantName
import com.example.snapfood.ui.theme.best
import com.example.snapfood.ui.theme.sans_bold
import com.google.gson.Gson

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun categoryDetail(cate:String,navController: NavController){
    val state= rememberScaffoldState();
    val scope= rememberCoroutineScope()
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Scaffold(

            backgroundColor = BackCo,
            topBar = {
                TopAppBar(

                    backgroundColor = Color.White,
                    contentColor = Color.Black,
                    elevation = 0.dp,
                ){
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {

                        IconButton(onClick = { navController.navigate(Screen.Home_page.route){popUpTo(Screen.Home_page.route){inclusive=true} } }, modifier = Modifier.padding(4.dp)) {
                            Icon(Icons.Filled.ArrowForward, contentDescription = "")
                        }
                        Text(text = "آدرس اینجا قرار میگیرد", modifier = Modifier.padding(4.dp), color = Color.Black, fontFamily = sans_bold)
                        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(4.dp)) {
                            Icon(Icons.Filled.ShoppingCart, contentDescription = "")
                        }
                    }
                }


            },
            floatingActionButton = {},
            drawerContent = { },
            content = {
                val gson= Gson();
                val catIno=gson.fromJson(cate,Category::class.java)

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(
                            rememberScrollState()
                        ), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                        .background(Color.White)
                    ) {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp, end = 10.dp)
                                .clip(shape = RoundedCornerShape(8.dp))
                        ) {
                            editTextCategory(catIno.fa_name)
                        }
//                    Spacer(modifier = Modifier.padding(4.dp))
                        Text(text = "14 شیرینی باز", color = Color.Black, fontFamily = sans_bold, fontSize = 20.sp, textAlign = TextAlign.Right, modifier = Modifier
                            .padding(14.dp)
                            .fillMaxWidth())
                    }
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(14.dp))
                        .padding(10.dp), backgroundColor = Color.White, elevation = 4.dp) {
                        Image(painter = painterResource(id = R.drawable.b2), contentDescription = "", contentScale = ContentScale.FillWidth, modifier = Modifier.fillMaxWidth())


                    }
                    Spacer(modifier = Modifier.padding(10.dp))

                    for (i in 1..10){
                        Card(modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .clip(shape = RoundedCornerShape(14.dp))
                            .padding(10.dp), backgroundColor = Color.White, elevation = 4.dp) {
                            Column(modifier = Modifier.fillMaxSize()) {
                                Image(painter = painterResource(id = R.drawable.s1), contentDescription = "", contentScale = ContentScale.FillWidth, modifier = Modifier.fillMaxWidth())
                                Row(modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                                    Text(text = "2405040", fontSize = 14.sp, color = Color.Gray, fontFamily = best)
                                    Text(text = "کافه قنادی ناتالی", fontSize = 14.sp, color = RestaurantName, fontFamily = best)
                                }
                                Row(modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                                    Text(text = "تا 40 دقیقه", fontSize = 14.sp, color = Color.Gray, fontFamily = best)
                                    Text(text = "ارسال اکسپرس : 14000 تومان", fontSize = 14.sp, color = RestaurantName, fontFamily = best)
                                }


                            }

                        }
                    }


                }
            },
            bottomBar = {
                bottomBar()
            }
        )
    }

}



@Composable
fun editTextCategory(fa_name:String){
    var text by remember { mutableStateOf("") }
    val isVisible by remember {
        derivedStateOf {
            text.isNotBlank()
        }
    }
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        OutlinedTextField(
            value = text,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White),

            placeholder = { Text("جست و جو در ${fa_name}" , textAlign = TextAlign.Right, fontFamily = best, color = Color.LightGray) },
            modifier = Modifier
                .fillMaxWidth()
                .background(BackCo),
            onValueChange = {
                text = it
            },
            leadingIcon = {
                Icon(
                    Icons.Filled.Search,
                    tint = Color.LightGray,
                    contentDescription = ""
                )
            },

            trailingIcon = {
                if (isVisible) {
                    IconButton(
                        onClick = { text = "" }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Clear"
                        )
                    }
                }
            }
        )
    }

}
