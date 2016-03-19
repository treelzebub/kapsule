package net.treelzebub.kapsule.utils

import android.content.SharedPreferences
import net.treelzebub.kapsule.extensions.TAG

/**
 * Created by Tre Murillo on 3/19/16
 */
object KPrefs {

    @Suppress("UNCHECKED_CAST")
    fun <T> put(prefs: SharedPreferences, key: String, value: T, commit: Boolean = false): Boolean {
        val editor = prefs.edit()
        when (value) {
            is Boolean -> {
                editor.putBoolean(key, value)
            }
            is String -> {
                editor.putString(key, value)
            }
            is Int -> {
                editor.putInt(key, value)
            }
            is Float -> {
                editor.putFloat(key, value)
            }
            is Long -> {
                editor.putLong(key, value)
            }
            is Set<*> -> {
                if (value.firstOrNull() is String) {
                    editor.putStringSet(key, value as Set<String>)
                } else {
                    throw IllegalArgumentException("$TAG: SharedPreferences Set must be Set<String>.")
                }
            }
            else -> {
                throw IllegalArgumentException("$TAG: SharedPreferences only stores the following types: " +
                        "Boolean, String, Int, Float, Long, Set<String>.")
            }
        }
        return if (commit) {
            editor.commit()
        } else {
            editor.apply()
            true
        }
    }

    inline fun <reified T : Any> get(prefs: SharedPreferences, key: String): T {
        val retval = prefs.all[key] ?: throw InvalidPrefKeyException("$TAG: $key not found in SharedPreferences.")
        if (retval is T) {
            return retval
        } else {
            throw ClassCastException("$TAG: $key is not of type ${T::class.java.simpleName}")
        }

    }

    class InvalidPrefKeyException(msg: String) : Throwable(msg)
}

