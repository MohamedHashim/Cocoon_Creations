package com.mohamedhashim.cocoon_creations.mvvm.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mohamedhashim.cocoon_creations.R
import com.mohamedhashim.cocoon_creations.common_ui.extensions.toast
import com.mohamedhashim.cocoon_creations.databinding.FragmentStoryDetailsBinding
import com.mohamedhashim.cocoon_creations.entity.entities.Story
import com.mohamedhashim.cocoon_creations.mvvm.base.DataBindingFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel


/**
 * Created by Mohamed Hashim on 11/20/2020.
 */
class StoryDetailsFragment : DataBindingFragment() {
    private val viewModel: StoryDetailsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentStoryDetailsBinding>(
            inflater, R.layout.fragment_story_details, container
        ).apply {
            lifecycleOwner = this@StoryDetailsFragment
            viewModel = this@StoryDetailsFragment.viewModel
            story = requireArguments().get(getString(R.string.story_key)) as Story
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().tabLayout.visibility = View.GONE
        viewModel.loadArguments(arguments)
        observeMessages()
    }

    private fun observeMessages() =
        this.viewModel.toastLiveData.observe(viewLifecycleOwner, { context?.toast(getString(it)) })
}