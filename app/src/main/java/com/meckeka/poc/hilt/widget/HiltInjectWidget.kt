package com.meckeka.poc.hilt.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.meckeka.poc.hilt.databinding.WidgetPocInjectBinding
import com.meckeka.poc.hilt.poc.PocInject
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HiltInjectWidget @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    @Inject
    lateinit var pocInject: PocInject

    private var binding: WidgetPocInjectBinding =
        WidgetPocInjectBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        pocInject.random()
        binding.pocInjectText.text = "Random: ${pocInject.random}"
    }
}