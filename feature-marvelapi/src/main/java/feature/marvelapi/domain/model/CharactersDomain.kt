package feature.marvelapi.domain.model

data class MainDomain(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val eTag: String,
    val data: SubResponseDomain

)

data class SubResponseDomain(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<CharactersDomain>
)

data class CharactersDomain(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: ImagesDomain
)

data class ImagesDomain(
    val path: String,
    val extension: String
)
