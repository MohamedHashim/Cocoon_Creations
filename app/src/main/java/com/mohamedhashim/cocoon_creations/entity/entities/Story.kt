package com.mohamedhashim.cocoon_creations.entity.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Mohamed Hashim on 11/18/2020.
 */
@Parcelize
class Story(
    private val title: String,
    private val abstract: String,
    private val url: String,
    private val byline: String,
    private val published_date: String,
    private val multimedia: List<MultiMedia>
) : Parcelable