package featuredogs.data.mapper

import featuredogs.data.response.BreedResponse
import featuredogs.data.response.HeightResponse
import featuredogs.data.response.ImageResponse
import featuredogs.data.response.WeightResponse
import featuredogs.domain.model.BreedDomain
import featuredogs.domain.model.HeightDomain
import featuredogs.domain.model.ImageDomain
import featuredogs.domain.model.WeightDomain

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
