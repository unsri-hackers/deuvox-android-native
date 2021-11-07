package com.example.deuvox.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<Binding> : Fragment() {

    open val binding by lazy {
        getViewBinding()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return (binding as ViewBinding).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        injectComponent()
        init()
    }

    abstract fun getViewBinding(): Binding
    abstract fun init()

    open fun injectComponent() {
        /* Override to Inject Dagger Fragment Component */
    }
}