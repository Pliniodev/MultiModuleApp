package feature.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import feature.data.local.dao.RickDAO
import feature.data.local.model.StepEntity

@Database(entities = [StepEntity::class], version = 1)
abstract class RegisterDatabase : RoomDatabase() {
    abstract val stepDAO: RickDAO
}

fun provideDB(application: Application): RegisterDatabase {
    return Room.databaseBuilder(application, RegisterDatabase::class.java, "registerDB")
        .allowMainThreadQueries()
        .build()
}

fun provideStepDAO(database: RegisterDatabase): RickDAO {
    return database.stepDAO
}