/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Cat
import com.example.androiddevchallenge.model.catsFakeModel
import com.example.androiddevchallenge.ui.component.CatInfo
import com.example.androiddevchallenge.ui.component.VerticalGrid

@Composable
fun HomeContent(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.subtitle1
                    )
                }
            )
        },
        content = {
            CatList(cats = catsFakeModel, navController)
        }
    )
}

@Composable
fun CatList(cats: List<Cat>, navController: NavController) {
    VerticalGrid(
        Modifier.padding(horizontal = 8.dp).verticalScroll(rememberScrollState())
    ) {
        cats.forEach { cat ->
            CatCard(
                cat = cat,
                modifier = Modifier.clipToBounds().padding(8.dp)
                    .clickable { navController.navigate("catDetailContent/${cat.id}") }
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun CatCard(cat: Cat, modifier: Modifier = Modifier) {
    Card(modifier = modifier, shape = MaterialTheme.shapes.large, elevation = 2.dp) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(cat.imageId),
                contentDescription = cat.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth().height(200.dp)
            )
            CatInfo(cat.name, cat.origin, cat.flag)
        }
    }
}
