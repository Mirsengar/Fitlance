package contagiouscode.mirsengar.fitlance.utils

sealed class UiEvent {
     object PopBackStack : UiEvent()
     object OpenDialog : UiEvent()
     data class Navigate(val route : String) : UiEvent()
     data class ShowSnackbar(
               val message : String ,
               val actionLabel : String? = null ,
               val action : Event? = null ,
     ) : UiEvent()
}