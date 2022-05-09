package contagiouscode.mirsengar.fitlance.ui.exercises

import contagiouscode.mirsengar.fitlance.db.entities.Exercise
import contagiouscode.mirsengar.fitlance.utils.Event

sealed class ExerciseEvent : Event {
     data class NewExerciseClicked(
               val title : String ,
               val muscleGroup : String ,
               val equipment : String ,
     ) : ExerciseEvent()
     
     data class OnMuscleGroupSelected(val muscleGroup : String) : ExerciseEvent()
     data class ExerciseSelected(val exercise : Exercise) : ExerciseEvent()
     data class ExerciseInfoClicked(val exercise : Exercise) : ExerciseEvent()
     data class ExerciseUpdated(val exercise : Exercise) : ExerciseEvent()
     data class FilterExerciseList(val searchString : String) : ExerciseEvent()
     object AddExercisesToSession : ExerciseEvent()
     data class MuscleGroupSelectionChange(val muscleGroup : String) : ExerciseEvent()
     data class EquipmentSelectionChange(val equipment : String) : ExerciseEvent()
     data class OnCreateExercise(val exercise : Exercise) : ExerciseEvent()
     object ToggleSearch : ExerciseEvent()
}
