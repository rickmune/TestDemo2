package com.exsolv.tempglovo.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UniversityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUni(universityCacheEntity: UniversityCacheEntity)

    @Query("SELECT * FROM university_table")
    fun getUni(): Flow<List<UniversityCacheEntity>>
}