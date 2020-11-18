package com.mohamedhashim.cocoon_creations.common_ui.viewholders

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by Mohamed Hashim on 11/19/2020.
 */
inline fun <reified T : ViewDataBinding> bindings(view: View): Lazy<T> =
    lazy {
        DataBindingUtil.bind<T>(view)
            ?: throw IllegalAccessException("cannot find the matched view to layout.")
    }