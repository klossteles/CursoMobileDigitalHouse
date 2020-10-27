package com.klossteles.execicio01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

const val SIGN_IN_FRAGMENT = 0
const val SIGN_UP_FRAGMENT = 1

class MainActivity : AppCompatActivity(), IMudarTab {
    private val tab by lazy { findViewById<TabLayout>(R.id.tabLayoutLogin) }

    private lateinit var signInFragment: SignInFragment
    private lateinit var signUpFragment: SignUpFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager = findViewById<ViewPager>(R.id.viewPagerLogin)

        // faz com que o tab use o viewpager
        tab.setupWithViewPager(viewPagerLogin)
        signInFragment = SignInFragment()
        signUpFragment = SignUpFragment()
        pager.adapter = ViewPageAdapter(
            listOf(signInFragment, signUpFragment),
            listOf(getString(R.string.sign_in), getString(R.string.sign_up)),
            supportFragmentManager
        )
    }

    override fun mudarTab(posicaoAtual: Int) {
        val novaPosicao = if(posicaoAtual == SIGN_IN_FRAGMENT) {
            SIGN_UP_FRAGMENT
        } else {
            SIGN_IN_FRAGMENT
        }
        val tabNova = tab.getTabAt(novaPosicao)
        tabNova?.select()
    }

    override fun usernameAlterado(username: String) {
        signInFragment.usernameAlterado(username)
    }
}