package com.test.common.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.test.common.alias.InflateActivity
import dev.chrisbanes.insetter.applyInsetter

abstract class BaseActivity<VB : ViewBinding>(
    private val inflate: InflateActivity<VB>,
) : AppCompatActivity() {

    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate.invoke(layoutInflater)
        setContentView(binding.root)
        initView()
        initObs()
    }

    abstract fun initView()
    protected open fun initObs() {}

    protected fun navInset(vararg views: View) {
        views.forEach { view ->
            view.applyInsetter {
                type(navigationBars = true) {
                    margin()
                }
            }
        }
    }

    protected fun statusBarInset(vararg views: View) {
        views.forEach { view ->
            view.applyInsetter {
                type(statusBars = true) {
                    margin()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        clear()
    }

    protected open fun clear() {}

}