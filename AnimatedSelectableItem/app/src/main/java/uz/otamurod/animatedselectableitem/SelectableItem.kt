package uz.otamurod.animatedselectableitem

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun SelectableItem(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    title: String,
    titleColor: Color = if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onSurface.copy(
        0.2f
    ),
    titleSize: TextUnit = MaterialTheme.typography.h6.fontSize,
    titleWeight: FontWeight = FontWeight.Medium,
    subTitle: String? = null,
    subTitleColor: Color = if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onSurface.copy(
        0.2f
    ),
    borderWidth: Dp = 1.dp,
    borderColor: Color = if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onSurface.copy(
        0.2f
    ),
    borderShape: Shape = RoundedCornerShape(10.dp),
    icon: ImageVector = Icons.Default.Check,
    iconColor: Color = if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onSurface.copy(
        0.2f
    ),
    onClick: () -> Unit
) {

    val scaleA = remember { Animatable(initialValue = 1f) }
    val scaleB = remember { Animatable(initialValue = 1f) }

    LaunchedEffect(key1 = isSelected) {
        if (isSelected) {
            launch {
                scaleA.animateTo(
                    targetValue = 0.3f,
                    animationSpec = tween(durationMillis = 50)
                )
                scaleA.animateTo(
                    targetValue = 1f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
            }

            launch {
                scaleB.animateTo(
                    targetValue = 0.9f,
                    animationSpec = tween(durationMillis = 50)
                )
                scaleB.animateTo(
                    targetValue = 1f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
            }
        }
    }

    Column(
        modifier = modifier
            .scale(scale = scaleB.value)
            .border(
                width = borderWidth,
                color = borderColor,
                shape = borderShape
            )
            .clip(borderShape)
            .clickable { onClick() }
    ) {
        Row(
            modifier = modifier.padding(start = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = modifier.weight(8f),
                text = title,
                style = TextStyle(
                    color = titleColor,
                    fontSize = titleSize,
                    fontWeight = titleWeight
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            IconButton(
                modifier = modifier
                    .weight(2f)
                    .scale(scale = scaleA.value),
                onClick = onClick
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Selectable Item Icon",
                    tint = iconColor
                )
            }
        }

        subTitle?.let {
            Text(
                modifier = modifier
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp),
                text = it,
                style = TextStyle(
                    color = subTitleColor,
                ),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(name = "SelectableItem")
@Composable
private fun PreviewSelectableItem() {
    var isSelected by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SelectableItem(
            isSelected = isSelected,
            title = "Lorem Ipsum",
            onClick = {
                isSelected = !isSelected
            }
        )
    }
}