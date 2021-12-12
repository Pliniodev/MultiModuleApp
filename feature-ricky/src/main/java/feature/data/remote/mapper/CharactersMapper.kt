package feature.data.remote.mapper

import feature.data.remote.model.CharactersResponse
import feature.domain.model.CharactersInfoDomain

object CharactersMapper {

        fun toCharactersInfoDomain(source: CharactersResponse): CharactersInfoDomain =
            CharactersInfoDomain(
                count = source.info?.count,
                next = source.info?.next,
                pages = source.info?.pages,
                prev = source.info?.prev
            )
    }
