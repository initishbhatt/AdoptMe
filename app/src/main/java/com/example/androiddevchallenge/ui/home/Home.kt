package com.example.androiddevchallenge.ui.home

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Cat
import com.example.androiddevchallenge.model.catsFakeModel
import com.example.androiddevchallenge.ui.component.VerticalGrid

/**
 * @author nitishbhatt
 */
@Composable
fun HomeContent() {
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(stringResource(id = R.string.app_name), style = MaterialTheme.typography.subtitle1)
        })
    }, content = {
        CatList(cats = catsFakeModel)
    })
}

@Composable
fun CatList(cats: List<Cat>) {
    VerticalGrid(Modifier.padding(horizontal = 16.dp).verticalScroll(rememberScrollState())) {
        cats.forEachIndexed { index, cat ->
            val (startPadding, endPadding) = startAndEndPadding(index)
            CatCard(
                cat = cat,
                modifier = Modifier.padding(start = startPadding, end = endPadding, bottom = 16.dp)
                    .fillMaxWidth().animateContentSize()
            )
        }
    }
}

@Composable
private fun startAndEndPadding(index: Int): Pair<Dp, Dp> {
    val startPadding = if (index % 2 == 0) 0.dp else 8.dp
    val endPadding = if (index % 2 == 0) 8.dp else 0.dp
    return Pair(startPadding, endPadding)
}

@Composable
fun CatCard(cat: Cat, modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = cat.imageId),
                contentDescription = cat.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth().height(180.dp)
            )
            CatInfo(cat.name, cat.origin, cat.flag)
        }
    }
}

@Composable
fun CatInfo(name: String, origin: String, flag: String) {
    Text(
        text = name,
        style = MaterialTheme.typography.h4,
        modifier = Modifier.padding(start = 8.dp, top = 4.dp)
    )
    Row(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = flag,
            modifier = Modifier.padding(start = 8.dp, end = 4.dp)
        )
        Text(
            text = origin,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(end = 8.dp)
        )
    }
}