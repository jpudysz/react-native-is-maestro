package com.ismaestro

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactMethod
import java.net.InetAddress
import java.net.Socket

class IsMaestroModule internal constructor(context: ReactApplicationContext) : IsMaestroSpec(context) {
    override fun getName(): String {
        return NAME
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    override fun isMaestro(): Boolean {
        return try {
            val socket = Socket(InetAddress.getByName("localhost"), 7001)
            socket.close()

            true
        } catch (e: Exception) {
            false
        }
    }

    companion object {
        const val NAME = "IsMaestro"
    }
}
