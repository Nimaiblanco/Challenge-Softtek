package com.example.softteksaudementalapp.model

fun classificarRiscoGlobal(respostas: List<RespostaAvaliacao>): ResultadoRisco {
    if (respostas.isEmpty()) return ResultadoRisco("Sem dados", 0, "Neutro")

    val total = respostas.size
    val frequencia = respostas.groupingBy { it.emocao }.eachCount()
    val maisFrequente = frequencia.maxByOrNull { it.value } ?: return ResultadoRisco("N/A", 0, "Neutro")

    val emocao = maisFrequente.key
    val contagem = maisFrequente.value
    val percentual = (contagem * 100) / total

    val nivel = when (percentual) {
        in 0..25 -> "Neutro"
        in 26..50 -> "Leve"
        in 51..75 -> "Moderado"
        else -> "Agudo"
    }

    return ResultadoRisco(emocao, percentual, nivel)
}
