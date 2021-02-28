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
package com.example.androiddevchallenge.ui.details

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Cat
import com.example.androiddevchallenge.model.catsFakeModel
import com.example.androiddevchallenge.ui.component.AdoptMeButton
import com.example.androiddevchallenge.ui.component.CatDetail
import com.example.androiddevchallenge.ui.component.CatInfo

@Composable
fun CatDetailContent(id: Int, navigationController: NavHostController) {
    catsFakeModel.find { it.id == id }?.let {
        CatDetails(cat = it, navigationController)
    }
}

@Composable
fun CatDetails(cat: Cat, navigationController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(cat.name, style = MaterialTheme.typography.subtitle1)
                },
                navigationIcon = {
                    IconButton(onClick = { navigationController.navigateUp() }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back")
                    }
                }
            )
        },
        content = {
            val context = LocalContext.current
            Column(
                modifier = Modifier.fillMaxHeight().verticalScroll(
                    rememberScrollState()
                )
            ) {
                CatImage(cat.imageId, cat.name)
                Spacer(modifier = Modifier.height(24.dp))
                CatInfo(name = cat.name, origin = cat.origin, flag = cat.flag)
                Spacer(modifier = Modifier.height(16.dp))
                CatDetailRow(cat.age, cat.gender, cat.weight)
                Spacer(modifier = Modifier.height(16.dp))
                CatCaption(cat.caption)
            }
            Row(modifier = Modifier.fillMaxHeight(), verticalAlignment = Alignment.Bottom) {
                AdoptMeButton(
                    onClick = { showToastMessage(context = context) },
                    textId = R.string.adopt_me_text,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .padding(8.dp)
                )
            }
        }
    )
}

@Composable
fun CatDetailRow(age: String, gender: String, weight: String) {
    LazyRow {
        val modifier = Modifier.padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .requiredSize(88.dp)
        item {
            CatDetail(
                header = "Gender",
                body = gender,
                modifier = modifier
                    .background(color = Color.Blue.copy(0.3f))
            )
        }
        item {
            CatDetail(
                header = "Age",
                body = age,
                modifier = modifier
                    .background(color = Color.Red.copy(0.3f))
            )
        }
        item {
            CatDetail(
                header = "Weight",
                body = weight,
                modifier = modifier
                    .background(color = Color.Cyan.copy(0.3f))
            )
        }
    }
}

private fun showToastMessage(context: Context) {
    Toast.makeText(
        context,
        R.string.adopt_me_thankyou_text,
        Toast.LENGTH_SHORT
    ).show()
}

@Composable
fun CatCaption(caption: String) {
    Text(
        text = "Fun fact",
        style = MaterialTheme.typography.h4,
        modifier = Modifier.padding(horizontal = 8.dp),
        textAlign = TextAlign.Start,
        color = Color.Blue
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = caption,
        style = MaterialTheme.typography.subtitle1,
        modifier = Modifier.padding(horizontal = 8.dp),
        textAlign = TextAlign.Start,
        maxLines = 2
    )
}

@Composable
fun CatImage(imageId: Int, name: String) {
    Card(modifier = Modifier.fillMaxWidth(), shape = MaterialTheme.shapes.small) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth().height(320.dp)
        )
    }
}
