package uz.otamurod.sharedelementtransition.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.skydoves.orbital.Orbital
import com.skydoves.orbital.animateBounds
import com.skydoves.orbital.rememberMovableContentOf
import uz.otamurod.sharedelementtransition.model.mountains

@Composable
fun ListScreen() {
    Orbital {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.surface)
        ) {
            items(items = mountains, key = { it.title }) { mountain ->
                var expanded by rememberSaveable { mutableStateOf(false) }
                AnimatedVisibility(
                    remember {
                        MutableTransitionState(false)
                    }.apply { targetState = true },
                    enter = fadeIn(tween(durationMillis = 300)),
                    exit = fadeOut(tween(durationMillis = 300))
                ) {
                    Orbital(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickableWithoutRipple(
                                interactionSource = MutableInteractionSource(),
                                onClick = { expanded = !expanded })
                    ) {
                        val text = rememberMovableContentOf {
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .padding(vertical = 10.dp)
                                    .padding(horizontal = if (expanded) 20.dp else 10.dp)
                                    .animateBounds(
                                        sizeAnimationSpec = tween(durationMillis = 300),
                                        positionAnimationSpec = tween(durationMillis = 300)
                                    )
                            ) {
                                Text(
                                    text = mountain.title,
                                    fontSize = MaterialTheme.typography.h6.fontSize,
                                    fontWeight = FontWeight.Medium,
                                    maxLines = if (expanded) 2 else 1,
                                    overflow = TextOverflow.Ellipsis,
                                    color = MaterialTheme.colors.onSurface
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = mountain.description,
                                    maxLines = if (expanded) 10 else 2,
                                    overflow = TextOverflow.Clip,
                                    color = MaterialTheme.colors.onSurface
                                )
                            }
                        }

                        val image = rememberMovableContentOf {
                            AsyncImage(
                                modifier = Modifier
                                    .padding(all = 10.dp)
                                    .animateBounds(
                                        modifier = if (expanded) {
                                            Modifier.fillMaxWidth()
                                        } else {
                                            Modifier.size(100.dp)
                                        },
                                        sizeAnimationSpec = tween(durationMillis = 300),
                                        positionAnimationSpec = tween(durationMillis = 300)
                                    )
                                    .clip(RoundedCornerShape(size = 10.dp)),
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(mountain.image)
                                    .crossfade(true)
                                    .build(),
                                contentDescription = "Mountain Image",
                                contentScale = ContentScale.Crop
                            )
                        }

                        if (expanded) {
                            Column(
                                modifier = Modifier
                                    .padding(all = 10.dp)
                                    .clip(RoundedCornerShape(size = 10.dp))
                                    .background(color = MaterialTheme.colors.surface)
                            ) {
                                image()
                                text()
                            }

                        } else {
                            Row {
                                image()
                                text()
                            }
                        }
                    }
                }
            }
        }
    }
}

fun Modifier.clickableWithoutRipple(
    interactionSource: MutableInteractionSource,
    onClick: () -> Unit
) = composed(
    factory = {
        this.then(
            Modifier.clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = { onClick() }
            )
        )
    }
)

@Preview(name = "ListScreen")
@Composable
private fun PreviewListScreen() {
    ListScreen()
}