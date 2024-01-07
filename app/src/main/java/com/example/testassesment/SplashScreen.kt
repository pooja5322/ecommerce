package com.example.testassesment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SplashScreen() {
    showSplash()
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun showSplash() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.weight(0.8f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.waayu_logo_one),
                contentDescription = null,
                modifier = Modifier
                    .width(180.dp)
                    .height(180.dp).padding(0.dp,20.dp,0.dp,0.dp), colorFilter = ColorFilter.tint(color = Color.Blue)
            )
        }

        Image(
            painter = painterResource(id = R.drawable.ic_aahar),
            contentDescription = "aahar logo",
            modifier = Modifier
                .height(100.dp)
                .weight(0.2f).padding(40.dp)
        )
    }


}

