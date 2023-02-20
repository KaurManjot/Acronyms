package com.example.simpleacronyms.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.simpleacronyms.data.local.Entity.AcromineEntity

@Database(
    entities = [AcromineEntity::class],
    version = 1 //Everytime you update the Database you need to increase the version
)
@TypeConverters(Convertors::class)
abstract class AcromineDatabase : RoomDatabase() {

    abstract val dao: AcromineDao
}