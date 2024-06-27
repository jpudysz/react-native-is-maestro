package com.ismaestro

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.ReactContextBaseJavaModule
import java.net.Socket

class IsMaestroModule internal constructor(context: ReactApplicationContext) :  ReactContextBaseJavaModule(context) {
    override fun getName(): String {
        return NAME
    }

    companion object {
        const val NAME = "IsMaestro"
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    fun isMaestro(): Boolean {
        return try {
            Socket("localhost", 7001).use { true }
        } catch (e: Exception) {
            false
        }
    }
}
