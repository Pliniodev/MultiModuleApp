package feature.marvelapi.domain.mapper

import feature.marvelapi.domain.model.MainDomain
import feature.marvelapi.presentation.model.MainPresentation
import feature.marvelapi.presentation.model.CharactersPresentation
import feature.marvelapi.presentation.model.SubResponsePresentation

object CharactersDomainToPresentation {

    fun domainToPresentation(source: MainDomain): MainPresentation =
        MainPresentation(
            code = source.code,
            status = source.status,
            copyright = source.copyright,
            attributionText = source.attributionText,
            attributionHTML = source.attributionHTML,
            eTag = source.eTag,
            data = SubResponsePresentation(
                offset = source.data.offset,
                limit = source.data.limit,
                total = source.data.total,
                count = source.data.count,
                results = source.data.results.map { response ->
                    CharactersPresentation(response.name ?: "algo")
                }
            )
        )
}