package com.example.eventslineuplist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.eventslineuplist.model.eventLineups
import com.example.eventslineuplist.ui.theme.EventsLineupListTheme
import com.example.eventslineuplist.ui.theme.ParkinsansFontFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EventsLineupListTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                        .background(MaterialTheme.colorScheme.surface),
                ) { innerPadding ->
                    EventsScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun EventsScreen(modifier: Modifier) {
    var lineupsExpanded = remember {
        listOf(
            mutableStateOf(false),
            mutableStateOf(false),
            mutableStateOf(false)
        )
    }

    Column(modifier = modifier.padding(horizontal = 5.dp)) {
        Text(
            text = "Festival Lineup",
            fontSize = 60.sp,
            lineHeight = 1.em,
            modifier = Modifier.padding(horizontal = 10.dp),
            fontFamily = ParkinsansFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary,
        )
        Text(
            text = "Tap a stage to view performers",
            fontSize = 20.sp,
            fontFamily = ParkinsansFontFamily,
            modifier = Modifier.padding(horizontal = 10.dp),
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.colorScheme.secondary,
        )
        eventLineups.forEachIndexed { index, eventLineup ->
            Card(
                modifier = Modifier.padding(top = if (index == 0) 15.dp else 5.dp).fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = eventLineup.color),
                onClick = {
                    lineupsExpanded[index].value = !lineupsExpanded[index].value
                }
            ) {
                Column {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = eventLineup.stageName,
                            fontSize = 38.sp,
                            lineHeight = 1.em,
                            fontFamily = ParkinsansFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.primary,
                        )
                        Icon(
                            painter = if (lineupsExpanded[index].value) painterResource(
                                R.drawable.minus
                            ) else painterResource(R.drawable.plus),
                            contentDescription = if (lineupsExpanded[index].value) "collapse" else "expand",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(38.dp)
                        )
                    }
                    AnimatedVisibility(
                        visible = lineupsExpanded[index].value,
                        enter = expandVertically(),
                        exit = shrinkVertically()
                    ) {
                        Column {
                            eventLineup.events.forEachIndexed { index, lineup ->
                                Row(
                                    modifier = Modifier.padding(15.dp).fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = lineup.artist,
                                        fontSize = 24.sp,
                                        lineHeight = 1.em,
                                        fontFamily = ParkinsansFontFamily,
                                        fontWeight = FontWeight.SemiBold,
                                        color = MaterialTheme.colorScheme.primary,
                                    )
                                    Text(
                                        text = lineup.time,
                                        fontSize = 24.sp,
                                        lineHeight = 1.em,
                                        fontFamily = ParkinsansFontFamily,
                                        fontWeight = FontWeight.SemiBold,
                                        color = MaterialTheme.colorScheme.primary,
                                    )
                                }
                                if (index != eventLineup.events.lastIndex) {
                                    HorizontalDivider(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 10.dp, horizontal = 15.dp),
                                        thickness = 1.dp, color = MaterialTheme.colorScheme.primary,
                                    )
                                } else {
                                    Spacer(
                                        modifier = Modifier.height(10.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EventsLineupListTheme {
        EventsScreen(modifier = Modifier)
    }
}