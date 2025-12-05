package com.example.softteksaudementalapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "respostas_clima_detalhada")
data class RespostaClimaDetalhada(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val resposta1: Int,
    val resposta2: Int,
    val resposta3: Int,
    val resposta4: Int,
    val resposta5: Int,
    val resposta6: Int,
    val resposta7: Int,
    val resposta8: Int,
    val resposta9: Int,
    val resposta10: Int,
    val resposta11: Int,
    val resposta12: Int,
    val resposta13: Int,
    val resposta14: Int,
    val resposta15: Int,
    val resposta16: Int,
    val dataHora: Long = System.currentTimeMillis()
)
