package com.example.softteksaudementalapp.model

import androidx.room.ColumnInfo

data class EmocaoCount(
    @ColumnInfo(name = "emocao") val emocao: String,
    @ColumnInfo(name = "total") val total: Int
)
