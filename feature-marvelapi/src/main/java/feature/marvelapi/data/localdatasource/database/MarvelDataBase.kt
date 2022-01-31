package feature.marvelapi.data.localdatasource.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import feature.marvelapi.data.localdatasource.dao.CharactersDao
import feature.marvelapi.data.localdatasource.entity.CharacterEntity
import feature.marvelapi.utils.Constants

@Database(entities = [CharacterEntity::class], version = 2)
internal abstract class MarvelDataBase : RoomDatabase() {

    abstract val charactersDao: CharactersDao

}

internal fun provideDao(db: MarvelDataBase): CharactersDao {
    return db.charactersDao
}