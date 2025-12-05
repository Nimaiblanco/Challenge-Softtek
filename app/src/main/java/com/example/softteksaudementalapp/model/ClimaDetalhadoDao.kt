package com.example.softteksaudementalapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.softteksaudementalapp.model.RespostaClimaDetalhada
import kotlinx.coroutines.flow.Flow

@Dao
interface ClimaDetalhadoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(resposta: RespostaClimaDetalhada)

    @Query("SELECT * FROM respostas_clima_detalhada ORDER BY dataHora DESC")
    fun listar(): Flow<List<RespostaClimaDetalhada>>

}
