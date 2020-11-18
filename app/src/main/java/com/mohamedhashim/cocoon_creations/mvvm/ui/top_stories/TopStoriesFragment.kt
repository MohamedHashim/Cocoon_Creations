package com.mohamedhashim.cocoon_creations.mvvm.ui.top_stories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mohamedhashim.cocoon_creations.R
import com.mohamedhashim.cocoon_creations.common_ui.adapters.TopStoriesAdapter
import com.mohamedhashim.cocoon_creations.common_ui.extensions.showTopStories
import com.mohamedhashim.cocoon_creations.databinding.FragmentTopStoriesBinding
import com.mohamedhashim.cocoon_creations.mvvm.base.DataBindingFragment
import com.skydoves.baserecyclerviewadapter.RecyclerViewPaginator
import kotlinx.android.synthetic.main.fragment_top_stories.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Mohamed Hashim on 11/18/2020.
 */
class TopStoriesFragment : DataBindingFragment() {

    private val viewModel: TopStoriesViewModel by viewModel()
    private val adapterTopStoriesList = TopStoriesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentTopStoriesBinding>(
            inflater, R.layout.fragment_top_stories, container
        ).apply {
            viewModel = this@TopStoriesFragment.viewModel
            lifecycleOwner = this@TopStoriesFragment
            adapter = TopStoriesAdapter()
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUI()
        observeMessages()
        //TODO Check internet connection
        //Add progress loading
        showTopStories(recyclerView, this.viewModel, this.adapterTopStoriesList)

    }

    fun getInit(): TopStoriesFragment? {
        return TopStoriesFragment()
    }
    private fun initializeUI() {
        RecyclerViewPaginator(
            recyclerView = recyclerView,
            isLoading = { false },
            loadMore = { },
            onLast = { false }
        )
    }

    // TODO Use dataBinding in toast
    private fun observeMessages() =
            this.viewModel.toastLiveData.observe(viewLifecycleOwner, {
                Toast.makeText(
                    context,
                    it,
                    Toast.LENGTH_SHORT
                ).show()
            })

}