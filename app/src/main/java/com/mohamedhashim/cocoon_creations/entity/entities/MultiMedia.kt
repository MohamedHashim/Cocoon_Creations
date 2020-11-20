package com.mohamedhashim.cocoon_creations.entity.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Mohamed Hashim on 11/18/2020.
 */
@Parcelize
data class MultiMedia(
    var url: String,
    val caption: String
) : Parcelable