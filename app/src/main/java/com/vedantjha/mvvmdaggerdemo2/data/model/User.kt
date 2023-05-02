package com.vedantjha.mvvmdaggerdemo2.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(var name: String) : Parcelable
