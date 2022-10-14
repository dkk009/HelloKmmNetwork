package com.app.hellokmmnetwork.android.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.app.hellokmmnetwork.news.data.entity.Articles
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(navHostController: NavHostController) {
    val homeViewModel = getViewModel<HomeViewModel>()
    val viewModelState = homeViewModel.newsFeedState.collectAsState()
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar {
            Text(text = "News Feed", modifier = Modifier.padding(horizontal = 20.dp))
        }
    }) {
        when (viewModelState.value) {
            NewsFeedState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
            is NewsFeedState.Success -> {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    items(items = (viewModelState.value as NewsFeedState.Success).data) { data ->
                        Column(modifier = Modifier.fillMaxWidth()) {
                            NewsArticleItem(data = data)
                            Divider(
                                color = Color.Gray,
                                thickness = 2.dp,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                            )
                        }
                    }
                }
            }
            is NewsFeedState.Error -> {
                Column(modifier = Modifier.fillMaxSize()) {
                    Spacer(modifier = Modifier.height(60.dp))
                    Text(
                        text = (viewModelState.value as NewsFeedState.Error).error,
                        style = MaterialTheme.typography.h3,
                        color = MaterialTheme.colors.error
                    )
                }
            }
            is NewsFeedState.None -> {
                //Ignore the state.
            }
        }
    }
}

@Composable
private fun NewsArticleItem(data: Articles) {
    Row(modifier = Modifier.fillMaxWidth()) {
        AsyncImage(
            model = data.urlToImage,
            contentDescription = null,
            modifier = Modifier
                .size(width = 120.dp, height = 72.dp)
                .align(alignment = Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = data.title ?: "", style = MaterialTheme.typography.body1)
    }

}