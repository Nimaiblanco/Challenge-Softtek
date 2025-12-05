package com.example.softteksaudementalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.softteksaudementalapp.data.*
import com.example.softteksaudementalapp.model.*
import com.example.softteksaudementalapp.screens.*
import com.example.softteksaudementalapp.ui.screens.*
import com.example.softteksaudementalapp.ui.theme.SoftteksaudementalappTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = AppDatabase.getDatabase(applicationContext)
        val repoHumor = HumorRepository(db.humorDao())
        val repoClima = ClimaRepository(db.climaDao())
        val repoCargaEAlerta = CargaAlertaRepository(db.cargaEAlertaDao())

        setContent {
            SoftteksaudementalappTheme {
                var telaAtual by remember { mutableStateOf("checkin") }

                val registros by repoHumor.todos.collectAsState(initial = emptyList())
                val climas by repoClima.respostas.collectAsState(initial = emptyList())
                val cargaAlerta by repoCargaEAlerta.listar().collectAsState(initial = emptyList())

                val scope = rememberCoroutineScope()

                Scaffold(
                    topBar = { TopAppBar(title = { Text("Saúde Mental Softtek") }) },
                    bottomBar = {
                        NavigationBar {
                            NavigationBarItem(
                                selected = telaAtual == "checkin",
                                onClick = { telaAtual = "checkin" },
                                icon = { Icon(Icons.Default.Edit, contentDescription = "Check-in") },
                                label = { Text("Check-in") }
                            )
                            NavigationBarItem(
                                selected = telaAtual == "dashboard",
                                onClick = { telaAtual = "dashboard" },
                                icon = { Icon(Icons.Default.Info, contentDescription = "Dashboard") },
                                label = { Text("Dashboard") }
                            )
                            NavigationBarItem(
                                selected = telaAtual == "clima",
                                onClick = { telaAtual = "clima" },
                                icon = { Icon(Icons.Default.BarChart, contentDescription = "Clima") },
                                label = { Text("Clima") }
                            )
                            NavigationBarItem(
                                selected = telaAtual == "apoio",
                                onClick = { telaAtual = "apoio" },
                                icon = { Icon(Icons.Default.Help, contentDescription = "Apoio") },
                                label = { Text("Apoio") }
                            )
                        }
                    }
                ) { padding ->
                    Surface(modifier = Modifier.padding(padding)) {
                        when (telaAtual) {
                            "checkin" -> CheckInScreen { registro ->
                                scope.launch { repoHumor.inserir(registro) }
                            }

                            "dashboard" -> DashboardScreen(
                                avaliacoes = emptyList(), // Avaliação removida
                                climas = climas,
                                registros = registros,
                                cargaAlerta = cargaAlerta
                            )

                            "clima" -> ClimaScreen(
                                onSalvarClima = { resposta ->
                                    scope.launch { repoClima.salvar(resposta) }
                                },
                                onSalvarCargaEAlerta = { resposta ->
                                    scope.launch { repoCargaEAlerta.salvar(resposta) }
                                }
                            )

                            "apoio" -> ApoioScreen()
                        }
                    }
                }
            }
        }
    }
}
