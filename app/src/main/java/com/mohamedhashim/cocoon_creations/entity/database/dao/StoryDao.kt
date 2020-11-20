package com.mohamedhashim.cocoon_creations.entity.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mohamedhashim.cocoon_creations.entity.entities.Story

/**
 * Created by Mohamed Hashim on 11/19/2020.
 */
@Dao
interface StoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStoryList(stories: List<Story>)

    @Query("SELECT * FROM STORY")
    fun getStoryList(): List<Story>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavouriteStory(story: Story)

    @Update
    fun updateStory(story: Story)

    @Query("SELECT * FROM STORY WHERE favourite = '1'")
    fun getFavouriteStoryList(): List<Story>

    @Query("SELECT * FROM STORY WHERE favourite = '1'")
    fun getFavouriteStoryLiveData(): LiveData<List<Story>>
}