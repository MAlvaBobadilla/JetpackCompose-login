package com.example.instagramlogin.screens.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramlogin.R

//@Preview(showSystemUi = true)
@Composable
fun LoginScreen(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Header(modifier = Modifier.align(Alignment.TopEnd))
        Body(modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun Body(modifier: Modifier) {

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    val commonModifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp)

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ImagenPrincipal()
        CommonSpacer(20)
        Usuario(
            modifier = commonModifier,
            textLabel = "Phone number, username or email",
            user = email,
            onvalueChange = { email = it })
        CommonSpacer(4)
        Password(
            modifier = commonModifier,
            textLabel = "Password",
            password = password,
            onvalueChange = { password = it })
        CommonSpacer(4)
        ForgotPassword(modifier = commonModifier, textLabel = "Forgot Password?")
        CommonSpacer(16)
        LoginButtom(modifier = commonModifier, textLabel = "Log In")
        CommonSpacer(16)
        LoginDivider(modifier = commonModifier, textLabel = "OR")
        CommonSpacer(32)
        SocialLogin(modifier = commonModifier, textLabel = "Continue as Marlon Alva", drawableSource = R.drawable.fb)
    }

}

@Composable
fun SocialLogin(modifier: Modifier, textLabel: String, drawableSource: Int) {
    Row (modifier = modifier, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
        Image(painter = painterResource(drawableSource), contentDescription = "Icono de Facebook", modifier = Modifier.size(16.dp))
        Text(textLabel, fontSize = 14.sp, fontWeight = FontWeight.Bold,modifier = Modifier.padding(horizontal = 8.dp), color = Color(0xFF4EA8E9))
    }
}

@Composable
fun LoginDivider(modifier: Modifier, textLabel: String) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        HorizontalDivider(
            modifier = Modifier
                .size(1.dp)
                .weight(1f)
        )
        Text(textLabel, modifier = Modifier.padding(horizontal = 18.dp), fontWeight = FontWeight.Bold, fontSize = 12.sp ,color = Color.Gray)
        HorizontalDivider(
            modifier = Modifier
                .size(1.dp)
                .weight(1f)
        )
    }
}

@Composable
fun LoginButtom(modifier: Modifier, textLabel: String) {
    Button(
        onClick = {},
        modifier = modifier,
        enabled = false,
        shape = RoundedCornerShape(4.dp),
        colors = ButtonColors(
            containerColor = Color(0XFF4EA8E9), disabledContainerColor = Color(0XFF4EA8E9),
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) { Text(textLabel) }
}

@Composable
fun CommonSpacer(space: Int) {
    Spacer(modifier = Modifier.size(space.dp))
}

@Composable
fun ForgotPassword(modifier: Modifier, textLabel: String) {
    Text(
        textLabel,
        color = Color(0XFF4EA8E9),
        textAlign = TextAlign.End,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        modifier = modifier
    )
}

@Composable
fun Password(
    modifier: Modifier,
    textLabel: String,
    password: String,
    onvalueChange: (String) -> Unit
) {

    var isShown by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        password,
        onValueChange = { onvalueChange(it) },
        label = { Text(textLabel) },
        modifier = modifier,
        visualTransformation = if (isShown) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            Icon(
                if (isShown) Icons.Rounded.FavoriteBorder else Icons.Default.Favorite,
                contentDescription = "",
                modifier = Modifier.clickable { isShown = !isShown }
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true
    )
}

@Composable
fun Usuario(modifier: Modifier, textLabel: String, user: String, onvalueChange: (String) -> Unit) {
    OutlinedTextField(
        user,
        onValueChange = { onvalueChange(it) },
        label = { Text(textLabel) },
        modifier = modifier,
        singleLine = true
    )
}

@Composable
fun ImagenPrincipal() {
    Image(
        painter = painterResource(R.drawable.insta),
        contentDescription = "Logo"
    )
}

@Composable
fun Header(modifier: Modifier) {

//    val activity = LocalContext.current as Activity

    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "Close",
        modifier = modifier
            .padding(8.dp)
            .clickable {
//                activity.finish()
                Log.i("Prueba", "Close")
            }
    )
}