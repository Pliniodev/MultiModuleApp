package feature.data.response

import com.google.gson.annotations.SerializedName

internal data class BreedsResponse(
    val breeds: List<Breed>
)

internal data class Breed(
    @SerializedName("alt_names") val altNames: String? = null,
    @SerializedName("id") val id: Int? = null,
    @SerializedName("life_span") val lifeSpan: String? = null,
    @SerializedName("reference_image_id") val referenceImageId: String? = null,
    @SerializedName("short_legs") val shortLegs: Int? = null,
    @SerializedName("suppressed_tail") val suppressedTail: Int? = null,
    @SerializedName("wikipedia_url") val wikipediaUrl: String? = null,
    val experimental: Int? = null,
    val hairless: Int? = null,
    val hypoallergenic: Int? = null,
    val name: String? = null,
    val natural: Int? = null,
    val origin: String? = null,
    val rare: Int? = null,
    val rex: Int? = null,
    val temperament: String? = null,
    val weight: WeightResponse? = null,
    val height: HeightResponse? = null,
    val image: ImageResponse? = null
)

internal data class WeightResponse(
    val imperial: String? = null,
    val metric: String? = null
)

internal data class HeightResponse(
    val imperial: String? = null,
    val metric: String? = null
)

internal data class ImageResponse(
    val height: Int? = null,
    val id: String? = null,
    val url: String? = null,
    val width: String? = null
)

