package featuredogs.presentation.model

import java.io.Serializable

internal data class BreedPresentation(
    val altNames: String? = null,
    val id: Int? = null,
    val lifeSpan: String? = null,
    val referenceImageId: String? = null,
    val shortLegs: Int? = null,
    val suppressedTail: Int? = null,
    val wikipediaUrl: String? = null,
    val experimental: Int? = null,
    val hairless: Int? = null,
    val hypoallergenic: Int? = null,
    val name: String? = null,
    val natural: Int? = null,
    val origin: String? = null,
    val rare: Int? = null,
    val rex: Int? = null,
    val temperament: String? = null,
    val weight: WeightPresentation? = null,
    val height: HeightPresentation? = null,
    val image: ImagePresentation? = null
) : Serializable

internal data class WeightPresentation(
    val imperial: String? = null,
    val metric: String? = null
) : Serializable

internal data class HeightPresentation(
    val imperial: String? = null,
    val metric: String? = null
) : Serializable

internal data class ImagePresentation(
    val height: Int? = null,
    val id: String? = null,
    val url: String? = null,
    val width: String? = null
) : Serializable
