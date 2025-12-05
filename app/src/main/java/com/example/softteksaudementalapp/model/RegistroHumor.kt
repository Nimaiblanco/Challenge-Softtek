package com.example.softteksaudementalapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RegistroHumor(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val emoji: String,
    val sentimento: String,
    val dataHora: Long = System.currentTimeMillis()
)
