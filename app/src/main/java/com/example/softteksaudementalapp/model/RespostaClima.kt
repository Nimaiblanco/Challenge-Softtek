package com.example.softteksaudementalapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "respostas_clima")
data class RespostaClima(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val relacionamento: Int,     // valores de 1 a 5
    val comunicacao: Int,        // valores de 1 a 5
    val lideranca: Int,          // valores de 1 a 5
    val dataHora: Long = System.currentTimeMillis()
)
