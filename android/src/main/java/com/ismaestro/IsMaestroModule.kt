package com.ismaestro

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactMethod
import java.net.InetAddress
import java.net.Socket

class IsMaestroModule internal constructor(context: ReactApplicationContext) : IsMaestroSpec(context) {
    override fun getName(): String {
        return NAME;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    override fun isMaestro(): Boolean {
        return determineIsMaestro("localhost", 7001)
    }

    private fun determineIsMaestro(ipAddress: String, port: Int): Boolean {
        return try {
            val socket = Socket(InetAddress.getByName(ipAddress), port)
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
