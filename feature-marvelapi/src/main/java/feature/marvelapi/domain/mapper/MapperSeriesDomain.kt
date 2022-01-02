package feature.marvelapi.domain.mapper

import feature.marvelapi.domain.model.ImagesDomain
import feature.marvelapi.domain.model.MainSeriesDomain
import feature.marvelapi.domain.model.SeriesDomain
import feature.marvelapi.domain.model.SubSeriesDomain
import feature.marvelapi.presentation.model.ImagesPresentation
import feature.marvelapi.presentation.model.MainSeriesPresentation
import feature.marvelapi.presentation.model.SeriesPresentation
import feature.marvelapi.presentation.model.SubSeriesPresentation

internal object MapperSeriesDomain {

    fun toPresentation(source: MainSeriesDomain): MainSeriesPresentation =
        with(source) {
            MainSeriesPresentation(
                code = code,
                status = status,
                copyright = copyright,
                attributionText = attributionText,
                attributionHTML = attributionHTML,
                eTag = eTag,
                data = subDomainToPresentation(data)
            )
        }

    private fun subDomainToPresentation(source: SubSeriesDomain): SubSeriesPresentation =
        with(source) {
            SubSeriesPresentation(
                offset = offset,
                limit = limit,
                total = total,
                count = count,
                results =seriesDomainToPresentation(results)
            )
        }

    private fun seriesDomainToPresentation(source: List<SeriesDomain>): List<SeriesPresentation> =
        source.map { series ->
            with(series) {
                SeriesPresentation(
                    id = id,
                    title = title,
                    description = description,
                    rating = rating,
                    thumbnail = thumbNailToPresentation(thumbnail)
                )
            }
        }

    private fun thumbNailToPresentation(source: ImagesDomain): ImagesPresentation =
        ImagesPresentation(
            path = source.path,
            extension = source.extension
        )
}