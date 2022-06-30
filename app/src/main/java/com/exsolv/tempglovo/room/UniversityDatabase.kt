package com.exsolv.tempglovo.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UniversityCacheEntity::class], version = 1, exportSchema = false)
abstract class UniversityDatabase: RoomDatabase() {

    abstract fun universityDao(): UniversityDao

    companion object {
        val DATABASE_NAME = "university_db"
    }
}