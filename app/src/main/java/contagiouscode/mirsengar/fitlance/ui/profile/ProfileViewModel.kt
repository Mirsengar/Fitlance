package contagiouscode.mirsengar.fitlance.ui.profile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import contagiouscode.mirsengar.fitlance.db.GymRepository
import contagiouscode.mirsengar.fitlance.utils.Event
import contagiouscode.mirsengar.fitlance.utils.Routes
import contagiouscode.mirsengar.fitlance.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
          private val repository : GymRepository ,
          savedStateHandle : SavedStateHandle ,
) : ViewModel() {
     private val _uiEvent = Channel<UiEvent>()
     val uiEvent = _uiEvent.receiveAsFlow()
     
     fun onEvent(event : Event) {
          when (event) {
               is ProfileEvent.NavigateToExercises -> {
                    sendUiEvent(UiEvent.Navigate(Routes.EXERCISE_SCREEN))
               }
          }
     }
     
     private fun sendUiEvent(event : UiEvent) {
          viewModelScope.launch {
               _uiEvent.send(event)
          }
     }
     
}