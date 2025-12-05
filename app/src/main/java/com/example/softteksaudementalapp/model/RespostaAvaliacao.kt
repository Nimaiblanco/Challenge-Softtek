package com.example.softteksaudementalapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "RespostaAvaliacao")
data class RespostaAvaliacao(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val emocao: String,
    val intensidade: String,
    val dataHora: Long = System.currentTimeMillis()
)
