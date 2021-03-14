package com.android.jetpacksub.ui.movieTv

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.android.jetpacksub.R
import com.android.jetpacksub.util.DataMovieDummy
import com.android.jetpacksub.util.DataTvDummy
import org.junit.Rule
import org.junit.Test

class MovieTvActivityTest {
    private val dummyTv = DataTvDummy.generateDummyTv()
    private val dummyMovie = DataMovieDummy.generateDummyMovie()

    @get:Rule
    var activityRule = ActivityScenarioRule(MovieTvActivity::class.java)

    @Test
    fun loadMovie() {
        onView(withId(R.id.recyclerViewMovie)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerViewMovie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun loadDetailMovie() {
        val i = 1
        while (i < 10) {
            onView(withId(R.id.recyclerViewMovie)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    i,
                    click()
                )
            )
            onView(withId(R.id.textTitMovie)).check(matches(isDisplayed()))
            onView(withId(R.id.textTitMovie)).check(matches(withText(dummyMovie[i].name)))
            onView(withId(R.id.textDesMovie)).check(matches(isDisplayed()))
            onView(withId(R.id.textDesMovie)).check(matches(withText("Deskripsi : ${dummyMovie[i].desc}")))
            onView(withId(R.id.imageMovie)).check(matches(isDisplayed()))
        }

    }

    @Test
    fun loadTv() {
        onView(withId(R.id.recyclerViewTv)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerViewTv)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTv.size
            )
        )
    }

    @Test
    fun loadDetailTv() {
        var i = 0
        while (i < 10) {


            onView(withId(R.id.recyclerViewTv)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    i,
                    click()
                )
            )
            onView(withId(R.id.textTitTv)).check(matches(isDisplayed()))
            onView(withId(R.id.textTitTv)).check(matches(withText(dummyTv[i].name)))
            onView(withId(R.id.textDesTv)).check(matches(isDisplayed()))
            onView(withId(R.id.textDesTv)).check(matches(withText("Deskripsi : ${dummyTv[i].desc}")))
            onView(withId(R.id.imageTv)).check(matches(isDisplayed()))
            i++
        }
    }
}