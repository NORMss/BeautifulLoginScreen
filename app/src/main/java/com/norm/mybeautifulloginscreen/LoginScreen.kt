package com.norm.mybeautifulloginscreen

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LoginScreen(

) {
    val isImeVisible by rememberImeState()
    GradientBox(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val animatedUpperSectionRatio by animateFloatAsState(
                targetValue = if (isImeVisible) 0.15f else 0.35f,
                label = ""
            )
//            AnimatedVisibility(
//                visible = !isImeVisible,
//                enter = slideInVertically(),
//                exit = slideOutVertically()
//            ) {
//            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize()
                    .fillMaxHeight(animatedUpperSectionRatio),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Welcome to my application",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White,
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(
                        RoundedCornerShape(
                            topStart = 32.dp,
                            topEnd = 32.dp,
                        )
                    )
                    .background(
                        color = Color.White
                    )
            ) {
                if (isSmaleScreenHeight()) {
                    Spacer(modifier = Modifier.fillMaxSize(0.05f))
                } else {
                    Spacer(modifier = Modifier.fillMaxSize(0.1f))
                }
                MyTextField(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    label = "Username",
                    keyboardOptions = KeyboardOptions(),
                    keyboardActions = KeyboardActions(),
                )
                Spacer(modifier = Modifier.height(16.dp))
                MyTextField(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    label = "Password",
                    keyboardOptions = KeyboardOptions(),
                    keyboardActions = KeyboardActions(),
                    trailingIcon = Icons.Default.Lock,
                )
                if (isImeVisible) {
                    Button(
                        onClick = {

                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .padding(horizontal = 16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorCyan,
                            contentColor = Color.White,
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Log in",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight(500)
                            )
                        )
                    }
                } else {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Button(
                            onClick = {

                            },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorCyan,
                                contentColor = Color.White,
                            ),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(
                                text = "Log in",
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight(500)
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}