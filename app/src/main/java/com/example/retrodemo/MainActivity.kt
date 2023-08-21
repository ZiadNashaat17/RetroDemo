package com.example.retrodemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.retrodemo.ui.theme.RetroDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val apiViewModel by viewModels<ApiViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetroDemoTheme {
                apiViewModel.getTvs("173938f79f2731c12553c6b567609a4f", 35)
            }
        }
    }
}
