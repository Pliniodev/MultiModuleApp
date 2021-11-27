package feature.presentation.model

data class InfoPresentation(
    val count: Int.Companion,
    val next: String.Companion,
    val pages: Int?,
    val prev: Int?
)
