package feature.dogs.domain.mapper

import feature.dogs.domain.model.BreedDomain
import feature.dogs.domain.model.HeightDomain
import feature.dogs.domain.model.ImageDomain
import feature.dogs.domain.model.WeightDomain
import feature.dogs.presentation.model.BreedPresentation
import feature.dogs.presentation.model.HeightPresentation
import feature.dogs.presentation.model.ImagePresentation
import feature.dogs.presentation.model.WeightPresentation
import org.junit.Assert
import org.junit.Test

class BreedsDomainMapperTest {

    private val breedDomain = BreedDomain(
        altNames = "",
        id = 1,
        lifeSpan = "14 - 15",
        referenceImageId = null,
        shortLegs = 0,
        suppressedTail = 0,
        wikipediaUrl = "https://en.wikipedia.org/wiki/Abyssinian_(cat)",
        experimental = 0,
        hairless = 0,
        hypoallergenic = 0,
        name = "Abyssinian",
        natural = 1,
        origin = "Egypt",
        rare = 0,
        rex = 0,
        temperament = "Active, Energetic, Independent, Intelligent, Gentle",
        weight = WeightDomain(
            imperial = "9 - 11.5",
            metric = "23 - 29",
        ),
        height = HeightDomain(
            imperial = "25 - 27",
            metric = "64 - 69",
        ),
        image = ImageDomain(
            height = 1199,
            id = "BJa4kxc4X",
            url = "https://cdn2.thedogapi.com/images/BJa4kxc4X.jpg",
            width = "1600",
        )
    )

    private val breedPresentation = BreedPresentation(
        altNames = "",
        id = 1,
        lifeSpan = "14 - 15",
        referenceImageId = null,
        shortLegs = 0,
        suppressedTail = 0,
        wikipediaUrl = "https://en.wikipedia.org/wiki/Abyssinian_(cat)",
        experimental = 0,
        hairless = 0,
        hypoallergenic = 0,
        name = "Abyssinian",
        natural = 1,
        origin = "Egypt",
        rare = 0,
        rex = 0,
        temperament = "Active, Energetic, Independent, Intelligent, Gentle",
        weight = WeightPresentation(
            imperial = "9 - 11.5",
            metric = "23 - 29",
        ),
        height = HeightPresentation(
            imperial = "25 - 27",
            metric = "64 - 69",
        ),
        image = ImagePresentation(
            height = 1199,
            id = "BJa4kxc4X",
            url = "https://cdn2.thedogapi.com/images/BJa4kxc4X.jpg",
            width = "1600",
        )
    )

    /** FOR STUDIES
     * expected -> the expected object, when yoy test the function
     * result -> result of function that you want to test
     * assertEqualt -> verify if the expected object is equals to result object
     */
    @Test
    fun `should return BreedPresentations when toBreedsPresentation`() {
        val expected = listOf(breedPresentation)
        val result = BreedsDomainMapper.toBreedsPresentation(listOf(breedDomain))
        Assert.assertEquals(expected, result)
    }
}
