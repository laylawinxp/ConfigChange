package com.example.configchange

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.configchange.ui.theme.ConfigChangeTheme

class MainActivity : ComponentActivity() {
    private val TAG: String = "MainActivity"
    private var counter by mutableIntStateOf(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("counter", 0)
        }

        Log.d(TAG, "onCreate(): counter = $counter")

        setContent {
            ConfigChangeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(counter) {
                        val intent = Intent(this, SecondActivity::class.java).apply {
                            putExtra("number", counter)
                        }
                        startActivity(intent)
                    }
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter", counter)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart(): counter = $counter")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume(): counter = $counter")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause(): counter = $counter")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop(): counter = $counter")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy(): counter = $counter")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        counter++
        Log.d(TAG, "onConfigurationChanged(): counter = $counter")
    }

    @Composable
    fun MainScreen(counter: Int, onNavigate: () -> Unit) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Число: $counter",
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                style = typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = onNavigate) {
                Text(
                    text = "Перейти к 2 экрану",
                    fontSize = 28.sp,
                    textAlign = TextAlign.Center,
                    style = typography.bodyLarge
                )
            }
        }
    }
}
