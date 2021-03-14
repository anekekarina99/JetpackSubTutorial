package com.android.jetpacksub.ui.movieTv.tv


import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test


class TvViewModelTest {

    private lateinit var viewModel: TvViewModel

    @Before
    fun setUp() {
        viewModel = TvViewModel()
    }

    @Test
    fun getTv() {
        val tvEntities = viewModel.getTv()
        assertNotNull(tvEntities)
        assertEquals(10, tvEntities.size)
    }
}