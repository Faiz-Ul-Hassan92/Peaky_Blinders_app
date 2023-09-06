package com.example.peakyblinders.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Character(
    @StringRes val num : Int,
    @StringRes val name : Int,
    @DrawableRes val imageResource : Int,
    @StringRes val description : Int
)