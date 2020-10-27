package com.klossteles.aula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager = findViewById<ViewPager>(R.id.viewPager)
        val tab = findViewById<TabLayout>(R.id.tabLayout)

        // faz com que o tab use o viewpager
        tab.setupWithViewPager(viewPager)

        val fragments = listOf(
            MeuFragment.newInstance("Felipe", true), MeuFragment.newInstance("Lucas", true), MeuFragment.newInstance("Teles", false)
        )

        val titulos = listOf(
            getString(R.string.home), getString(R.string.biblioteca), getString(R.string.favoritos)
        )

        pager.adapter = ViewPageAdapter(fragments, titulos, supportFragmentManager)
        tab.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_home_24)
        tab.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_library_books_24)
        tab.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_star_24)

        // a ideia é fazer com que ao clicar na suganda tab, que é a que tem notificação,
        // essa notificação seja ocultada, pois o usuario "já leu" as novidades dela
        tab.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(selected: TabLayout.Tab?) {
                selected?.badge?.isVisible = false
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }
}