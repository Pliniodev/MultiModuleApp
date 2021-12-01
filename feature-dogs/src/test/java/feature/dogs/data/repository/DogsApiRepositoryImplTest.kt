package feature.dogs.data.repository

import feature.dogs.data.remoteDataSource.RemoteDataSource
import feature.dogs.domain.model.BreedDomain
import feature.dogs.domain.model.HeightDomain
import feature.dogs.domain.model.ImageDomain
import feature.dogs.domain.model.WeightDomain
import feature.dogs.domain.repository.DogsApiRepository
import feature.dogs.presentation.model.BreedPresentation
import feature.dogs.presentation.model.HeightPresentation
import feature.dogs.presentation.model.ImagePresentation
import feature.dogs.presentation.model.WeightPresentation
import feature.dogs.utils.CoroutinesTestRule
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class DogsApiRepositoryImplTest {

    @get:Rule
    val coroutineTestRule = CoroutinesTestRule()

    private lateinit var repository: DogsApiRepository
    private val remoteDataSource = mockk<RemoteDataSource>(relaxed = true)

    @Before
    fun setUp() {
        repository = DogsApiRepositoryImpl(remoteDataSource = remoteDataSource)
    }

    /** FOR STUDIES
     * coEvery and coVerify is used on coroutines requests
     * coEvery -> defines that, everytime { this.function } is called, returns thatObject
     * result  -> is the function that you desired to test
     * coVerify -> verify if { this function(anyTypeOfParameter, anyTypeOfParameter) } is called
     * assertThat -> assert(theReturnOfResult).isEqualTo(thisObject)
     */
    @Test
    fun `should return breedPresentation list when getBreeds`() = runBlockingTest {
        coEvery { remoteDataSource.getBreedsByPage(any()) } returns listOf(breedDomain)

        val result = repository.getBreeds(PAGE_ONE)
        coVerify { remoteDataSource.getBreedsByPage(any()) }
        Assertions.assertThat(result).isEqualTo(listOf(breedPresentation))
    }

    private companion object {
        const val PAGE_ONE = 1
    }

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
}
