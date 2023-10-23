package com.test.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.test.common.alias.Inflate
import dev.chrisbanes.insetter.applyInsetter

abstract class BaseFragment<VB : ViewBinding>(
    private val inflate: Inflate<VB>,
) : Fragment() {

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

    override fun onDestroyView() {
        super.onDestroyView()
        clear()
    }

    @CallSuper
    protected open fun clear() {
        _binding = null
    }
}