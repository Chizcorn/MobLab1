package com.example.businesscard

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BusinessCardScreen() {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    val screenWidth = configuration.screenWidthDp.dp
    val isTablet = configuration.smallestScreenWidthDp >= 600

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars),
        color = MaterialTheme.colorScheme.background
    ) {
        // Динамические отступы
        val padding = when {
            isTablet -> 32.dp
            screenWidth > 400.dp -> 24.dp
            else -> 16.dp
        }

        if (isLandscape) {
            // Горизонтальная ориентация
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Первая карточка
                PersonalInfoCard(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(0.8f)
                )

                Spacer(modifier = Modifier.width(if (isTablet) 48.dp else 24.dp))

                // Вторая карточка
                ContactInfoCard(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(0.8f)
                )
            }
        } else {
            // Вертикальная ориентация
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                PersonalInfoCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )

                Spacer(modifier = Modifier.height(if (isTablet) 48.dp else 24.dp))

                ContactInfoCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
            }
        }
    }
}

@Composable
fun PersonalInfoCard(modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isLandscape) 12.dp else 8.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(if (isLandscape) 32.dp else 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Аватар
            val avatarSize = when {
                isLandscape -> 100.dp
                else -> 120.dp
            }

            Image(
                painter = painterResource(id = R.drawable.welder2),
                contentDescription = stringResource(R.string.full_name),
                modifier = Modifier
                    .size(avatarSize)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(if (isLandscape) 20.dp else 24.dp))

            // Имя
            Text(
                text = stringResource(R.string.full_name),
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                maxLines = 2
            )


            Spacer(modifier = Modifier.height(if (isLandscape) 16.dp else 20.dp))

            // Группа
            Text(
                text = stringResource(R.string.course),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                maxLines = 3
            )
        }
    }
}

@Composable
fun ContactInfoCard(modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isLandscape) 12.dp else 8.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(if (isLandscape) 32.dp else 24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            // Заголовок
            Text(
                text = stringResource(R.string.contact_info),
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 20.dp)
            )

            // Контакты
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                ContactItem(
                    icon = Icons.Default.Email,
                    text = stringResource(R.string.email)
                )

                ContactItem(
                    icon = Icons.Default.Phone,
                    text = stringResource(R.string.phone)
                )

                ContactItem(
                    icon = Icons.Default.Send,
                    text = stringResource(R.string.telegram)
                )
            }
        }
    }
}

@Composable
fun ContactItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    text: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(28.dp)
        )

        Spacer(modifier = Modifier.width(20.dp))

        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f),
            maxLines = 2
        )
    }
}

@Preview(showBackground = true, name = "Phone Portrait - English", locale = "en")
@Preview(showBackground = true, name = "Phone Portrait - Russian", locale = "ru")
@Preview(showBackground = true, name = "Phone Landscape - English",
    widthDp = 891, heightDp = 411, locale = "en")
@Preview(showBackground = true, name = "Phone Landscape - Russian",
    widthDp = 891, heightDp = 411, locale = "ru")
@Preview(showBackground = true, name = "Tablet Portrait - English",
    widthDp = 673, heightDp = 841, locale = "en")
@Preview(showBackground = true, name = "Tablet Portrait - Russian",
    widthDp = 673, heightDp = 841, locale = "ru")
@Preview(showBackground = true, name = "Tablet Landscape - English",
    widthDp = 841, heightDp = 673, locale = "en")
@Preview(showBackground = true, name = "Tablet Landscape - Russian",
    widthDp = 841, heightDp = 673, locale = "ru")
@Composable
fun PreviewBusinessCard() {
    MaterialTheme {
        BusinessCardScreen()
    }
}