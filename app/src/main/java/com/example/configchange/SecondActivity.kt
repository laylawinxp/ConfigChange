package com.example.configchange

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.configchange.ui.theme.ConfigChangeTheme

class SecondActivity : ComponentActivity() {
    private val TAG: String = "SecondActivity"
    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        number = intent.getIntExtra("number", 0)

        Log.d(TAG, "onCreate(): number = $number")

        setContent {
            ConfigChangeTheme {
                SecondScreen(number * number)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart(): counter = $number")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume(): counter = $number")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause(): counter = $number")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop(): counter = $number")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy(): counter = $number")
    }

    @Composable
    fun SecondScreen(square: Int) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Квадрат числа: $square",
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                style = typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { finish() }) {
                Text(
                    text = "Вернуться к главному экрану",
                    fontSize = 28.sp,
                    textAlign = TextAlign.Center,
                    style = typography.bodyLarge
                )
            }
        }
    }
}
