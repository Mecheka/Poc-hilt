package com.meckeka.poc.hilt

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.meckeka.poc.hilt.poc.PocInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PocHiltViewModel @Inject constructor(private val pocInject: PocInject): ViewModel() {
    val randomState = MutableLiveData<Int?>(null)

    init {
        random()
    }

    private fun random() {
        pocInject.random()
        randomState.value = pocInject.random
    }
}