package com.keepr.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.keepr.app.ui.navigation.KeeprNavHost
import com.keepr.app.ui.theme.KeeprTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KeeprTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    KeeprNavHost(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
