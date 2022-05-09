package contagiouscode.mirsengar.fitlance.ui.home


import contagiouscode.mirsengar.fitlance.db.entities.Session
import contagiouscode.mirsengar.fitlance.utils.Event


sealed class HomeEvent : Event {
     object OnUndoDeleteClick : HomeEvent()
     data class OnSessionClick(val session : Session) : HomeEvent()
     object OnAddSessionClick : HomeEvent()
     data class SetSelectedSession(val session : Session) : HomeEvent()
     data class OnDeleteSession(val session : Session) : HomeEvent()
     object RestoreRemovedSession : HomeEvent()
}