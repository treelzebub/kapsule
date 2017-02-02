package net.treelzebub.knapsack.extensions

import android.os.Bundle
import java.io.Serializable


@Suppress("UNCHECKED_CAST")
fun <T : Serializable> Bundle.getSerializable(key: String): T {
    return getSerializable(key) as T
}
