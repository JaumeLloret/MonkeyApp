package com.jle.monkeyfilmapp.register.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.jle.monkeyfilmapp.R
import com.jle.monkeyfilmapp.ui.theme.*

@Composable
fun RegisterScreen(viewModel: RegisterViewModel, navigationController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)

        if (isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
            ) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        } else {
            Column(
                Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
                    .padding(horizontal = 5.dp)
            ) {
                Header(
                    Modifier
                        .align(Alignment.CenterHorizontally)
                        .weight(0.3f)
                )
                Body(Modifier.weight(0.6f), viewModel)
                Footer(Modifier.weight(0.1f), navigationController)
            }
        }
    }
}

@Composable
fun Footer(modifier: Modifier, navigationController: NavHostController) {
    Column(modifier = modifier.fillMaxWidth()) {
        Divider(
            Modifier
                .background(SecondaryWhite)
                .height(1.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(24.dp))
        SignIn(navigationController)
        Spacer(modifier = Modifier.size(24.dp))
    }
}

@Composable
fun SignIn(navigationController: NavHostController) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            text = stringResource(id = R.string.sign_in_question),
            fontSize = 12.sp,
            color = SecondaryGrey
        )
        Text(
            text = stringResource(id = R.string.sign_in),
            Modifier
                .padding(horizontal = 8.dp)
                .clickable { navigationController.popBackStack() },
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = PrimaryPurple,
        )
    }
}

@Composable
fun Body(modifier: Modifier, viewModel: RegisterViewModel) {
    val name: String by viewModel.name.observeAsState(initial = "")
    val surname: String by viewModel.surname.observeAsState(initial = "")
    val birthdate: String by viewModel.birthdate.observeAsState(initial = "")
    val genre: String by viewModel.genre.observeAsState(initial = "")
    val email: String by viewModel.email.observeAsState(initial = "")
    val phone: String by viewModel.phone.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val confirmPassword: String by viewModel.confirmPassword.observeAsState(initial = "")
    val isLoginEnable: Boolean by viewModel.isLoginEnable.observeAsState(initial = false)

    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        InputText(
            value = name,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            placeholder = { Text(text = stringResource(id = R.string.name)) }
        ) {
            viewModel.onRegisterChanged(
                name = it,
                surname = surname,
                phone = phone,
                genre = genre,
                email = email,
                birthdate = birthdate,
                password = password,
                confirmPassword = confirmPassword
            )
        }
        Spacer(modifier = Modifier.size(4.dp))
        InputText(
            value = surname,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            placeholder = { Text(text = stringResource(id = R.string.surname)) }
        ) {
            viewModel.onRegisterChanged(
                name = name,
                surname = it,
                phone = phone,
                genre = genre,
                email = email,
                birthdate = birthdate,
                password = password,
                confirmPassword = confirmPassword
            )
        }
        Spacer(modifier = Modifier.size(4.dp))
        InputText(
            value = email,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            placeholder = { Text(text = stringResource(id = R.string.email)) }
        ) {
            viewModel.onRegisterChanged(
                name = name,
                surname = surname,
                phone = phone,
                genre = genre,
                email = it,
                birthdate = birthdate,
                password = password,
                confirmPassword = confirmPassword
            )
        }
        Spacer(modifier = Modifier.size(4.dp))
        InputText(
            value = phone,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            placeholder = { Text(text = stringResource(id = R.string.phone)) }
        ) {
            viewModel.onRegisterChanged(
                name = name,
                surname = surname,
                phone = it,
                genre = genre,
                email = email,
                birthdate = birthdate,
                password = password,
                confirmPassword = confirmPassword
            )
        }
        Spacer(modifier = Modifier.size(4.dp))
        InputText(
            value = birthdate,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            placeholder = { Text(text = stringResource(id = R.string.birthdate)) }
        ) {
            viewModel.onRegisterChanged(
                name = name,
                surname = surname,
                phone = phone,
                genre = genre,
                email = email,
                birthdate = it,
                password = password,
                confirmPassword = confirmPassword
            )
        }
        Spacer(modifier = Modifier.size(4.dp))
        InputText(
            value = genre,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            placeholder = { Text(text = stringResource(id = R.string.genre)) }
        ) {
            viewModel.onRegisterChanged(
                name = name,
                surname = surname,
                phone = phone,
                genre = it,
                email = email,
                birthdate = birthdate,
                password = password,
                confirmPassword = confirmPassword
            )
        }
        Spacer(modifier = Modifier.size(4.dp))
        Password(
            value = password,
            placeholder = { Text(stringResource(id = R.string.password)) }
        ) {
            viewModel.onRegisterChanged(
                name = name,
                surname = surname,
                phone = phone,
                genre = genre,
                email = email,
                birthdate = birthdate,
                password = it,
                confirmPassword = confirmPassword
            )
        }
        Spacer(modifier = Modifier.size(4.dp))
        Password(
            value = confirmPassword,
            placeholder = { Text(stringResource(id = R.string.confirm_password)) }
        ) {
            viewModel.onRegisterChanged(
                name = name,
                surname = surname,
                phone = phone,
                genre = genre,
                email = email,
                birthdate = birthdate,
                password = password,
                confirmPassword = it
            )
        }
        Spacer(modifier = Modifier.size(16.dp))
        RegisterButton(isLoginEnable, viewModel)
    }
}

@Composable
fun RegisterButton(loginEnable: Boolean, loginViewModel: RegisterViewModel) {
    Button(
        onClick = { loginViewModel.onRegisterClick() },
        enabled = loginEnable,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = PrimaryPurple,
            disabledBackgroundColor = SecondaryPurple,
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) {
        Text(text = stringResource(id = R.string.register))
    }
}


@Composable
fun Password(
    value: String,
    placeholder: @Composable (() -> Unit)?,
    onTextChanged: (String) -> Unit
) {
    var passwordVisibility by remember { mutableStateOf(false) }
    TextField(
        value = value,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = placeholder,
        colors = TextFieldDefaults.textFieldColors(
            textColor = PrimaryGrey,
            backgroundColor = PrimaryWhite,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisibility) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(
                    imageVector = image,
                    contentDescription = stringResource(id = R.string.show_password)
                )
            }
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}

@Composable
fun InputText(
    value: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    placeholder: @Composable (() -> Unit)?,
    onTextChanged: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = placeholder,
        maxLines = 1,
        singleLine = true,
        keyboardOptions = keyboardOptions,
        colors = TextFieldDefaults.textFieldColors(
            textColor = PrimaryGrey,
            backgroundColor = PrimaryWhite,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}


@Composable
fun ImageLogo(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = stringResource(id = R.string.logo),
        modifier = modifier
    )
}

@Composable
fun Header(modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.app_title),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 30.sp
        )
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        Text(
            text = stringResource(id = R.string.register_title),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.size(16.dp))
    }
}
