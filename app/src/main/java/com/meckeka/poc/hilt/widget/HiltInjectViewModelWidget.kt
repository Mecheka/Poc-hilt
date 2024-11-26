package com.meckeka.poc.hilt.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.meckeka.poc.hilt.PocHiltViewModel
import com.meckeka.poc.hilt.databinding.WidgetPocInjectBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HiltInjectViewModelWidget @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
) : FrameLayout(context, attrs), DefaultLifecycleObserver {

    private val binding = WidgetPocInjectBinding.inflate(LayoutInflater.from(context), this, true)
    private var viewModel: PocHiltViewModel? = null

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        findViewTreeLifecycleOwner()?.lifecycle?.addObserver(this)
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)

        setupViewModel()
        observeViewModel(owner)
    }

    private fun setupViewModel() {
        findViewTreeViewModelStoreOwner()?.let {
            val provider =  ViewModelProvider(
                it
            )
            viewModel = provider[PocHiltViewModel::class.java]
        }
    }

    private fun observeViewModel(owner: LifecycleOwner) {
        viewModel?.randomState?.observe(owner) { data ->
            binding.pocInjectText.text = "Random view model: $data"
        }
    }
}