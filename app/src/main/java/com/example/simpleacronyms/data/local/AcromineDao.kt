package com.example.simpleacronyms.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.simpleacronyms.data.local.Entity.AcromineEntity

@Dao
interface AcromineDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAcronyms(acronym: AcromineEntity)

    @Query("DELETE FROM acromineentity WHERE shortForm IN(:shortForm)")
    suspend fun deleteAcronyms(shortForm: String)

    @Query("SELECT listOfLongForms FROM acromineentity WHERE shortForm = :shortForm ")
    suspend fun getAcronyms(shortForm: String): List<String>
}