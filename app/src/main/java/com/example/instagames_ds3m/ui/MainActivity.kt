package com.example.instagames_ds3m.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.instagames_ds3m.R
import com.example.instagames_ds3m.fragments.HomeFragment
import com.example.instagames_ds3m.fragments.NewPostFragment
import com.example.instagames_ds3m.repository.GamePostRepository
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.jetbrains.anko.doAsync

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var homeFragment: HomeFragment
    private lateinit var newPostFragment: NewPostFragment
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragments()
        initViews()

        setFragment(homeFragment)

    }

    private fun initViews() {
        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    private fun initFragments() {
        homeFragment = HomeFragment()
        newPostFragment = NewPostFragment()
    }

    private fun setFragment(fragment: Fragment){

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_fragments, fragment)
        fragmentTransaction.commit()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_home -> {
                setFragment(homeFragment)
            }
            R.id.menu_add_post -> {
                setFragment(newPostFragment)
            }
        }

        return true
    }
}