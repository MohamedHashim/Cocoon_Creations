package com.mohamedhashim.cocoon_creations.entity.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mohamedhashim.cocoon_creations.entity.converters.MultimediaListConverter
import com.mohamedhashim.cocoon_creations.entity.database.dao.StoryDao
import com.mohamedhashim.cocoon_creations.entity.entities.Story

/**
 * Created by Mohamed Hashim on 11/19/2020.
 */
@Database(entities = [Story::class], version = 1, exportSchema = true)
@TypeConverters(value = [MultimediaListConverter::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun storyDao(): StoryDao
}