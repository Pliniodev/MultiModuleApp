package feature.data.local.localdatasource

import feature.data.local.dao.RickDAO

class LocalDataSourceImpl(
    private val db: RickDAO
) : LocalDataSource {
//    override fun updateDB(stepEntity: StepEntity): Long {
//        return db.updateDB(stepEntity)
//    }
//
//    override fun getPhraseDB(stepNumber: Int): StepDomain {
//        val response = db.getPhrase(stepNumber)
//        return StepMapper.stepToDomain(response)
//    }
}
