package com.example.testassesment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

@Composable
fun LoginScreen() {
    showUI()
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun showUI() {
    var username by rememberSaveable { mutableStateOf("") }
    var isButtonEnabled by remember { mutableStateOf(false) }
    var isErrorShow by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.login_bg),
            contentDescription = "backgroun image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier.padding(40.dp, 180.dp), colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                )
            ) {
                Column(

                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Industried Own Food Delivry App",
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Divider(
                            thickness = 1.dp,
                            color = Color.Gray,
                            modifier = Modifier.weight(0.2f)
                        )
                        Text(
                            text = "Login or Sign up",
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold

                        )
                        Divider(
                            thickness = 1.dp,
                            color = Color.Gray,
                            modifier = Modifier.weight(0.2f)
                        )
                    }

                    OutlinedTextField(
                        value = username,
                        onValueChange = {
                            username = it
                            isButtonEnabled = true
                        },
                        label = { Text(text = "Phone No.") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        placeholder = { Text("Enter Phone Number here") },
                        maxLines=10, isError = isErrorShow
                    )

                    Button(
                        shape = RoundedCornerShape(10.dp),
                        onClick = {
                              if(username.isNotBlank()){
                                var callApiforLogin = CoroutineScope(Dispatchers.IO)
                                callApiforLogin.async {
                                }
                            }else{
                                isErrorShow=true
                            }

                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(Color.Blue),
                        enabled = isButtonEnabled
                    ) {
                        Text(text = "Sign In", color = Color.White)
                    }

                    Text(text = "or", modifier = Modifier.height(20.dp))

                    Button(
                        shape = RoundedCornerShape(10.dp),
                        onClick = { /*TODO*/ },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(Color.Red),

                        ) {

                        Text(text = "Skip", color = Color.White)
                    }

                }
            }
        }

    }

}

enum class ChangeState {
    InitialState,
    AfterState
}