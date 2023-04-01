package hr.kristiankliskovic.bt_sender_basic_control.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import hr.kristiankliskovic.bt_sender_basic_control.navigation.HOME_ROUTE
import hr.kristiankliskovic.bt_sender_basic_control.navigation.SETTINGS_ROUTE
import hr.kristiankliskovic.bt_sender_basic_control.ui.home.HomeRoute
import hr.kristiankliskovic.bt_sender_basic_control.ui.home.HomeScreenViewModel
import hr.kristiankliskovic.bt_sender_basic_control.ui.settings.SettingsRoute
import hr.kristiankliskovic.bt_sender_basic_control.ui.settings.SettingsViewModel
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navController,
            startDestination = HOME_ROUTE,
        ) {
            composable(HOME_ROUTE) {
                HomeRoute(
                    viewModel = getViewModel<HomeScreenViewModel>(),
                    navigateToSettings = {
                        navController.navigate(SETTINGS_ROUTE)
                    }
                )
            }
            composable(SETTINGS_ROUTE) {
                SettingsRoute(
                    viewModel = getViewModel<SettingsViewModel>(),
                    navigateBack = {
                        navController.navigate(HOME_ROUTE){
                            popUpTo(HOME_ROUTE)
                        }
                    }
                )
            }
        }
    }
}
