package mx.edu.utez.carrazosv3.ui.screens

import Title
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import mx.edu.utez.carrazosv3.ui.components.UserList
import mx.edu.utez.carrazosv3.viewmodel.UserListViewModel

@Composable
fun UserScreen(viewModel: UserListViewModel, navController: NavController){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(30.dp)
    ) {
        Title("Lista de usarios disponibles")
        UserList(viewModel.items.value, viewModel= viewModel)
    }

}