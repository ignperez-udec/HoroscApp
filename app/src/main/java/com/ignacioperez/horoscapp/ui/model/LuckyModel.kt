package com.ignacioperez.horoscapp.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

//drawableRes y stringRes es de UI, por eso el modelo va alli (obliga a que image y text sean drawable y string respecivamente)
data class LuckyModel(
    @DrawableRes val image: Int,
    @StringRes val text: Int
)
