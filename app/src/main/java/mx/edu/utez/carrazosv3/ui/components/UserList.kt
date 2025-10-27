package mx.edu.utez.carrazosv3.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import mx.edu.utez.carrazosv3.data.model.User
import mx.edu.utez.carrazosv3.viewmodel.UserListViewModel

@Composable
fun UserList(lista: List<User>, viewModel: UserListViewModel){
    LazyColumn {
        items(items = lista, key = { it.id }) { item ->
            UserCard(
                usr = item,
                x = { viewModel.onItemClicked(item) }
            )
        }
    }

}