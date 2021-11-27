package feature.ricky.data.mapper

import feature.ricky.data.response.BreedResponse
import feature.ricky.data.response.HeightResponse
import feature.ricky.data.response.ImageResponse
import feature.ricky.data.response.WeightResponse
import feature.ricky.domain.model.BreedDomain
import feature.ricky.domain.model.HeightDomain
import feature.ricky.domain.model.ImageDomain
import feature.ricky.domain.model.WeightDomain

internal object BreedsMapper {

    fun toBreedsDomain(source: List<BreedResponse>): List<BreedDomain> {
        return source.map { Breed ->
            with(Breed) {
                BreedDomain(
                    altNames = altNames,
                    id = id,
                    lifeSpan = lifeSpan,
                    referenceImageId = referenceImageId,
                    shortLegs = shortLegs,
                    suppressedTail = suppressedTail,
                    wikipediaUrl = wikipediaUrl,
                    experimental = experimental,
                    hairless = hairless,
                    hypoallergenic = hypoallergenic,
                    name = name,
                    natural = natural,
                    origin = origin,
                    rare = rare,
                    rex = rex,
                    temperament = temperament,
                    weight = toWeightDomain(weight),
                    height = toHeightDomain(height),
                    image = toImageDomain(image)
                )
            }
        }
    }

    private fun toImageDomain(imageResponse: ImageResponse?): ImageDomain =
        ImageDomain(
            id = imageResponse?.id,
            height = imageResponse?.height,
            width = imageResponse?.width,
            url = imageResponse?.url
        )

    private fun toHeightDomain(heightResponse: HeightResponse?): HeightDomain =
        HeightDomain(
            imperial = heightResponse?.imperial,
            metric = heightResponse?.metric
        )

    private fun toWeightDomain(weightResponse: WeightResponse?): WeightDomain =
        WeightDomain(
            imperial = weightResponse?.imperial,
            metric = weightResponse?.metric
        )
}
