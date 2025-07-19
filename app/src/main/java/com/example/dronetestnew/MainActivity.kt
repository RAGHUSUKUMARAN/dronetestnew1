package com.example.dronetestnew

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.dronetestnew.navigation.AppNavigation
import com.example.dronetestnew.ui.theme.DronetestnewTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DronetestnewTheme {
                AppNavigation()
            }
        }
    }
}
