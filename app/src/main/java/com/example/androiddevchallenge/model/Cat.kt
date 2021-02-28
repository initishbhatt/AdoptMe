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
package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import com.example.androiddevchallenge.R

@Immutable
data class Cat(
    val id: Int,
    val name: String,
    val age: String,
    val gender: String,
    val caption: String,
    val origin: String,
    val flag: String,
    val weight:String,
    @DrawableRes val imageId: Int
)

val catsFakeModel = listOf(
    Cat(
        1,
        "Simba",
        "3 Years",
        "Male️",
        "I love you meow and furever.",
        "Chile",
        "\uD83C\uDDE8\uD83C\uDDF1",
        "2 kg",
        R.drawable.img_cat_1
    ),
    Cat(
        2,
        "Tobo",
        "2Years",
        "Male️",
        "Anything is paws-ible with a cat by your side.",
        "Scotland",
        "\uD83C\uDDEC\uD83C\uDDE7",
        "1 kg",
        R.drawable.img_cat_2
    ),
    Cat(
        3,
        "Cermy",
        "5 Years",
        "Female️",
        "Think of the hilarious videos we could make...",
        "Canada, Isle of Man",
        "\uD83C\uDDE8\uD83C\uDDE6",
        "2.5 kg",
        R.drawable.img_cat_3
    ),
    Cat(
        4,
        "Bomby",
        "2 Years",
        "Female️",
        "Meet your lap warmer",
        "USA",
        "\uD83C\uDDFA\uD83C\uDDF8",
        "3 kg",
        R.drawable.img_cat_4
    ),
    Cat(
        5,
        "julie",
        "1 Year",
        "Female️",
        "Julie can't wait for a spring break.",
        "USA",
        "\uD83C\uDDFA\uD83C\uDDF8",
        "4 kg",
        R.drawable.img_cat_5
    ),
    Cat(
        6,
        "Mau",
        "1 Year",
        "Male️",
        " This little charmer knows he's got it and is not afraid to flaunt it.",
        "Peru",
        "\uD83C\uDDF5\uD83C\uDDEA",
        "4 kg",
        R.drawable.img_cat_6
    ),
    Cat(
        7,
        "Blue",
        "5 Years",
        "Male️",
        "Sassy,single ready to mingle.",
        "Russia",
        "\uD83C\uDDF7\uD83C\uDDFA",
        "3.7 kg",
        R.drawable.img_cat_7
    )

)
