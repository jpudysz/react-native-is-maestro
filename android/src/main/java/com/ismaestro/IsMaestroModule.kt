package com.ismaestro

import com.facebook.react.bridge.ReactApplicationContext
import java.net.InetAddress
import java.net.Socket

class IsMaestroModule internal constructor(context: ReactApplicationContext) :
  IsMaestroSpec(context) {
    override fun isMaestro(): Boolean {
        try {
            val socket = Socket(InetAddress.getByName("localhost"), 7001)
            socket.close()

            return true
        } catch (e: Exception) {
            return false
        }
    }

    override fun getName(): String {
    return NAME
  }

  companion object {
    const val NAME = "IsMaestro"
  }
}
