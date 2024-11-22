package de.zelkulon.timezelkulon.model

import java.time.DayOfWeek

data class Infocard (
    val label: String,
    val day: Enum<DayOfWeek>,
    val timeframe: String,
    val prioPointa: Int,
)