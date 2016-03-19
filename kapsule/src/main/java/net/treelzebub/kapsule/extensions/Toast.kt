package net.treelzebub.kapsule.extensions

import android.content.Context
import android.support.annotation.StringRes
import android.widget.Toast

/**
 * Created by Tre Murillo on 3/19/16
 */

fun Toast.show(context: Context, text: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, text, length).show()
}

fun Toast.show(context: Context, @StringRes resId: Int, length: Int = Toast.LENGTH_SHORT ) {
    Toast.makeText(context, resId, length).show()
}
