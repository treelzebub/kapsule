package net.treelzebub.knapsack.sharedprefs

import android.content.SharedPreferences
import android.preference.PreferenceManager
import net.treelzebub.knapsack.extensions.TAG


object KPrefs {

    @Suppress("UNCHECKED_CAST")
    fun put(prefs: SharedPreferences, key: String, value: Any) {
        val editor = prefs.edit()
        when (value) {
            is Boolean -> editor.putBoolean(key, value)
            is String  -> editor.putString(key, value)
            is Int     -> editor.putInt(key, value)
            is Float   -> editor.putFloat(key, value)
            is Long    -> editor.putLong(key, value)
            is Set<*>  -> put(prefs, key, value)
            else -> throw IllegalArgumentException("$TAG: SharedPreferences only stores the following types: " +
                                                   "Boolean, String, Int, Float, Long, Set<String>.")
        }
        editor.apply()
    }

    inline fun <reified T : Any> get(prefs: SharedPreferences, key: String, default: T?): T {
        val retval = prefs.all[key] ?: return default ?: throw IllegalArgumentException()
        if (retval is T) {
            return retval
        } else {
            throw ClassCastException("$TAG: $key is not of type ${T::class.java.simpleName}")
        }
    }
}

