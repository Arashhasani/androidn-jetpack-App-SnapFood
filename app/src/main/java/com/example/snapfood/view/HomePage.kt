package com.example.snapfood

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.snapfood.model.Category
import com.example.snapfood.ui.theme.*
import com.google.gson.Gson
import com.google.gson.JsonArray
import kotlinx.coroutines.launch
import org.json.JSONArray

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@Composable
fun homePage(
    navController:NavController
){

    val context = LocalContext.current

    MyMainVolley(context)


    val state = rememberScaffoldState();
    val scope = rememberCoroutineScope()
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Scaffold(
            scaffoldState = state ,

            backgroundColor = BackCo,
            topBar = {
                TopAppBar(

                    backgroundColor = Color.White,
                    contentColor = Color.Black,
                    elevation = 0.dp,
                ){
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {

                        IconButton(onClick = { scope.launch { state .drawerState.open() } }, modifier = Modifier.padding(4.dp)) {
                            Icon(Icons.Filled.Menu, contentDescription = "")
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
                Column(modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(
                        rememberScrollState()
                    ), horizontalAlignment = Alignment.CenterHorizontally) {




                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .height(380.dp)
                        .background(Color.White)
                    ) {
                        Card(modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp)
                            .clip(shape = RoundedCornerShape(8.dp))) {
                            editText()
                        }
                        Spacer(modifier = Modifier.padding(4.dp))

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp)) {
                            val cat=Category(name = "Sweet",id="1", description = "descriptiondescription ...", fa_name = "شیرینی")
                            val gson=Gson()
                            val catInfo=gson.toJson(cat)
                            Log.e("3636",catInfo)
                            Column(modifier = Modifier
                                .height(140.dp)
                                .weight(0.3f)
                                .padding(4.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { navController.navigate(Screen.Category_detail.route + "?cat=${catInfo}") }
                                        .height(100.dp)
                                        .clip(shape = RoundedCornerShape(8.dp)),
                                    backgroundColor = BackCo, elevation = 10.dp,
                                ) {
                                    Column(modifier = Modifier
                                        .fillMaxSize()
                                        .padding(14.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                                        Image(painter = painterResource(id = R.drawable.sweet), contentDescription = "")

                                    }

                                }
                                Text(text = "شیرینی" , color = Color.Black, fontFamily = best, modifier = Modifier.padding(top = 8.dp), fontSize = 14.sp)
                            }



                            Column(modifier = Modifier
                                .height(140.dp)
                                .weight(0.3f)
                                .padding(4.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                                Card(modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { navController.navigate(Screen.Category_detail.route) }
                                    .height(100.dp)
                                    .clip(shape = RoundedCornerShape(8.dp)), backgroundColor = BackCo, elevation = 10.dp) {
                                    Column(modifier = Modifier
                                        .fillMaxSize()
                                        .padding(14.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                                        Image(painter = painterResource(id = R.drawable.coffee), contentDescription = "")

                                    }

                                }
                                Text(text = "کافه" , color = Color.Black, fontFamily = best, modifier = Modifier.padding(top = 8.dp), fontSize = 14.sp)
                            }
                            Column(modifier = Modifier
                                .height(140.dp)
                                .weight(0.3f)
                                .padding(4.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { navController.navigate(Screen.Category_detail.route) }
                                        .height(100.dp)
                                        .clip(shape = RoundedCornerShape(8.dp)),
                                    backgroundColor = BackCo, elevation = 10.dp,
                                ) {
                                    Column(modifier = Modifier
                                        .fillMaxSize()
                                        .padding(14.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                                        Image(painter = painterResource(id = R.drawable.milk), contentDescription = "")

                                    }

                                }
                                Text(text = "سوپرمارکت" , color = Color.Black, fontFamily = best, modifier = Modifier.padding(top = 8.dp), fontSize = 14.sp)
                            }
                            Column(modifier = Modifier
                                .height(140.dp)
                                .weight(0.3f)
                                .padding(4.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { navController.navigate(Screen.Category_detail.route) }
                                        .height(100.dp)
                                        .clip(shape = RoundedCornerShape(8.dp)),
                                    backgroundColor = BackCo, elevation = 10.dp,
                                ) {
                                    Column(modifier = Modifier
                                        .fillMaxSize()
                                        .padding(14.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                                        Image(painter = painterResource(id = R.drawable.foodd), contentDescription = "")

                                    }

                                }
                                Text(text = "رستوران" , color = Color.Black, fontFamily = best, modifier = Modifier.padding(top = 8.dp), fontSize = 14.sp)
                            }

                        }
                        Spacer(modifier = Modifier.padding(4.dp))
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp)) {
                            Column(modifier = Modifier
                                .height(140.dp)
                                .weight(0.3f)
                                .padding(4.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { navController.navigate(Screen.Category_detail.route) }
                                        .height(100.dp)
                                        .clip(shape = RoundedCornerShape(8.dp)),
                                    backgroundColor = BackCo, elevation = 10.dp,
                                ) {
                                    Column(modifier = Modifier
                                        .fillMaxSize()
                                        .padding(14.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                                        Image(painter = painterResource(id = R.drawable.sweet), contentDescription = "")

                                    }

                                }
                                Text(text = "شیرینی" , color = Color.Black, fontFamily = best, modifier = Modifier.padding(top = 8.dp), fontSize = 14.sp)
                            }



                            Column(modifier = Modifier
                                .height(140.dp)
                                .weight(0.3f)
                                .padding(4.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { navController.navigate(Screen.Category_detail.route) }
                                        .height(100.dp)
                                        .clip(shape = RoundedCornerShape(8.dp)),
                                    backgroundColor = BackCo, elevation = 10.dp,
                                ) {
                                    Column(modifier = Modifier
                                        .fillMaxSize()
                                        .padding(14.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                                        Image(painter = painterResource(id = R.drawable.meat), contentDescription = "")

                                    }

                                }
                                Text(text = "پروتئین" , color = Color.Black, fontFamily = best, modifier = Modifier.padding(top = 8.dp), fontSize = 14.sp)
                            }
                            Column(modifier = Modifier
                                .height(140.dp)
                                .weight(0.3f)
                                .padding(4.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { navController.navigate(Screen.Category_detail.route) }
                                        .height(100.dp)
                                        .clip(shape = RoundedCornerShape(8.dp)),
                                    backgroundColor = BackCo, elevation = 10.dp,
                                ) {
                                    Column(modifier = Modifier
                                        .fillMaxSize()
                                        .padding(14.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                                        Image(painter = painterResource(id = R.drawable.fruit), contentDescription = "")

                                    }

                                }
                                Text(text = "میوه" , color = Color.Black, fontFamily = best, modifier = Modifier.padding(top = 8.dp), fontSize = 14.sp)
                            }
                            Column(modifier = Modifier
                                .height(140.dp)
                                .weight(0.3f)
                                .padding(4.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { navController.navigate(Screen.Category_detail.route) }
                                        .height(100.dp)
                                        .clip(shape = RoundedCornerShape(8.dp)),
                                    backgroundColor = BackCo, elevation = 10.dp,
                                ) {
                                    Column(modifier = Modifier
                                        .fillMaxSize()
                                        .padding(14.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                                        Image(painter = painterResource(id = R.drawable.bread), contentDescription = "")

                                    }

                                }
                                Text(text = "نان" , color = Color.Black, fontFamily = best, modifier = Modifier.padding(top = 8.dp), fontSize = 14.sp)
                            }

                        }



                    }
                    Text(text = "دسته بندی ها", modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp), fontSize = 18.sp, fontFamily = sans_bold, color = Color.Black,textAlign = TextAlign.Right,style = TextStyle(textDirection = TextDirection.Rtl)
                    )

                    var postlists:JSONArray= JSONArray()
                    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                        LazyRow(modifier = Modifier
                            .fillMaxWidth()){
//                            val que= Volley.newRequestQueue(context)
//                            val url = "https://jsonplaceholder.typicode.com/posts"
//                                val jsonReq=JsonArrayRequest(url, { response ->
//                                    for (i in 0 until response.length()) {
//                                        items(response.length()){
//                                            catCards(name = response.getJSONObject(i).getString("title"))
//                                        }
//                                    }
//
//                                }, {  })
//                            que.add(jsonReq)


//                            items(10) {
//                                catCards(name = it.toString())
//                            }
//                            items(10){
//                                catCards(name = it.toString())
//                            }


//                            Log.e("Apii",carinfos.length.toString())
//                            items(carinfos.length){
//                                for (i in 0 until carinfos.length) {
//                                    Log.e("Apii",carinfos.get(i).toString())
////                                    catCards(name = carinfos.get(i).toString())
//                                }
//
//                            }
                            item {

                                Card(modifier = Modifier
                                    .width(130.dp)
                                    .padding(8.dp)
                                    .clip(shape = RoundedCornerShape(8.dp))
                                    .height(120.dp), elevation = 8.dp) {
                                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                        Image(painter = painterResource(id = R.drawable.f5), contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                                        Box(modifier = Modifier
                                            .fillMaxSize()
                                            .background(BackTr), contentAlignment = Alignment.Center) {
                                            Text(text = "ایرانی", color = Color.White, fontFamily = sans_bold)
                                        }

                                    }

                                }

                                Card(modifier = Modifier
                                    .width(130.dp)
                                    .padding(8.dp)
                                    .clip(shape = RoundedCornerShape(8.dp))
                                    .height(120.dp), elevation = 8.dp) {
                                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                        Image(painter = painterResource(id = R.drawable.f4), contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                                        Box(modifier = Modifier
                                            .fillMaxSize()
                                            .background(BackTr), contentAlignment = Alignment.Center) {
                                            Text(text = "فست فود", color = Color.White, fontFamily = sans_bold)
                                        }

                                    }

                                }



                                Card(modifier = Modifier
                                    .width(130.dp)
                                    .padding(8.dp)
                                    .clip(shape = RoundedCornerShape(8.dp))
                                    .height(120.dp), elevation = 8.dp) {
                                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                        Image(painter = painterResource(id = R.drawable.f3), contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                                        Box(modifier = Modifier
                                            .fillMaxSize()
                                            .background(BackTr), contentAlignment = Alignment.Center) {
                                            Text(text = "کباب", color = Color.White, fontFamily = sans_bold)
                                        }

                                    }

                                }

                                Card(modifier = Modifier
                                    .width(130.dp)
                                    .padding(8.dp)
                                    .clip(shape = RoundedCornerShape(8.dp))
                                    .height(120.dp), elevation = 8.dp) {
                                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                        Image(painter = painterResource(id = R.drawable.f2), contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                                        Box(modifier = Modifier
                                            .fillMaxSize()
                                            .background(BackTr), contentAlignment = Alignment.Center) {
                                            Text(text = "پیتزا", color = Color.White, fontFamily = sans_bold)
                                        }

                                    }

                                }
                                Card(modifier = Modifier
                                    .width(130.dp)
                                    .padding(8.dp)
                                    .clip(shape = RoundedCornerShape(8.dp))
                                    .height(120.dp), elevation = 8.dp) {
                                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                        Image(painter = painterResource(id = R.drawable.f1), contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                                        Box(modifier = Modifier
                                            .fillMaxSize()
                                            .background(BackTr), contentAlignment = Alignment.Center) {
                                            Text(text = "برگر", color = Color.White, fontFamily = sans_bold)
                                        }

                                    }

                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.padding(top = 10.dp))


                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(shape = RoundedCornerShape(20.dp))
                        .padding(start = 20.dp, end = 20.dp), elevation = 4.dp) {
                        Image(painter = painterResource(id = R.drawable.b1), contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)

//                            Image(painter = painterResource(id = R.drawable.b1), contentDescription = "")
                    }
                    Spacer(modifier = Modifier.padding(top=100.dp, bottom = 100.dp))


                }
            },
            bottomBar = {
                bottomBar()

            }
        )
    }

}

@Composable
fun catCards(name:String){
    Card(modifier = Modifier
        .width(130.dp)
        .padding(8.dp)
        .clip(shape = RoundedCornerShape(8.dp))
        .height(120.dp), elevation = 8.dp) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(painter = painterResource(id = R.drawable.f5), contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
            Box(modifier = Modifier
                .fillMaxSize()
                .background(BackTr), contentAlignment = Alignment.Center) {
                Text(text = name, color = Color.White, fontFamily = sans_bold)
            }

        }

    }
}

@Composable
fun editText(){
    var text by remember{ mutableStateOf("") }
//    var text by remember { mutableStateOf("") }
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

            placeholder = { Text("جست و جو ..." , textAlign = TextAlign.Right, fontFamily = best, color = Color.LightGray) },
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



fun MyMainVolley(
    context: Context,

) {
    val que= Volley.newRequestQueue(context)
    val url = "https://jsonplaceholder.typicode.com/posts"

    val jsonRequest= JsonArrayRequest(
        url,{response->for (i in 0 until response.length()) {
            println(response.getJSONObject(i).getString("title"))
        } },{ error-> Log.e("Api",error.toString())}
    )
    que.add(jsonRequest)


}
//fun reassign(response:JSONArray){
//    emptyArray=response
//    for (i in 0 until emptyArray.length()) {
//        println(emptyArray.getJSONObject(i).getString("title"))
//    }
//}


fun jsonParser(jsonarray: JSONArray){
    for (i in 0 until jsonarray.length()) {
        println(jsonarray.getJSONObject(i).getString("title"))

    }
}





