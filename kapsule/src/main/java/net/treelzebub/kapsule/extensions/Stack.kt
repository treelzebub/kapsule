package net.treelzebub.kapsule.extensions

import java.util.*

/**
 * Created by Tre Murillo on 3/20/16
 */

fun <E> Stack<E>.safePeek(): E? {
    try {
        return peek()
    } catch (e: EmptyStackException) {
        return null
    }
}
