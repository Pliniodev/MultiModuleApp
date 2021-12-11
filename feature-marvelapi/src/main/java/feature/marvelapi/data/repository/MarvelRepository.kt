package feature.marvelapi.data.repository

import feature.marvelapi.data.model.Someeeee

interface MarvelRepository {

    suspend fun test(): Someeeee
}