package contagiouscode.mirsengar.fitlance.ui.session

import contagiouscode.mirsengar.fitlance.db.entities.GymSet
import contagiouscode.mirsengar.fitlance.db.entities.SessionExerciseWithExercise
import contagiouscode.mirsengar.fitlance.utils.Event

sealed class SessionEvent : Event {
     data class RemoveSelectedSet(val set : GymSet) : SessionEvent()
     data class MoodChanged(val set : GymSet , val newMood : Int) : SessionEvent()
     data class SetTypeChanged(val set : GymSet) : SessionEvent()
     data class WeightChanged(val set : GymSet , val newWeight : Float) : SessionEvent()
     data class RepsChanged(val set : GymSet , val newReps : Int) : SessionEvent()
     object OnAddSessionExerciseClicked : SessionEvent()
     data class SetSelectedSessionExercise(val sessionExercise : SessionExerciseWithExercise) : SessionEvent()
     data class OnAddSet(val sessionExercise : SessionExerciseWithExercise) : SessionEvent()
     object RestoreRemovedSet : SessionEvent()
     object RestoreRemovedSessionExercise : SessionEvent()
     data class EndTimeChanged(val newTime : Long) : SessionEvent()
     data class OnSessionExerciseInfoClicked(val exerciseId : Long) : SessionEvent()
     data class OnDeleteSessionExercise(val sessionExercise : SessionExerciseWithExercise) : SessionEvent()
}
