package uz.adkhamjon.taskmanagement.utils

data class UIObjectState<T>(
    val isLoading: Boolean = false,
    val data: T? = null,
    val error: String = ""
)