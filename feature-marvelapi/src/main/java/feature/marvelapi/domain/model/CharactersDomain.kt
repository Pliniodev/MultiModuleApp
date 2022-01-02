package feature.marvelapi.domain.model

internal data class MainCharactersDomain(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val eTag: String,
    val data: SubCharactersDomain

)

internal data class SubCharactersDomain(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<CharactersDomain>
)

internal data class CharactersDomain(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: ImagesDomain
)

internal data class ImagesDomain(
    val path: String,
    val extension: String
)
