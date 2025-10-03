package com.example.ticketbuilder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.ticketbuilder.model.ticketTypes
import com.example.ticketbuilder.ui.theme.Lime
import com.example.ticketbuilder.ui.theme.ParkinsansFontFamily
import com.example.ticketbuilder.ui.theme.Surface
import com.example.ticketbuilder.ui.theme.SurfaceHigher
import com.example.ticketbuilder.ui.theme.TextPrimary
import com.example.ticketbuilder.ui.theme.TextSecondary
import com.example.ticketbuilder.ui.theme.TicketBuilderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TicketBuilderTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Surface)
                ) { innerPadding ->
                    TicketBuilderScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TicketBuilderScreen(modifier: Modifier = Modifier) {
    var currentlySelected by remember { mutableStateOf(-1) }
    var quantity by remember { mutableStateOf(1) }
    Column(modifier) {
        Text(
            text = "Ticket Builder",
            fontSize = 60.sp,
            fontFamily = ParkinsansFontFamily,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 1.em,
            color = TextPrimary,
            modifier = Modifier
                .padding(top = 10.dp)
                .padding(horizontal = 16.dp)
        )
        Text(
            text = "Select Ticket Type & Quantity",
            fontSize = 20.sp,
            fontFamily = ParkinsansFontFamily,
            fontWeight = FontWeight.Normal,
            color = TextSecondary,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Column(
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxSize()
                .background(SurfaceHigher)
        ) {
            Text(
                text = "TICKET TYPE:",
                fontSize = 20.sp,
                fontFamily = ParkinsansFontFamily,
                fontWeight = FontWeight.Medium,
                color = TextSecondary,
                modifier = Modifier
                    .padding(top = 15.dp, bottom = 5.dp)
                    .padding(horizontal = 15.dp)
            )
            ticketTypes.forEachIndexed { index, ticketType ->
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 15.dp)
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        RadioButton(
                            selected = currentlySelected == index,
                            onClick = { currentlySelected = index },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = TextPrimary,
                                unselectedColor = TextPrimary
                            ),
                            modifier = Modifier
                                .border(width = 2.dp, color = TextPrimary, shape = CircleShape)
                                .size(24.dp),

                            )
                        Text(
                            text = ticketType.type,
                            fontSize = 24.sp,
                            fontFamily = ParkinsansFontFamily,
                            fontWeight = FontWeight.Medium,
                            color = TextPrimary,
                        )
                    }
                    Text(
                        text = "$${ticketType.price}",
                        fontSize = 24.sp,
                        fontFamily = ParkinsansFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = TextPrimary,
                    )
                }
            }
            Text(
                text = "QUANTITY:",
                fontSize = 20.sp,
                fontFamily = ParkinsansFontFamily,
                fontWeight = FontWeight.Medium,
                color = TextSecondary,
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .padding(top = 25.dp)
            )

            Row(
                modifier = Modifier
                    .padding(horizontal = 15.dp).fillMaxWidth().padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier
                        .clickable(enabled = quantity > 1) { quantity-- }
                        .background(
                            if (quantity == 1) SurfaceHigher else Surface,
                            shape = RoundedCornerShape(12.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_minus),
                        contentDescription = "Minus Icon",
                        tint = TextPrimary,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                Text(
                    text = quantity.toString(),
                    fontSize = 32.sp,
                    fontFamily = ParkinsansFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = TextPrimary,
                )
                Box(
                    modifier = Modifier
                        .clickable { quantity++ }
                        .background(
                            Surface,
                            shape = RoundedCornerShape(12.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_plus),
                        contentDescription = "Minus Icon",
                        tint = TextPrimary,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }

            HorizontalDivider(
                color = TextPrimary,
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 30.dp, bottom = 20.dp, start = 15.dp, end = 15.dp),
                thickness = 1.dp
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Total:",
                    fontSize = 28.sp,
                    fontFamily = ParkinsansFontFamily,
                    fontWeight = FontWeight.Medium,
                    color = TextPrimary,
                )
                Text(
                    text = "$${if (currentlySelected == -1) 0 else quantity * ticketTypes[currentlySelected].price}",
                    fontSize = 28.sp,
                    fontFamily = ParkinsansFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = TextPrimary,
                )
            }

            Button(
                onClick = { },
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(12.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(2.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (currentlySelected == -1) SurfaceHigher else Lime
                )
            ) {
                Text(
                    text = "Purchase",
                    fontSize = 30.sp,
                    fontFamily = ParkinsansFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = TextPrimary,
                    modifier = Modifier.padding(5.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TicketBuilderScreenPreview() {
    TicketBuilderTheme {
        TicketBuilderScreen()
    }
}