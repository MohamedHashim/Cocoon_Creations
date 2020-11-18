package com.mohamedhashim.cocoon_creations.entity.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Mohamed Hashim on 11/18/2020.
 */
@Parcelize
class MultiMedia(
    val url: String,
    val caption: String
) : Parcelable