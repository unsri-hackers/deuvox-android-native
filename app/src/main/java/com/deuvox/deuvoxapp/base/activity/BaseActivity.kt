package com.deuvox.deuvoxapp.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.deuvox.deuvoxapp.App
import com.deuvox.deuvoxapp.base.viewmodel.ViewModelFactory
import com.deuvox.deuvoxapp.di.component.AppComponent
import java.lang.NullPointerException
import javax.inject.Inject

abstract class BaseActivity<Binding> : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    open val applicationComponent: AppComponent by lazy {
        (application as App).appComponent ?: run {
            throw NullPointerException()
        }
    }

    open val binding by lazy {
        getViewBinding()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (binding as ViewBinding).run {
            setContentView(root)
        }
        injectComponent()
        init()
    }

    abstract fun getViewBinding(): Binding
    abstract fun init()

    open fun injectComponent() {
        /* Override to Inject Dagger Activity Component */
    }

    companion object {
        private const val TAG = "BaseActivity"
    }
}