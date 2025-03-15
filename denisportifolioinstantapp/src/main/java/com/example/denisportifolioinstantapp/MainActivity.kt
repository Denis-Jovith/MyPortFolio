package com.example.denisportifolioinstantapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.denis_jovitus_buberwa_portifolio_app.R
import com.example.denisportifolioinstantapp.ui.theme.Denis_Jovitus_Buberwa_Portifolio_AppTheme
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player

import com.google.android.exoplayer2.ui.StyledPlayerView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Denis_Jovitus_Buberwa_Portifolio_AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val colorList = listOf(Color(0xFF421fdf), Color(0xFF0c22de))
    val stateCross by rememberSaveable { mutableStateOf(true) }
    val state = rememberScrollState()
    val state1 = rememberScrollState()
    val state2 = rememberScrollState()
    val state3 = rememberScrollState()
    val state4 = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }
    val constraint = myConstraintSet()
    val context = LocalContext.current
    val displayMetrics = context.resources.displayMetrics

    // Height Of Screen
    val height = LocalConfiguration.current.screenHeightDp.dp - 80.dp

    ConstraintLayout(
        constraint
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(brush = Brush.linearGradient(colorList))
                .paint(
                    painterResource(id = R.drawable.desenho),
                    contentScale = ContentScale.FillBounds
                ),
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(height)
                    .verticalScroll(state)
                    .layoutId("scrollId"),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Content(
                    constraint = constraint,
                    modifier = Modifier,
                    stateCross,
                    state1,
                    state2,
                    state3,
                    state4
                )
            }
            ContactBottom(constraint, context)
        }
    }
}


@Composable
private fun Content(
    constraint: ConstraintSet,
    modifier: Modifier,
    state: Boolean,
    state1: ScrollState,
    state2: ScrollState,
    state3: ScrollState,
    state4: ScrollState
) {
    Header(constraint, modifier)
    ContentBody(constraint, modifier)
    ContentBodyProjectWeb(constraint, modifier, state, state2)
    ContentBodyProjectMobile(constraint, modifier, state, state1)
    ContentBodyBlenderProject(constraint, modifier, state3, state4)
}

@Composable
private fun Header(constraint: ConstraintSet, modifier: Modifier) {
    ConstraintLayout(
        constraint,
        modifier = Modifier
            .fillMaxWidth()
            .height(intrinsicSize = IntrinsicSize.Min)
            .layoutId("header")
    ) {
        Image(
            painter = painterResource(id = R.drawable.denisjb),
            contentDescription = stringResource(id = R.string.perfil),
            modifier
                .width(140.dp)
                .height(140.dp)
                .clip(CircleShape)
                .layoutId("imagePerfil")
        )

        TitleText(text = "Denis Jovitus Buberwa", modifier.layoutId("titleText"))
    }
}

@Composable
private fun ContentBody(constraint: ConstraintSet, modifier: Modifier) {
    ConstraintLayout(
        constraint
    ) {
        Box(
            modifier
                .height(intrinsicSize = IntrinsicSize.Min)
                .fillMaxWidth()
                .layoutId("contentBody"),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TitleText(text = "About Me", modifier = Modifier.layoutId("contentBodyTitleText"))

                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = ParagraphStyle(
                                textAlign = TextAlign.Justify,
                                textMotion = TextMotion.Animated,
                                textDirection = TextDirection.Content
                            )
                        ) {
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 20.sp,
                                    color = Color(0xFFFFFFFF),
                                )
                            ) {
                                append("Hey, welcome! I am Denis Buberwa. As a Full-Stack Developer, I specialize in Android development using Kotlin and Jetpack Compose. " +
                                        "I also work on web development with Kotlin, Ktor, and Kotlin Multiplatform.\n\n" +
                                        "I have a strong interest in cybersecurity. I am passionate about cybersecurity, ethical hacking, and programming. " +
                                        "I'm also interested in graphics design, particularly using Blender, and in mobile & web development.\n\n" +
                                        "In my projects, I use various programming languages. I enjoy building Android apps with Kotlin, Ktor, and Kotlin Multiplatform Mobile (KMM) with Clean Architecture."
                                )



                            }
                        }
                    },
                    modifier
                        .padding(12.dp)
                        .layoutId("contentBodyText")
                )
            }
        }

    }
}

@Composable
private fun ContentBodyProjectWeb(
    constraint: ConstraintSet,
    modifier: Modifier,
    state: Boolean,
    state2: ScrollState) {
    val wApps: MutableList<Int> = arrayListOf(
        R.drawable.my_first_website_html,
        R.drawable.class_attendance_java,
        R.drawable.c_projects_c,
        R.drawable.note_app_kmm,
        R.drawable.tip_calculator_kotlin,
        R.drawable.java_projects
    )
    ConstraintLayout(
        constraint
    ) {

        Box(
            modifier
                .fillMaxWidth()
                .height(intrinsicSize = IntrinsicSize.Min)
                .layoutId("contentBodyProjectWeb")
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                TitleText(text = "Web Project", modifier = Modifier.layoutId("contentBodyPWTitle"))

                Row(
                    modifier.horizontalScroll(state2)
                ) {
                    ImageProject(state = state, images = wApps)
                }
            }

        }
    }
}

@SuppressLint("UnusedCrossroadTargetStateParameter")
@Composable
private fun ContentBodyProjectMobile(
    constraint: ConstraintSet,
    modifier: Modifier,
    state: Boolean,
    state1: ScrollState
) {
    val mApps: MutableList<Int> = arrayListOf(
        R.drawable.tip_calculator_kotlin,
        R.drawable.myportifolio_kotlin,
        R.drawable.note_app_kmm,
        R.drawable.commercial_ads_app_kotlin,
        R.drawable.myportifolio_kotlin
    )
    ConstraintLayout(
        constraint
    ) {

        Box(
            modifier
                .fillMaxWidth()
                .height(intrinsicSize = IntrinsicSize.Min)
                .layoutId("contentBodyProjectMobile")
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                TitleText(
                    text = "Mobile Project",
                    modifier = Modifier.layoutId("contentBodyPMTitle")
                )
                Row(
                    modifier.horizontalScroll(state1)
                ) {
                    ImageProject(state = state, images = mApps)
                }
            }
        }
    }
}

@SuppressLint("UnusedCrossfadeTargetStateParameter")
@Composable
private fun ContentBodyBlenderProject(
    constraint: ConstraintSet,
    modifier: Modifier,
    imageScrollState: ScrollState,
    videoScrollState: ScrollState
)
{
    val images = listOf(
        R.drawable.chaipic,
        R.drawable.pic3,

    )

    val videos = listOf(
        R.raw.deniscarblender, // Replace with actual raw video files
        R.raw.deniscarblenda
    )

    ConstraintLayout(constraint) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TitleText(text = "Mobile Project", modifier = Modifier.layoutId("contentBodyPMTitle"))

            // Videos - Horizontal Scroll
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(videoScrollState)
            ) {
                videos.forEach { videoRes ->
                    VideoPlayerFromRaw(videoRes)
                }
            }

            // Images - Horizontal Scroll
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(imageScrollState)
            ) {
                images.forEach { imageRes ->
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = "Project Image",
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                            .height(200.dp) // Adjust height as needed
                    )
                }
            }
        }
    }
}

@Composable
fun VideoPlayerFromRaw(videoRes: Int) {
    val context = LocalContext.current
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            val uri = Uri.parse("android.resource://${context.packageName}/raw/deniscarblenda")
            setMediaItem(MediaItem.fromUri(uri))
            repeatMode = Player.REPEAT_MODE_ONE // Loop the video
            prepare()
            play()
        }
    }

    var volume by remember { mutableStateOf(0.5f) } // Start with medium volume

    DisposableEffect(Unit) {
        onDispose { exoPlayer.release() }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        AndroidView(
            factory = { StyledPlayerView(it).apply { player = exoPlayer } },
            modifier = Modifier.fillMaxWidth()
        )

        // Volume Control Slider
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(8.dp)
                .background(Color.Black.copy(alpha = 0.6f), RoundedCornerShape(8.dp))
                .padding(8.dp)
        ) {
            Text(text = "Volume", color = Color.White, fontSize = 12.sp)
            Slider(
                value = volume,
                onValueChange = {
                    volume = it
                    exoPlayer.volume = it
                },
                valueRange = 0f..1f,
                colors = SliderDefaults.colors(thumbColor = Color.White)
            )
        }
    }
}





@Composable
private fun ImageProject(state: Boolean, images: MutableList<Int>) {
    for (i in images) {
        Image(
            painter = painterResource(i),
            contentDescription = "Mobile Apps",
            Modifier
                .size(400.dp)
                .padding(20.dp)
        )
    }

}

@Composable
private fun TitleText(text: String, modifier: Modifier) {
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color(0xFFFFFFFF),
                )
            ) {
                append(text)
            }
        },
        modifier
    )
}

@Composable
private fun ContactBottom(constraint: ConstraintSet, context: Context) {
    val sendEmail = {
        val share = Intent.createChooser(Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_EMAIL, arrayOf("denisjovitusbuberwa@gmail.com"))
            putExtra(Intent.EXTRA_SUBJECT, "Hey, I came from your portfolio")
            type = "text/plain"
        }, null)
        context.startActivity(share)
    }

    val clickGit = {
        context.startActivity(
            Intent(Intent.ACTION_VIEW).also {
                it.data = Uri.parse("https://github.com/Denis-Jovith")
            }
        )
    }

    val clickLinkedin = {
        context.startActivity(
            Intent(Intent.ACTION_VIEW).also {
                it.data = Uri.parse("https://www.linkedin.com/in/denis-buberwa-555b09258/")
            }
        )
    }


    ConstraintLayout(
        constraint,
    ) {
        Box(
            Modifier.layoutId("contentContact")
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .border(
                        border = BorderStroke(2.dp, Color(0xFF6B8E23)),
                        shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)
                    ),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageButton(
                    id = R.drawable.baseline_computer_24,
                    desc = "githubButton",
                    btnName = "GitHub",
                    clickGit,
                    constraint
                )

                Divider(
                    color = Color(0xFF6B8E23), // Olive Green
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(2.dp)
                )

                ImageButton(
                    id = R.drawable.baseline_person_24,
                    desc = "linkedinButton",
                    btnName = "Linkedin",
                    clickLinkedin,
                    constraint
                )

                Divider(
                    color = Color(0xFF6B8E23), // Olive Green
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(2.dp)
                )

                ImageButton(
                    id = R.drawable.baseline_sms_24,
                    desc = "emailbButton",
                    btnName = "Email",
                    sendEmail,
                    constraint
                )
            }
        }
    }
}




@Composable
private fun ImageButton(
    id: Int,
    desc: String,
    btnName: String,
    onClick: () -> Unit,
    constraint: ConstraintSet
) {
    ConstraintLayout(
        constraint
    ) {
        Button(
            onClick = { onClick() },
            Modifier
                .padding(horizontal = 14.dp)
                .layoutId("contentButonContact"),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4FA8A8), // Teal Blue
                contentColor = Color.Transparent
            ),
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = id),
                    contentDescription = desc,
                    Modifier.size(30.dp, 30.dp)
                )
                Text(
                    text = btnName,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFF1E7D0) // Soft Cream
                )
            }
        }
    }
}

private fun myConstraintSet(): ConstraintSet {
    return ConstraintSet {
        val imagePerfil = createRefFor("imagePerfil")
        val titleText = createRefFor("titleText")
        val contentBody = createRefFor("contentBody")
        val header = createRefFor("header")
        val contentBodyTitleText = createRefFor("contentBodyTitleText")
        val contentBodyText = createRefFor("contentBodyText")
        val contentContact = createRefFor("contentContact")
        val contentButonContact = createRefFor("contentButonContact")
        val scrollId = createRefFor("scrollId")
        val contentBodyProjectWeb = createRefFor("contentBodyProjectWeb")
        val contentBodyPWTitle = createRefFor("contentBodyPWTitle")
        val contentBodyProjectMobile = createRefFor("contentBodyProjectMobile")
        val contentBodyPMTitle = createRefFor("contentBodyPMTitle")

        constrain(scrollId) {
            top.linkTo(parent.top)
            centerHorizontallyTo(parent)
        }

        constrain(header) {
            top.linkTo(scrollId.top)
            centerHorizontallyTo(scrollId)
        }

        constrain(imagePerfil) {
            top.linkTo(parent.top, 20.dp)
            centerHorizontallyTo(parent)
        }

        constrain(titleText) {
            top.linkTo(imagePerfil.bottom, 20.dp)
            centerHorizontallyTo(scrollId)
        }

        constrain(contentBody) {
            top.linkTo(header.bottom, 40.dp)
        }

        constrain(contentBodyTitleText) {
            top.linkTo(parent.top, 20.dp)
            centerHorizontallyTo(contentBody)
        }

        constrain(contentBodyText) {
            top.linkTo(contentBodyTitleText.bottom, 20.dp)
        }

        constrain(contentContact) {
            top.linkTo(scrollId.bottom, 14.dp)
            bottom.linkTo(parent.bottom)
        }

        constrain(contentButonContact) {
            top.linkTo(parent.top)
        }

        constrain(contentBodyProjectWeb) {
            top.linkTo(contentBody.bottom)
            centerHorizontallyTo(parent)
        }

        constrain(contentBodyPWTitle) {
            top.linkTo(parent.top)
        }

        constrain(contentBodyProjectMobile) {
            top.linkTo(contentBodyProjectWeb.bottom)
            centerHorizontallyTo(parent)
        }

        constrain(contentBodyPMTitle) {
            top.linkTo(parent.top)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Denis_Jovitus_Buberwa_Portifolio_AppTheme {
        MainScreen()
    }
}




