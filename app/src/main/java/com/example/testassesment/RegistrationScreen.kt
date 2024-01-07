package com.example.testassesment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Registration() {
    showUI()
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun showUI() {
    val username = remember {
        mutableStateOf("")
    }
    val userEmail = remember {
        mutableStateOf("")
    }

    var uiState by remember {
        mutableStateOf(UiState.Initial)
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.login_bg),
            contentDescription = "lpginbackground",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(modifier = Modifier.fillMaxSize()) {
            Card(
                modifier = Modifier
                    .padding(40.dp, 100.dp), colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                )
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "Registration",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Complete your Registration ",
                        color = Color.Gray,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Light
                    )



                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text(text = "Name") },
                        placeholder = {
                            Text(
                                text = "Enter your name"
                            )
                        })

                    OutlinedTextField(
                        value = "",
                        singleLine = true,
                        onValueChange = {},
                        label = { Text(text = "Email") },
                        placeholder = {
                            Text(
                                text = "Enter your email"
                            )
                        })

                    when (uiState) {
                        UiState.Initial -> {

                        }

                        UiState.AfterButtonClick -> {
                            OutlinedTextField(
                                value = "",
                                singleLine = true,
                                onValueChange = {},
                                label = { Text(text = "Referral code") },
                                placeholder = {
                                    Text(
                                        text = "Enter code here"
                                    )
                                })
                        }
                    }

                    Button(
                        shape = RoundedCornerShape(10.dp),
                        onClick = { uiState = UiState.AfterButtonClick },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp, 0.dp, 10.dp, 0.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Red
                        )
                    ) {
                        Text(text = "Continue")
                    }

                    Row() {
                        Text(text = "Add a ")
                        Text(text = "Referral Code", color = Color.Magenta)
                    }


                }
            }
        }

    }
}

enum class UiState {
    Initial,
    AfterButtonClick
}