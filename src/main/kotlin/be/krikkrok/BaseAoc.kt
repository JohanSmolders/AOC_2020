package be.krikkrok

import java.io.Reader
import java.net.URL
import java.util.*
import kotlin.collections.ArrayList

abstract class BaseAoc {
    fun asReader(location: String): Reader = BaseAoc::class.java.getResourceAsStream(location).reader()
    fun asResource(location: String): URL = BaseAoc::class.java.getResource(location)

    fun asStringList(location: String): ArrayList<String> {
        val linkedList = ArrayList<String>()
        asReader(location).forEachLine {
            linkedList.add(it)
        }
        return linkedList
    }

    fun asIntList(location: String) = asStringList(location).map { it.toInt() }
}