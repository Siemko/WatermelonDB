package com.nozbe.watermelonTest

import com.facebook.react.ReactActivity
import com.example.hellojni.HelloJni
import com.facebook.react.bridge.ReactContext
import com.facebook.react.ReactInstanceManager

class MainActivity : ReactActivity(), ReactInstanceManager.ReactInstanceEventListener {
    override fun getMainComponentName(): String? = "watermelonTest"

    public override fun onResume() {
        super.onResume()
        reactInstanceManager.addReactInstanceEventListener(this)
    }

    public override fun onPause() {
        super.onPause()
        reactInstanceManager.removeReactInstanceEventListener(this)
    }

    override fun onReactContextInitialized(context: ReactContext) {
        HelloJni().installBinding(context.javaScriptContextHolder.get())
    }
}
