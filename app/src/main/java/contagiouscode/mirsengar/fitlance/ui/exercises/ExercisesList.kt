package contagiouscode.mirsengar.fitlance.ui.exercises

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import contagiouscode.mirsengar.fitlance.db.entities.Exercise
import contagiouscode.mirsengar.fitlance.utils.Event


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExercisesList(
          viewModel : ExerciseViewModel ,
          exercises : List<Exercise> ,
          selectedExercises : Set<Exercise> = emptySet() ,
          onEvent : (Event) -> Unit ,
          inPicker : Boolean ,
) {
     
     LazyColumn(
               modifier = Modifier
                         .fillMaxSize()
     ) {
          item {
               Spacer(modifier = Modifier.height(4.dp))
          }
          items(items = exercises) { exercise ->
               AnimatedVisibility(visible = true) {
                    val selected = selectedExercises.contains(exercise)
                    ExerciseCard(exercise , selected , inPicker , viewModel::onEvent)
               }
          }
     }
}