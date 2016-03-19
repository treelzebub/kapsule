package net.treelzebub.kapsule.extensions

import android.app.Activity
import android.content.Intent
import android.os.Bundle

/**
 * Created by Tre Murillo on 3/19/16
 */

inline fun <reified T : Activity> Activity.createIntent(b: Bundle = Bundle.EMPTY): Intent {
    return Intent(this, T::class.java).apply { putExtras(b) }
}

inline fun <reified T : Activity> Activity.startActivityWithExtras(b: Bundle = Bundle.EMPTY) {
    startActivity(createIntent<T>(b))
}
