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
    val results: List<SomeDomain>
)

data class SomeDomain(
    val name: String
)
