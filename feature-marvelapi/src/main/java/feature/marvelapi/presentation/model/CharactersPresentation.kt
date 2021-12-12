package feature.marvelapi.presentation.model

data class MainPresentation(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val eTag: String,
    val data: SubResponsePresentation

)

data class SubResponsePresentation(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<CharactersPresentation>
)

data class CharactersPresentation(
    val name: String
)
