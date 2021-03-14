package com.android.jetpacksub.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
 data class Tv (
    var img : String= "",
     var name : String? = "",
     var desc: String? = ""
 ) : Parcelable
