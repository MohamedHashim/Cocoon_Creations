package com.mohamedhashim.cocoon_creations.entity.database.dao

import androidx.room.*
import com.mohamedhashim.cocoon_creations.entity.entities.MultiMedia
import com.mohamedhashim.cocoon_creations.entity.entities.Story

/**
 * Created by Mohamed Hashim on 11/19/2020.
 */
@Dao
interface StoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavouriteStory(story: Story)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStoryList(stories: List<Story>)

    @Query("SELECT * FROM STORY")
    fun getStoryList(): List<Story>

//    @Query("SELECT * FROM STORY WHERE story_id = :id_")
//    fun getStory(id_: Int): Story

    @Update
    fun updateStory(story: Story)

//    @Query("SELECT * FROM Story WHERE favourite = '1'")
//    fun getFavouriteStoryList(): List<Story>
//
//    @Query("SELECT * FROM  WHERE favourite = '1'")
//    fun getFavouriteStoryLiveData(): LiveData<List<Stroy>>
}