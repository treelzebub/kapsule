package net.treelzebub.kapsule.extensions

import android.os.Bundle

/**
 * Created by Tre Murillo on 3/19/16
 */

@Suppress("UNCHECKED_CAST")
fun <T> Bundle.getSerializable(key: String): T {
    return getSerializable(key) as T
}
