package feature.marvelapi.data.mapper

import feature.marvelapi.data.model.MainResponse
import feature.marvelapi.data.model.Someeeee
import feature.marvelapi.domain.model.MainDomain
import feature.marvelapi.domain.model.SomeDomain
import feature.marvelapi.domain.model.SubResponseDomain

object TestMapper {

    fun remoteToDomain(source: MainResponse): MainDomain =
        MainDomain(
            code = source.code,
            status = source.status,
            copyright = source.copyright,
            attributionText = source.attributionText,
            attributionHTML = source.attributionHTML,
            eTag = source.eTag,
            data = SubResponseDomain(
                offset = source.data.offset,
                limit = source.data.limit,
                total = source.data.total,
                count = source.data.count,
                results = source.data.results.map { response ->
                    SomeDomain(response.name ?: "algo")
                }
            )
        )
}