package com.bcha.myfragments

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTED_ITEM = "item"

class MainActivity : AppCompatActivity() {

    private lateinit var bottomMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomMenu = findViewById(R.id.bottom_menu)

        bottomMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.main -> {
                    val menuFragment = MenuFragment()
                    replaceFragment(menuFragment)
                }
                R.id.about -> replaceFragment(AboutFragment())
                R.id.dial -> {
//                    val intent = Intent(Intent.ACTION_SEND)
//                    intent.type = "text/plain"
//                    intent.putExtra(Intent.EXTRA_TEXT, "hello")
//                    val chooser = Intent.createChooser(intent, "Поделиться!")
//                    startActivity(chooser)

                    val link = Uri.parse("tel:" + "123456789")
                    val intent = Intent(Intent.ACTION_DIAL, link)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                }
            }
            true
        }

        bottomMenu.selectedItemId =
            savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.main

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(LAST_SELECTED_ITEM,bottomMenu.selectedItemId)
        super.onSaveInstanceState(outState)
    }
}