package feature.marvelapi.data.remotedatasource

import feature.marvelapi.data.api.MarvelApi
import feature.marvelapi.data.mapper.TestMapper
import feature.marvelapi.domain.model.MainDomain
import feature.marvelapi.domain.model.SomeDomain

class RemoteDataSourceImpl(private val api: MarvelApi): RemoteDataSource {

    override suspend fun getSome(): MainDomain {
        return TestMapper.remoteToDomain(api.test())
    }
}