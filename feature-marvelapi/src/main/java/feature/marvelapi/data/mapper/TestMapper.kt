package feature.marvelapi.data.mapper

import feature.marvelapi.data.model.Someeeee
import feature.marvelapi.domain.model.SomeDomain

object TestMapper {

    fun remoteToDomain(source: Someeeee): SomeDomain =
        SomeDomain(
            name = source.name
        )
}