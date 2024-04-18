package com.example.composebusinesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebusinesscardapp.ui.theme.ComposeBusinessCardAppTheme
import com.example.composebusinesscardapp.ui.theme.Pink40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeBusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun ComposeBusinessCardApp(
    modifier: Modifier = Modifier
) {
    Column {
        Row(
            verticalAlignment =  Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .background(Color(0xFFB7E0A0))
                .weight(2f)
        ) {
            ComposeNameCard(
                name = stringResource(R.string.full_name),
                title = stringResource(R.string.job_title),
                imagePainter = painterResource(R.drawable.android_logo)
            )
        }
        Row(
            verticalAlignment =  Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .background(Color(0xFFB7E0A0))
                .weight(1f)
        ) {
            ComposeInfoCard(
                number = stringResource(R.string.phone_number),
                handle = stringResource(R.string.handle),
                email = stringResource(R.string.email)
            )
        }
    }
}

@Composable
fun ComposeNameCard(
    name: String,
    title: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier
) {
    Column(
    modifier = modifier
        .fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = imagePainter,
            contentDescription = "android logo",
            modifier = Modifier
                .background(Color(0xFF011742))
                .size(80.dp)
        )
        Text(
            text = name,
            fontWeight = FontWeight.Light,
            fontSize = 32.sp
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 10.sp,
            color = Color(0xFF2D7C02),
            modifier = Modifier
                .padding(top = 5.dp)
        )
    }
}

@Composable
fun ComposeInfoCard(
    number: String,
    handle: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = modifier

        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Image(
                    painter = painterResource(R.drawable.baseline_call_black_24dp),
                    contentDescription ="phone icon",
                    modifier = Modifier
                        .size(18.dp)
                )
            }
            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = number,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Left
                )
            }
        }

        Row {
            Column(
                modifier = modifier,
            ) {
                Image(
                    painter = painterResource(R.drawable.baseline_share_black_24dp),
                    contentDescription ="handle icon",
                    modifier = Modifier
                        .size(18.dp)
                )
            }
            Column(
                modifier = modifier,
            ) {
                Text(
                    text = handle,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Left
                )
            }
        }

        Row {
            Column(
                modifier = modifier,
            ) {
                Image(
                    painter = painterResource(R.drawable.baseline_email_black_24dp),
                    contentDescription ="email icon",
                    modifier = Modifier
                        .size(18.dp)
                )
            }
            Column(
                modifier = modifier,
            ) {
                Text(
                    text = email,
                    fontSize = 10.sp,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeBusinessCardAppTheme {
        ComposeBusinessCardApp()
    }
}