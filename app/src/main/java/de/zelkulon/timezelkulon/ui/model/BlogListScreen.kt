package de.zelkulon.timezelkulon.ui.model

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.google.android.material.card.MaterialCardView

import de.zelkulon.timezelkulon.dao.BlogViewModel
import de.zelkulon.timezelkulon.model.Blog
import de.zelkulon.timezelkulon.model.InfoCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlogListScreen(viewModel: BlogViewModel) {
    val blogs by viewModel.blogs.collectAsState()

    LazyColumn {
        items(blogs) { blog ->
            BlogItem(blog)
        }
    }
}

@Composable
fun BlogItem(blog: Blog) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = blog.title, )
            Text(text = "By: ${blog.artist}", )
            Text(text = "Location: ${blog.location}", )
        }
    }
}
