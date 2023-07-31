package app

import scalafx.beans.property.IntegerProperty
import scalafx.beans.property.DoubleProperty

object Settings {
    val resolution_width = DoubleProperty(800)
    val resolution_height = DoubleProperty(600)
    val volume = DoubleProperty(1.0f)
}
