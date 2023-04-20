package com.example.snapfood.network

import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
var res:String=""


fun MyMainVolley(
    context: Context,
) {


    val que= Volley.newRequestQueue(context)
    val url = "https://jsonplaceholder.typicode.com/posts"

    val jsonRequest= JsonArrayRequest(
        url,{response-> jsonParser(response) },{ error-> Log.e("Api",error.toString())}
    )
    que.add(jsonRequest)

}


fun jsonParser(jsonarray:JSONArray){
    for (i in 0 until jsonarray.length()) {
        println(jsonarray.getJSONObject(i).getString("title"))
        println(jsonarray.getJSONObject(i).getString("userId"))
    }
}




