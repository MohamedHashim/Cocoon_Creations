package com.mohamedhashim.cocoon_creations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mohamedhashim.cocoon_creations.mvvm.ui.top_stories.TopStoriesFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val fragment = TopStoriesFragment()
        fragmentTransaction.add(R.id.top_stories_fragment, fragment)
        fragmentTransaction.commit()

    }
}