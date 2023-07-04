package com.dangeun.dangeun_android.ui.compose.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dangeun.dangeun_android.modules.chat.ui.ChatScreen
import com.dangeun.dangeun_android.modules.community.ui.CommunityScreen
import com.dangeun.dangeun_android.modules.home.ui.HomeScreen
import com.dangeun.dangeun_android.modules.location.ui.LocationScreen
import com.dangeun.dangeun_android.modules.my.ui.MyScreen
import com.dangeun.dangeun_android.ui.compose.BottomNavItem

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("community") {
            CommunityScreen()
        }
        composable("location") {
            LocationScreen()
        }
        composable("chat") {
           ChatScreen()
        }
        composable("my") {
            MyScreen()
        }
    }

}

/*
Material3 changes:
- BottomNavigation() is now NavigationBar(),
- background= is now containerColor=,
- elevation= is now tonalElevation=.
- BottomNavigationItem() is now NavigationBarItem()
- Handle the selectedContentColor and unselectedContentColor like this:
colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color .Green,
                    unselectedIconColor = Color.Gray
                )
-BadgeBox() is now BadgedBox()
-use BadgedBox( badge = { Badge { Text(item.badgeCount.toString()) } } )
 */


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(
    // bn에서 보여주어야 할 것들에 대한 정보
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit 
) {
    NavigationBar(
        modifier = modifier
    ) {

        val backStackEntry = navController.currentBackStackEntryAsState()

        // 내비게이션 바를 보여주기 위한 컴포넌트
        // 아이템 하나 당 하나의 NavigationBarItem 필요. 즉 여기서는 5개가 필요
        // 따라서, forEach를 이용하여 items들을 순회
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            NavigationBarItem(
                // 내비게이션 각 아이템의 route명(데이터클래스에 있음)과, 현재 navController에서 선택된 route명이 같은지 판단
                // 같으면 선택된 것으로 간주
                selected = selected,
                onClick = { onItemClick(item) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black ,
                    unselectedIconColor = Color.Gray
                ),
                icon = {
                    // 선택 여부에 따라 ...
                    Column(horizontalAlignment = CenterHorizontally) {
                        if (item.badgeCount > 0) {
                            BadgedBox(badge = {
                                Badge {
                                    Text(item.badgeCount.toString())
                                }
                            }) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.name
                                )
                            }
                        } else {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.name
                            )
                        }

                        Text(text = item.name, textAlign = TextAlign.Center, fontSize = 10.sp)
                    }
                })
        }
    }
}

