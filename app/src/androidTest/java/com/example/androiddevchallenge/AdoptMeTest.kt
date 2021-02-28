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
package com.example.androiddevchallenge

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.androiddevchallenge.model.catsFakeModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class AdoptMeTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun test_app_launches() {
        composeTestRule.onNodeWithTag("gridTag").assertIsDisplayed()
    }

    @Test
    fun test_detail_screen_opens_on_item_click() {
        composeTestRule.onNodeWithText("Simba", useUnmergedTree = true).assertIsDisplayed()
        composeTestRule.onNodeWithText("Simba", useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithText("I love you meow and furever.", useUnmergedTree = true).assertIsDisplayed()
    }

    @Test
    fun test_detail_screen_contents_are_matching_model() {
        composeTestRule.onNodeWithText("Simba", useUnmergedTree = true).performClick()
        composeTestRule.onNodeWithText(catsFakeModel.first().caption, useUnmergedTree = true).assertIsDisplayed()
        composeTestRule.onNodeWithText(catsFakeModel.first().age, useUnmergedTree = true).assertIsDisplayed()
        composeTestRule.onNodeWithText(catsFakeModel.first().gender, useUnmergedTree = true).assertIsDisplayed()
        composeTestRule.onNodeWithText(catsFakeModel.first().weight, useUnmergedTree = true).assertIsDisplayed()
    }
}
