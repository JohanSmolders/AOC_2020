package be.krikkrok

import java.io.Reader
import java.net.URL

abstract class BaseAoc {
    fun asReader(location: String): Reader = BaseAoc::class.java.getResourceAsStream(location).reader()
    fun asResource(location: String): URL = BaseAoc::class.java.getResource(location)
}