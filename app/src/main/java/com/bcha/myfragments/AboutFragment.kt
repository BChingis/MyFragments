package com.bcha.myfragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class AboutFragment : Fragment() {

    private lateinit var mailToButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)
        mailToButton = view.findViewById(R.id.site_button)

        mailToButton.setOnClickListener {
            val link = Uri.parse("https://odin.study")
            val intent = Intent(Intent.ACTION_VIEW, link)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

        return view
    }


}