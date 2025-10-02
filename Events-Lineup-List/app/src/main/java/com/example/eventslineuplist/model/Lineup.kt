package com.example.eventslineuplist.model

import androidx.compose.ui.graphics.Color
import com.example.eventslineuplist.ui.theme.Lime
import com.example.eventslineuplist.ui.theme.Orange
import com.example.eventslineuplist.ui.theme.Pink

data class Lineup(
    val artist: String,
    val time: String
)

data class EventLineup(
    val stageName: String,
    val events: List<Lineup>,
    val color: Color
)

val stageAEvents = listOf<Lineup>(
    Lineup("Morning Bloom", "11:00"),
    Lineup("Synth River", "12:30"),
)

val stageBEvents = listOf<Lineup>(
    Lineup("The Suntones", "13:00"),
    Lineup("Blue Voltage", "14:15"),
    Lineup("Midnight Echo", "15:30")
)

val stageCEvents = listOf<Lineup>(
    Lineup("Echo Machine", "16:00"),
    Lineup("The 1975 ", "17:15")
)

val eventLineups = listOf<EventLineup>(
    EventLineup("Stage A", stageAEvents, Lime),
    EventLineup("Stage B", stageBEvents, Orange),
    EventLineup("Stage C", stageCEvents, Pink)
)
