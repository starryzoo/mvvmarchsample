package io.github.starryzoo.mvvmarchsample

import android.os.Bundle
import dagger.Lazy
import dagger.android.support.DaggerAppCompatActivity
import io.github.starryzoo.mvvmarchsample.ui.main.MainFragment
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var mainFragmentProvider: Lazy<MainFragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, mainFragmentProvider.get())
                    .commitNow()
        }

    }

}
