package com.mohamedhashim.cocoon_creations.entity.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mohamedhashim.cocoon_creations.entity.entities.MultiMedia

/**
 * Created by Mohamed Hashim on 11/20/2020.
 */
open class MultimediaListConverter {

    @TypeConverter
    fun fromString(value: String): List<MultiMedia>? {
        val listType = object : TypeToken<List<MultiMedia>>() {}.type
        return Gson().fromJson<List<MultiMedia>>(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<MultiMedia>?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}
