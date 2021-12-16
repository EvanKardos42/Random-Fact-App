package com.example.randomfactsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.randomfactsapp.ui.main.MainFragment
import com.example.randomfactsapp.ui.util.Callback
import com.example.randomfactsapp.ui.yearfact.FactYearFragment


class MainActivity : AppCompatActivity(),Callback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    override fun callFragment(idx:Int) {
        val frag = FactYearFragment.newInstance()
        val bundle = Bundle()
        bundle.putInt(FactYearFragment.BUNDLE_KEY, idx)

        frag.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, frag)
            .addToBackStack(null)
            .commit()
    }
}