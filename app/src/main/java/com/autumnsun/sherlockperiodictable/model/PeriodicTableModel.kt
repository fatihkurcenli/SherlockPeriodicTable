package com.autumnsun.sherlockperiodictable.model

data class PeriodicTableModel(
    val id: Int? = null,
    val name: String? = null,
    val symbol: String? = null,
    val phase: String? = null,
    val cpkHex: String? = null,
    val spectralImage: String? = null,
    val summary: String? = null,
    val gone: Boolean = false
)