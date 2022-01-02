package feature.marvelapi.data.mapper

import feature.marvelapi.data.model.ImagesResponse
import feature.marvelapi.data.model.MainSeriesResponse
import feature.marvelapi.data.model.SeriesResponse
import feature.marvelapi.data.model.SubSeriesResponse
import feature.marvelapi.domain.model.ImagesDomain
import feature.marvelapi.domain.model.MainSeriesDomain
import feature.marvelapi.domain.model.SeriesDomain
import feature.marvelapi.domain.model.SubSeriesDomain

internal object MapperSeriesResponse {

    fun toDomain(source: MainSeriesResponse): MainSeriesDomain =

        with(source) {
            MainSeriesDomain(
                code = code,
                status = status,
                copyright = copyright,
                attributionText = attributionText,
                attributionHTML = attributionHTML,
                eTag = eTag,
                data = subResponse(data)
            )
        }

    private fun subResponse(source: SubSeriesResponse): SubSeriesDomain {

        with(source) {
            return SubSeriesDomain(
                offset = offset,
                limit = limit,
                total = total,
                count = count,
                results = responseToDomain(results)
            )
        }
    }

    private fun responseToDomain(source: List<SeriesResponse>): List<SeriesDomain> =
        source.map { series ->
            with(series) {
                SeriesDomain(
                    id = id,
                    title = title,
                    description = description,
                    rating = rating,
                    thumbnail = thumbNailToDomain(thumbnail)
                )
            }
        }

    private fun thumbNailToDomain(source: ImagesResponse): ImagesDomain =
        ImagesDomain(
            path = source.path,
            extension = source.extension
        )

}