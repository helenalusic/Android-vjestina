package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf


@Composable
fun FavoriteButton(
    isFavorite: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    var isFavorite by rememberSaveable { mutableStateOf(true) }

    Image(
        painter = painterResource(
            id = if (isFavorite) R.drawable.favorite_heart_filled else R.drawable.favorite_heart_outlined
        ),
        contentDescription = null,

        modifier = Modifier
            .clickable { isFavorite = !isFavorite }
            .size(32.dp)
            .background(color = Color.Blue, shape = CircleShape)
            .padding(5.dp),
        contentScale = ContentScale.Crop
    )

}

@Preview(showBackground = true)
@Composable
fun FavoriteButtonPreview() {
    var isFavorite by remember { mutableStateOf(true) }
    FavoriteButton(
        isFavorite = isFavorite,
        onClick = { isFavorite = !isFavorite }
    )
}
