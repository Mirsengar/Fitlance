package contagiouscode.mirsengar.fitlance.ui.exercises.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import contagiouscode.mirsengar.fitlance.ui.exercises.ExerciseEvent
import contagiouscode.mirsengar.fitlance.db.GymRepository
import contagiouscode.mirsengar.fitlance.db.entities.Exercise
import contagiouscode.mirsengar.fitlance.utils.Event
import contagiouscode.mirsengar.fitlance.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ExerciseDetailViewModel @Inject constructor(
          private val repository : GymRepository ,
          savedStateHandle : SavedStateHandle ,
) : ViewModel() {
     
     var currentExercise by mutableStateOf(Exercise(- 1))
          private set
     
     private val _uiEvent = Channel<UiEvent>()
     val uiEvent = _uiEvent.receiveAsFlow()
     
     init {
          val exerciseId = savedStateHandle.get<Long>("exerciseId") ?: - 1L
          if (exerciseId != - 1L) {
               viewModelScope.launch {
                    currentExercise = withContext(Dispatchers.IO) {
                         repository.getExercise(exerciseId)
                    }
               }
          }
     }
     
     fun onEvent(event : Event) {
          when (event) {
               is ExerciseEvent.ExerciseUpdated -> {
                    viewModelScope.launch {
                         repository.insertExercise(event.exercise)
                    }
               }
          }
     }
     
     private fun sendUiEvent(event : UiEvent) {
          viewModelScope.launch {
               _uiEvent.send(event)
          }
     }
     
}