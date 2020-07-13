package com.jsevilla.musicapp.data.net.service.impl

import android.content.Context
import com.jsevilla.musicapp.data.common.NetworkUtil

abstract class BaseService protected constructor(val context: Context?) {

    protected val isThereInternetConnection: Boolean
        get() = NetworkUtil.isThereInternetConnection(context!!)

    init {
        if (null == context) {
            throw IllegalArgumentException("El constructor no puede recibir parametros nulos!!!")
        }
    }
}
