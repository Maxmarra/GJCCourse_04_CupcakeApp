package com.example.navigationsimple

import android.content.Intent
import android.content.Intent.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

enum class Screens {
    First,
    Second,
    Third
}

@Composable
fun NavigateAppBar(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(id = R.string.app_name)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.route ?: Screens.First.name


    Scaffold(
      topBar = {
          NavigateAppBar(
              canNavigateBack = false,
              navigateUp = { /*TODO*/ })
      }
  ) {
      NavHost(navController = navController, startDestination = Screens.First.name) {

          composable(route = Screens.First.name) {
              First(
                  onClick = { navController.navigate(Screens.Second.name) }
              )
          }
          composable(route = Screens.Second.name) {
              Second(
                  onClick = { navController.navigate(Screens.Third.name) },
                  onCancelClick = {
                      navController.popBackStack(
                          Screens.First.name,
                          inclusive = false
                      )
                  }
              )
          }
          composable(route = Screens.Third.name) {
              val context = LocalContext.current
              Third(
                  onClick = {
                      val intent = Intent(ACTION_SEND).apply {
                          type = "text/plain"
                          putExtra(EXTRA_SUBJECT, "What up")
                          putExtra(EXTRA_TEXT, "Blah, blah, blah")
                      }
                      context.startActivity(
                          createChooser(
                              intent, "brrrrrrrrrr"
                          )
                      )
                  },
                  onCancelClick = {
                      navController.popBackStack(
                          Screens.First.name,
                          inclusive = false
                      )
                  }

              )
          }
      }
  }
}















