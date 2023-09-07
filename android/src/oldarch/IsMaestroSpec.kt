package com.ismaestro

import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule

abstract class IsMaestroSpec internal constructor(context: ReactApplicationContext) : ReactContextBaseJavaModule(context) {
    abstract fun isMaestro(promise: Promise)
}
