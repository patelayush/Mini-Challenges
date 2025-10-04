package com.example.festivalmap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.festivalmap.ui.theme.FestivalMapTheme
import com.example.festivalmap.ui.theme.Lime
import com.example.festivalmap.ui.theme.Orange
import com.example.festivalmap.ui.theme.ParkinsansFontFamily
import com.example.festivalmap.ui.theme.Pink
import com.example.festivalmap.ui.theme.Surface
import com.example.festivalmap.ui.theme.TextPrimary
import com.example.festivalmap.ui.theme.TextSecondary

data class Filter(
    val name: String,
    val filterImage: Int,
    val color: Color,
    val icon: Int,
    var selected: Boolean = false
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FestivalMapTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FestivalMap(Modifier.fillMaxSize().background(Surface).padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun FestivalMap(modifier: Modifier = Modifier) {
    val filterList = remember {
        mutableStateListOf<Filter>(
            Filter("Stages", R.drawable.stages, Lime, R.drawable.ic__stage),
            Filter("Food", R.drawable.food, Pink, R.drawable.ic_food),
            Filter("WC", R.drawable.wc, Orange, R.drawable.ic_wc)
        )
    }
    Column(modifier) {
        Text(
            text = "Festival Map",
            fontFamily = ParkinsansFontFamily,
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextPrimary,
            modifier = Modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp)
        )
        Row(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            filterList.forEachIndexed { index, filter ->
                FilterChip(
                    modifier = Modifier.wrapContentSize(),
                    selected = filter.selected,
                    onClick = {
                        filterList[index] = filterList[index].copy(
                            selected = !filterList[index].selected
                        )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = Surface,
                        selectedContainerColor = filter.color
                    ),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(filter.icon),
                            contentDescription = "",
                            modifier = Modifier.padding(start = 5.dp).size(16.dp),
                            tint = TextPrimary

                        )
                    },
                    shape = RoundedCornerShape(20.dp),
                    label = {
                        Text(
                            modifier = Modifier.padding(vertical = 5.dp),
                            text = filter.name,
                            color = if (filter.selected) TextPrimary else TextSecondary,
                            fontSize = 20.sp,
                            fontFamily = ParkinsansFontFamily,
                            fontWeight = FontWeight.Medium
                        )
                    }
                )
            }
        }
        HorizontalDivider(
            color = TextPrimary,
            modifier = Modifier.fillMaxWidth()
        )
        Box {
            Image(
                painter = painterResource(R.drawable.map),
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )
            if (filterList[0].selected) {
                Image(
                    painter = painterResource(R.drawable.stages),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
            }
            if (filterList[1].selected) {
                Image(
                    painter = painterResource(R.drawable.food),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
            }
            if (filterList[2].selected) {
                Image(
                    painter = painterResource(R.drawable.wc),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FestivalMapTheme {
        FestivalMap()
    }
}