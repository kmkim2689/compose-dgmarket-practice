package com.dangeun.dangeun_android.modules.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.dangeun.dangeun_android.ui.compose.BottomNavItem
import com.dangeun.dangeun_android.ui.compose.components.BottomNavigationBar
import com.dangeun.dangeun_android.ui.compose.components.Navigation
import com.dangeun.dangeun_android.ui.theme.DangeunandroidTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            DangeunandroidTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem(
                                    "홈",
                                    "home",
                                    Icons.Default.Home
                                ),
                                BottomNavItem(
                                    "동네생활",
                                    "community",
                                    Icons.Default.Share
                                ),
                                BottomNavItem(
                                    "내 근처",
                                    "location",
                                    Icons.Default.LocationOn
                                ),
                                BottomNavItem(
                                    "채팅",
                                    "chat",
                                    Icons.Default.Email,
                                    1
                                ),
                                BottomNavItem(
                                    "나의 당근",
                                    "my",
                                    Icons.Default.Person
                                )
                            ),
                            navController = navController,
                            onItemClick = {
                                // 아이템을 누르면 navigate해야함
                                // 선택한 라우트로 이동해야함.
                                navController.navigate(it.route)
                            }
                        )
                    }
                ) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}
