package com.mohamedhashim.cocoon_creations.entity.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Mohamed Hashim on 11/18/2020.
 */
@Parcelize
class Story(
    val title: String,
    val abstract: String,
    val url: String,
    val byline: String,
    val published_date: String,
    val multimedia: List<MultiMedia>
) : Parcelable