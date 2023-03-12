package com.ther.custom

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.transition.AutoTransition
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.location.FusedLocationProviderClient
import com.ther.custom.ui.theme.CustomTheme
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    private val context: Context = this
    private lateinit var sensorManager: SensorManager
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                ){
                    Text(text = "Hello World!", style = MaterialTheme.typography.h3 )

                    accordion("Sensors"){listSensor(sensors())}
                    accordion("Pings"){listUrls(urls())}
                }
            }
        }
    }


    private fun urls(): List<String> {
        return listOf("https://log.thor-demeestere.workers.dev/", "https://body.thor-demeestere.workers.dev/")
    }

    private fun sensors(): List<Sensor> {
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        return sensorManager.getSensorList(Sensor.TYPE_ALL)
    }
}



@Composable
fun test(){
    Text(text = "Test Button")
}

@Composable
fun listSensor(sensors: List<Sensor>){
    sensors.forEach {
        Text(text = it.name)
    }
}

@Composable
fun listUrls(urls:List<String>){
    urls.forEach {
        var textValu by remember { mutableStateOf("") }
        buttons(it) {
            runBlocking {
                GET(it)
            }.also { textValu = it }
        }

        Text(text = textValu)
    }
}