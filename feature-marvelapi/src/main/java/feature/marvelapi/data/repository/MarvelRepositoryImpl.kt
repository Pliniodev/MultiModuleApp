package feature.marvelapi.data.repository

import feature.marvelapi.data.api.MarvelApi
import feature.marvelapi.data.model.Someeeee

internal class MarvelRepositoryImpl(private val service: MarvelApi) : MarvelRepository{

    override suspend fun test(): Someeeee {
        return service.test()
    }
}