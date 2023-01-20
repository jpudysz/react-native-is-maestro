package com.ismaestro

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

abstract class IsMaestroSpec internal constructor(context: ReactApplicationContext) : ReactContextBaseJavaModule(context) {
    private val module: IsMaestroModule by lazy {
        IsMaestroModule(context)
    }

    override fun getName(): String {
        return IsMaestroModule.NAME;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    fun isMaestro(): Boolean {
        return IsMaestroModule(this.reactApplicationContext).isMaestro("localhost", 7001)
    }
}
