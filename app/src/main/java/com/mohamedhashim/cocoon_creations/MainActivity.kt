package com.mohamedhashim.cocoon_creations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mohamedhashim.cocoon_creations.mvvm.ui.top_stories.TopStoriesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: TopStoriesViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.viewModel.storyListLiveData.observe(this) {
            if (it.isNotEmpty())
                txt.text = it[0].toString()
        }

    }
}