package com.mohamedhashim.cocoon_creations.mvvm.ui.bookmarks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mohamedhashim.cocoon_creations.R
import com.mohamedhashim.cocoon_creations.databinding.FragmentBookmarksBinding
import com.mohamedhashim.cocoon_creations.mvvm.base.DataBindingFragment

/**
 * Created by Mohamed Hashim on 11/19/2020.
 */
class BookmarksFragment : DataBindingFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentBookmarksBinding>(
            inflater, R.layout.fragment_bookmarks, container
        ).apply {
            lifecycleOwner = this@BookmarksFragment
        }.root
    }
}