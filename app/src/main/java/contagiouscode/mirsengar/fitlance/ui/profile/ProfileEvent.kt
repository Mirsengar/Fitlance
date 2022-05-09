package contagiouscode.mirsengar.fitlance.ui.profile

import contagiouscode.mirsengar.fitlance.utils.Event

sealed class ProfileEvent : Event {
    object NavigateToExercises: ProfileEvent()
}