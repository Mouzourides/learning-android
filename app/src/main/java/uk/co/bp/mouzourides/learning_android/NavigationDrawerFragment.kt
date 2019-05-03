package uk.co.bp.mouzourides.learning_android

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import android.support.design.widget.NavigationView
import uk.co.bp.mouzourides.learning_android.createJoke.CreateJokeActivity


class NavigationDrawerFragment : Fragment() {

    private val onNavigationItemSelectedListener = NavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
//                val intent = Intent(activity, JokeActivity::class.java)
//                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_create_joke -> {
                val intent = Intent(activity, CreateJokeActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_save_jokes -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.drawer_fragment, container, false)
        val navView: NavigationView = view.findViewById(R.id.top_nav_view)
        navView.setNavigationItemSelectedListener(onNavigationItemSelectedListener)
        return view
    }
}
