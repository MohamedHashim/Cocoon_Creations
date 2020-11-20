package com.mohamedhashim.cocoon_creations.mvvm.di

import androidx.room.Room
import com.mohamedhashim.cocoon_creations.R
import com.mohamedhashim.cocoon_creations.entity.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Created by Mohamed Hashim on 11/20/2020.
 */
val persistenceModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(), AppDatabase::class.java,
            androidApplication().getString(R.string.database)
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().storyDao() }
}