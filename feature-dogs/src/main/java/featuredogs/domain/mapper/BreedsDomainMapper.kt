package featuredogs.domain.mapper

import featuredogs.domain.model.BreedDomain
import featuredogs.domain.model.HeightDomain
import featuredogs.domain.model.ImageDomain
import featuredogs.domain.model.WeightDomain
import featuredogs.presentation.model.BreedPresentation
import featuredogs.presentation.model.HeightPresentation
import featuredogs.presentation.model.ImagePresentation
import featuredogs.presentation.model.WeightPresentation

internal object BreedsDomainMapper {

    fun toBreedsPresentation(source: List<BreedDomain>): List<BreedPresentation> {
        return source.map { Breed ->
            with(Breed) {
                BreedPresentation(
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
                    weight = toWeightPresentation(weight),
                    height = toHeightPresentation(height),
                    image = toImagePresentation(image)
                )
            }
        }
    }

    private fun toImagePresentation(imageDomain: ImageDomain?): ImagePresentation =
        ImagePresentation(
            id = imageDomain?.id,
            height = imageDomain?.height,
            width = imageDomain?.width,
            url = imageDomain?.url
        )

    private fun toHeightPresentation(heightDomain: HeightDomain?): HeightPresentation =
        HeightPresentation(
            imperial = heightDomain?.imperial,
            metric = heightDomain?.metric
        )

    private fun toWeightPresentation(weightDomain: WeightDomain?): WeightPresentation =
        WeightPresentation(
            imperial = weightDomain?.imperial,
            metric = weightDomain?.metric
        )
}
