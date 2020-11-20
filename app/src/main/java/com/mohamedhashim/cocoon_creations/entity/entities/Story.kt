package com.mohamedhashim.cocoon_creations.entity.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * Created by Mohamed Hashim on 11/18/2020.
 */
@Entity
@Parcelize
class Story(
    @PrimaryKey
    var title: String,
    //TODO add abstract in details screen
//    var abstract: String,
    var url: String,
    var byline: String,
    var published_date: String,
    var multimedia: List<MultiMedia>? = ArrayList(),
    var favourite: Boolean
) : Parcelable