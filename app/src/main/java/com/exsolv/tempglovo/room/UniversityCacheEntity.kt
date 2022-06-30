package com.exsolv.tempglovo.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "university_table")
data class UniversityCacheEntity(
    @ColumnInfo(name = "domain")
    var domain: String,
    @ColumnInfo(name = "web_page")
    var webPage: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "country")
    var country: String,
    @ColumnInfo(name = "alpha_two_code")
    var alphaTwoCode: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
