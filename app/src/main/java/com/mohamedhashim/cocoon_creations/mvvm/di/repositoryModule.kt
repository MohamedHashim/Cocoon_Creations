package com.mohamedhashim.cocoon_creations.mvvm.di

import com.mohamedhashim.cocoon_creations.mvvm.repository.TopStoriesRepository
import org.koin.dsl.module

/**
 * Created by Mohamed Hashim on 11/18/2020.
 */
val repositoryModule = module {
    single { TopStoriesRepository(get(), get()) }
}
