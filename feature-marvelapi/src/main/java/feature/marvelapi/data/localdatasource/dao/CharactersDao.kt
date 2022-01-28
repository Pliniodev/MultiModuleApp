package feature.marvelapi.data.localdatasource.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import feature.marvelapi.data.localdatasource.entity.CharacterEntity
import feature.marvelapi.utils.Constants

@Dao
interface CharactersDao {

    @Insert
    suspend fun insertCharacter(character: CharacterEntity): Long

    @Query("SELECT * FROM ${Constants.CHARACTERS_ROOM_TABLE_NAME}")
    suspend fun getAll(): List<CharacterEntity>

}