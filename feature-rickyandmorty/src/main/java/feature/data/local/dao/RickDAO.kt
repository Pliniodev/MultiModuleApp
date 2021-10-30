package feature.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import feature.data.local.model.StepEntity

@Dao
interface RickDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateDB(stepEntity: StepEntity): Long

    @Query("SELECT * FROM step WHERE stepNumber = :stepNumber")
    fun getPhrase(stepNumber: Int): StepEntity
}