package feature.marvelapi.presentation.model

internal data class MainPresentation(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val eTag: String,
    val data: SubResponsePresentation

)

internal data class SubResponsePresentation(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<CharactersPresentation>
)

internal data class CharactersPresentation(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: ImagesPresentation
)

internal data class ImagesPresentation(
    val path: String,
    val extension: String
)
