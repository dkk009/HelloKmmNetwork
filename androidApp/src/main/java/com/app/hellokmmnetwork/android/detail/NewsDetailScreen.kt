package com.app.hellokmmnetwork.android.detail

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.app.hellokmmnetwork.android.R
import com.app.hellokmmnetwork.android.home.AppViewModel

@Composable
fun NewsDetailScreen(viewModel: AppViewModel) {
    val context = LocalContext.current
    val article = viewModel.selectedArticle.collectAsState()
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        Row(modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = {
                if (context is Activity) {
                    context.onBackPressed()
                }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back_24),
                    contentDescription = null
                )
            }
        }
    }) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            article?.value?.let {
                Text(text = it.title ?: "", style = MaterialTheme.typography.h5)
                Text(text = it.content ?: "", style = MaterialTheme.typography.body1)
                Text(text = it.description ?: "", style = MaterialTheme.typography.body2)
                AsyncImage(
                    model = it.urlToImage,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}