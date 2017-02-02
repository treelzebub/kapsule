package net.treelzebub.knapsack.extensions

import android.app.Activity
import android.content.Intent
import android.os.Bundle


/**
 * startActivityForResult(intentFor<MainActivity>(myBundle))
 */
inline fun <reified T : Activity> Activity.intentFor(b: Bundle = Bundle.EMPTY): Intent {
    return Intent(this, T::class.java).apply { putExtras(b) }
}

/**
 * startActivity<MainActivity>(myBundle)
 */
inline fun <reified T : Activity> Activity.startActivity(b: Bundle = Bundle.EMPTY) {
    startActivity(intentFor<T>(b))
}
