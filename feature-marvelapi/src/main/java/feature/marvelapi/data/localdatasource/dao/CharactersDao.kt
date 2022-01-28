package feature.marvelapi.data.localdatasource.dao

import androidx.room.Dao
import androidx.room.Insert
import feature.marvelapi.data.localdatasource.entity.CharacterEntity

@Dao
interface CharactersDao {

    @Insert()
    suspend fun insertCharacter(character: CharacterEntity): Long



}