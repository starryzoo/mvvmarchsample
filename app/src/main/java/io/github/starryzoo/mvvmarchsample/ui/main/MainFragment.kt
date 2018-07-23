package io.github.starryzoo.mvvmarchsample.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import io.github.starryzoo.mvvmarchsample.databinding.MainFragmentBinding
import io.github.starryzoo.mvvmarchsample.injection.scope.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class MainFragment @Inject constructor() : DaggerFragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var viewDataBinding: MainFragmentBinding
    @Inject lateinit var viewModelFactory: MainViewModelFactory


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        viewDataBinding = MainFragmentBinding.inflate(inflater, container, false)
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]

        // TODO :: ViewModel 의 LiveData를 DataBinding 에 연결.
        viewDataBinding.run {
            this.mainViewModel = viewModel
            setLifecycleOwner(activity)
        }
    }

}
