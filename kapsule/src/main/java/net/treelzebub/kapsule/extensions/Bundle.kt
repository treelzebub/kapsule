package net.treelzebub.kapsule.extensions

import android.os.Bundle
import java.io.Serializable

/**
 * Created by Tre Murillo on 3/19/16
 */

@Suppress("UNCHECKED_CAST")
fun <T : Serializable> Bundle.getSerializable(key: String): T {
    return getSerializable(key) as T
}
