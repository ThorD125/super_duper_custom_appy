package com.ther.custom

import android.hardware.Sensor
import android.print.PrintAttributes.Margins
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun buttons(name: String, doingFun: () -> Unit) {
    Button(onClick = doingFun) {
        Text(text = name)
    }
}

@Composable
fun inputFields(
    name: String,
): String{
    Text(
        text = name,
    )
    var Input by remember { mutableStateOf("") }
    TextField(value = Input, onValueChange = {Input = it})
    return Input
}

@Composable
fun images(name: Int){
    val image = painterResource(name)
    Image(
        painter = image,
        contentDescription = null,
    )
}

@Composable
fun switchs(name: String, fl: Float): Boolean{
    Text(
        text = name,
    )
    var bool by remember { mutableStateOf(false) }
    Switch(
        checked = bool,
        onCheckedChange = { bool = it },
        modifier = Modifier.alpha(fl),
    )
    return bool
}


@Composable
fun accordion(buttonText: String,doingFun: @Composable () -> @Composable Unit) {
    Column(

        Modifier.border(1.dp, MaterialTheme.colors.secondary, MaterialTheme.shapes.medium).fillMaxWidth(),

    ){
        val height = remember { mutableStateOf(Modifier.height(0.dp)) }
        buttons(buttonText) {
            if (height.value == Modifier.height(0.dp)) {
                height.value = Modifier
            } else {
                height.value = Modifier.height(0.dp)
            }
        }
        Column(modifier = height.value){
            doingFun()
        }

    }
}