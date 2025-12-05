package com.example.softteksaudementalapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "respostas_carga_alerta")
data class RespostaCargaEAlerta(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val cargaTrabalho: String,        // Muito Leve, Leve, Média, Alta, Muito Alta
    val qualidadeVida: String,        // Não, Raramente, Às vezes, Frequentemente, Sempre
    val trabalhaForaHorario: String,  // Não, Raramente, Às vezes, Frequentemente, Sempre
    val insoniaOuCansaco: String,     // Nunca, Raramente, Às vezes, Frequentemente, Sempre
    val produtividade: String,        // Nunca, Raramente, Às vezes, Frequentemente, Sempre
    val dataHora: Long = System.currentTimeMillis()
)
