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
        val ports = listOf(7001, 9999)

        for (port in ports) {
            try {
                val socket = Socket(InetAddress.getByName("localhost"), port)
                socket.close()

                return true
            } catch (e: Exception) {
                continue
            }
        }

        return false
    }

    companion object {
        const val NAME = "IsMaestro"
    }
}
