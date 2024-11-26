package com.meckeka.poc.hilt.poc

import javax.inject.Inject
import kotlin.random.Random

class PocInject @Inject constructor() {
    var random: Int? = null

    fun random() {
        random = Random.nextInt()
    }
}