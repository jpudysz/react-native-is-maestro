package com.ismaestro

import com.facebook.react.bridge.ReactApplicationContext

class IsMaestroSpec internal constructor(context: ReactApplicationContext) : NativeIsMaestroSpec(context) {
    private val module: IsMaestroModule by lazy {
        IsMaestroModule(context)
    }

    override fun getName(): String {
        return IsMaestroModule.NAME;
    }

    override fun isMaestro(): Boolean {
        return module.isMaestro("localhost", 7001)
    }
}
