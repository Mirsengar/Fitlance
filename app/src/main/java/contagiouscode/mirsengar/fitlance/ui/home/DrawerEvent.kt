package contagiouscode.mirsengar.fitlance.ui.home

import contagiouscode.mirsengar.fitlance.utils.Event

sealed class DrawerEvent : Event {
    object OnExercisesClicked: DrawerEvent()
    object OnHomeClicked: DrawerEvent()
    object OnSettingsClicked: DrawerEvent()
}
