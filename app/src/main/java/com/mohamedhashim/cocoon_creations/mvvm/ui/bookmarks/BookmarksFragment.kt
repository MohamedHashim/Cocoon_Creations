package com.mohamedhashim.cocoon_creations.mvvm.ui.bookmarks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mohamedhashim.cocoon_creations.R
import com.mohamedhashim.cocoon_creations.common_ui.adapters.FavouriteStoriesAdapter
import com.mohamedhashim.cocoon_creations.common_ui.adapters.TopStoriesAdapter
import com.mohamedhashim.cocoon_creations.common_ui.extensions.showFavouriteStories
import com.mohamedhashim.cocoon_creations.common_ui.extensions.toast
import com.mohamedhashim.cocoon_creations.common_ui.viewholders.TopStoriesViewHolder
import com.mohamedhashim.cocoon_creations.databinding.FragmentBookmarksBinding
import com.mohamedhashim.cocoon_creations.entity.entities.Story
import com.mohamedhashim.cocoon_creations.mvvm.base.DataBindingFragment
import com.mohamedhashim.cocoon_creations.mvvm.ui.details.StoryDetailsViewModel
import com.mohamedhashim.cocoon_creations.mvvm.ui.top_stories.TopStoriesViewModel
import com.skydoves.baserecyclerviewadapter.RecyclerViewPaginator
import kotlinx.android.synthetic.main.fragment_bookmarks.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Mohamed Hashim on 11/19/2020.
 */
class BookmarksFragment : DataBindingFragment(), TopStoriesViewHolder.Delegate {
    private val viewModel: TopStoriesViewModel by viewModel()
    private val storyDetailsViewModel: StoryDetailsViewModel by viewModel()
    private val adapterStoryList = FavouriteStoriesAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentBookmarksBinding>(
            inflater, R.layout.fragment_bookmarks, container
        ).apply {
            viewModel = this@BookmarksFragment.viewModel
            lifecycleOwner = this@BookmarksFragment
            adapter = FavouriteStoriesAdapter(this@BookmarksFragment)
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUI()
        observeMessages()
        showFavouriteStories(fav_recyclerView, this.viewModel, this.adapterStoryList)
    }

    private fun initializeUI() {
        RecyclerViewPaginator(
            recyclerView = fav_recyclerView,
            isLoading = { false },
            loadMore = { null },
            onLast = { false }
        )
    }

    private fun observeMessages() =
        this.viewModel.toastLiveData.observe(viewLifecycleOwner, { context?.toast(it) })

    override fun onItemClick(view: View, story: Story) {
        val updatedStory = this.storyDetailsViewModel.getUpdatedStory(story)
        findNavController().navigate(
            R.id.action_bookmarksFragment_to_storyDetailsFragment,
            TopStoriesViewModel.createArguments(updatedStory)
        )
    }
}