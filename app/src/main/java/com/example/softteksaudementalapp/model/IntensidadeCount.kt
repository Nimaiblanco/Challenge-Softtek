package com.example.softteksaudementalapp.model

import androidx.room.ColumnInfo

data class IntensidadeCount(
    @ColumnInfo(name = "intensidade") val intensidade: String,
    @ColumnInfo(name = "total") val total: Int
)
