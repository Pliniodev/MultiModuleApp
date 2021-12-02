package feature.dogs.data.remoteDataSource

import feature.dogs.data.api.DogsApiService
import feature.dogs.data.response.BreedResponse
import feature.dogs.data.response.HeightResponse
import feature.dogs.data.response.ImageResponse
import feature.dogs.data.response.WeightResponse
import feature.dogs.domain.model.BreedDomain
import feature.dogs.domain.model.HeightDomain
import feature.dogs.domain.model.ImageDomain
import feature.dogs.domain.model.WeightDomain
import feature.dogs.test_utils.CoroutineTestRule
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
class RemoteDataSourceImplTest {

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    private lateinit var remoteDataSource: RemoteDataSource
    private val api = mockk<DogsApiService>(relaxed = true)

    @Before
    fun setUp() {
        remoteDataSource = RemoteDataSourceImpl(api = api)
    }

    /** FOR STUDIES
     * coEvery and coVerify is used on coroutines requests
     * coEvery -> defines that, everytime { this.function } is called, returns thatObject
     * result  -> is the function that you desired to test
     * coVerify -> verify if { this function(anyTypeOfParameter, anyTypeOfParameter) } is called
     * assertThat -> assertThat(theReturnOfResult).isEqualTo(thisObject)
     */
    @Test
    fun `should return Breed list when getBreeds`() = runBlockingTest {
        coEvery { api.getBreedsByPage(any(), any()) } returns listOf(breedResponse)

        val result = remoteDataSource.getBreedsByPage(PAGE_ONE)
        coVerify { api.getBreedsByPage(any(), any()) }
        Assertions.assertThat(result).isEqualTo(listOf(breedDomain))
    }

    private companion object {
        const val PAGE_ONE = 1
    }

    private val breedResponse = BreedResponse(
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
        weight = WeightResponse(
            imperial = "9 - 11.5",
            metric = "23 - 29",
        ),
        height = HeightResponse(
            imperial = "25 - 27",
            metric = "64 - 69",
        ),
        image = ImageResponse(
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
