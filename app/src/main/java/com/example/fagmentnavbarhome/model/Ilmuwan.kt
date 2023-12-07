package com.example.fagmentnavbarhome.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ilmuwan(
    val id: Int,
    val name: String,
    val description: String,
    val image: Int,
): Parcelable
