package com.mohamedhashim.cocoon_creations.mvvm.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment


/**
 * Created by Mohamed Hashim on 11/18/2020.
 */
abstract class DataBindingFragment : Fragment() {

    protected inline fun <reified T : ViewDataBinding> binding(
            inflater: LayoutInflater,
            @LayoutRes resId: Int,
            container: ViewGroup?
    ): T = DataBindingUtil.inflate(inflater, resId, container, false)
}
