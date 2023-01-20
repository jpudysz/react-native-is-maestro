package com.ismaestro

import com.facebook.react.bridge.ReactApplicationContext
import java.net.InetAddress
import java.net.Socket

class IsMaestroModule internal constructor(context: ReactApplicationContext): IsMaestroSpec(context) {
    fun isMaestro(ipAddress: String, port: Int): Boolean {
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
