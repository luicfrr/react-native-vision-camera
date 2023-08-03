package com.mrousavy.camera.utils

import android.util.Size
import android.view.Surface
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun Array<Size>.closestToOrMax(size: Size?): Size {
  return if (size != null) {
    this.minBy { abs(it.width - size.width) + abs(it.height - size.height) }
  } else {
    this.maxBy { it.width * it.height }
  }
}

/**
 * Rotate by a given Surface Rotation
 */
fun Size.rotated(surfaceRotation: Int): Size {
  return when (surfaceRotation) {
    Surface.ROTATION_0 -> Size(width, height)
    Surface.ROTATION_90 -> Size(height, width)
    Surface.ROTATION_180 -> Size(width, height)
    Surface.ROTATION_270 -> Size(height, width)
    else -> Size(width, height)
  }
}

val Size.bigger: Int
  get() = max(width, height)
val Size.smaller: Int
  get() = min(width, height)

operator fun Size.compareTo(other: Size): Int {
  return (this.width * this.height).compareTo(other.width * other.height)
}