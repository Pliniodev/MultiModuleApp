package feature.marvelapi.data.localdatasource.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import feature.marvelapi.utils.Constants

@Entity(tableName = Constants.CHARACTERS_ROOM_TABLE_NAME)
internal data class CharacterEntity(

    @PrimaryKey
    val id: Long = 0,

    @ColumnInfo(name = "characterName")
    val name: String = "",

    @ColumnInfo(name = "characterImage")
    val image : String = ""
)