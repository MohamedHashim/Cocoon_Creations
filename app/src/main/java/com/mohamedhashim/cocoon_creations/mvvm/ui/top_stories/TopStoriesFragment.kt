package com.mohamedhashim.cocoon_creations.mvvm.ui.top_stories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mohamedhashim.cocoon_creations.R
import com.mohamedhashim.cocoon_creations.common_ui.adapters.TopStoriesAdapter
import com.mohamedhashim.cocoon_creations.common_ui.extensions.showTopStories
import com.mohamedhashim.cocoon_creations.common_ui.extensions.toast
import com.mohamedhashim.cocoon_creations.common_ui.viewholders.TopStoriesViewHolder
import com.mohamedhashim.cocoon_creations.databinding.FragmentTopStoriesBinding
import com.mohamedhashim.cocoon_creations.entity.entities.Story
import com.mohamedhashim.cocoon_creations.mvvm.base.DataBindingFragment
import com.mohamedhashim.cocoon_creations.mvvm.ui.details.StoryDetailsViewModel
import com.skydoves.baserecyclerviewadapter.RecyclerViewPaginator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_top_stories.*
import org.koin.android.viewmodel.ext.android.viewModel


/**
 * Created by Mohamed Hashim on 11/18/2020.
 */
class TopStoriesFragment : DataBindingFragment(), TopStoriesViewHolder.Delegate {

    private val viewModel: TopStoriesViewModel by viewModel()
    private val storyDetailsViewModel: StoryDetailsViewModel by viewModel()
    private val adapterTopStoriesList = TopStoriesAdapter(this)

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
            adapter = TopStoriesAdapter(this@TopStoriesFragment)
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUI()
        observeMessages()
        //TODO Check internet connection
        //TODO Add progress loading
        showTopStories(recyclerView, this.viewModel, this.adapterTopStoriesList)

    }

    private fun initializeUI() {
        requireActivity().tabLayout.visibility = View.VISIBLE
        RecyclerViewPaginator(
            recyclerView = recyclerView,
            isLoading = { false },
            loadMore = { },
            onLast = { false }
        )
    }

    private fun observeMessages() =
        this.viewModel.toastLiveData.observe(viewLifecycleOwner, { context?.toast(it) })

    override fun onItemClick(view: View, story: Story) {
        val updatedStory = this.storyDetailsViewModel.getUpdatedStory(story)
        findNavController().navigate(
            R.id.action_topStoriesFragment_to_storyDetailsFragment,
            TopStoriesViewModel.createArguments(updatedStory)
        )
    }

}