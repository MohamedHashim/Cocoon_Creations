package com.mohamedhashim.cocoon_creations.mvvm.di

import com.mohamedhashim.cocoon_creations.mvvm.ui.top_stories.TopStoriesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Mohamed Hashim on 11/18/2020.
 */
val viewModelModule = module {
    viewModel { TopStoriesViewModel(get()) }
}