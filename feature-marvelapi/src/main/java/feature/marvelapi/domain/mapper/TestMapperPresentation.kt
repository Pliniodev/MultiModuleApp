package feature.marvelapi.domain.mapper

import feature.marvelapi.domain.model.SomeDomain
import feature.marvelapi.presentation.model.SomePresentation

object TestMapperPresentation {

    fun domainToPresentation(source: SomeDomain): SomePresentation =
        SomePresentation(name = source.name)
}