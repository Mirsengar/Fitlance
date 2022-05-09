package contagiouscode.mirsengar.fitlance.ui.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import contagiouscode.mirsengar.fitlance.utils.UiEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
          onNavigate : (UiEvent.Navigate) -> Unit ,
          viewModel : ProfileViewModel = hiltViewModel() ,
) {
     LaunchedEffect(key1 = true) {
          viewModel.uiEvent.collect { event ->
               when (event) {
                    is UiEvent.Navigate -> onNavigate(event)
                    else                -> Unit // do nothing
               }
          }
     }
     Scaffold() {
          Column(Modifier.fillMaxSize() , verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally) {
               Text("This is your profile")
               FilledTonalButton(modifier = Modifier.padding(8.dp) , onClick = {
                    viewModel.onEvent(ProfileEvent.NavigateToExercises)
               }) {
                    Text("Exercises")
               }
               FilledTonalButton(onClick = {
               }) {
               
               }
          }
     }
}