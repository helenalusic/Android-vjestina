package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.mock.MoviesMock
import agency.five.codebase.android.movieapp.R
import agency.five.codebase.android.movieapp.mock.MoviesMock.getActor
import agency.five.codebase.android.movieapp.model.Actor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest


data class ActorCardViewState(
    val imageUrl: String,
    val name: String,
    val character: String,
)
@Composable
fun ActorCard(
    actorCardViewState: Actor,
    modifier: Modifier = Modifier,
) {
    Card(
        backgroundColor = Color.White,
        shape = MaterialTheme.shapes.medium,
        modifier = modifier,
    ) {
        Box {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(actorCardViewState.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .height(dimensionResource(id = R.dimen.cast_member_image_height)),
            )
        }
        Box {
            Column {
                Box (
                    modifier = modifier
                        .height(150.dp)
                )
                Text(
                    text = actorCardViewState.name,
                    style = MaterialTheme.typography.h3,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.Serif,
                    color = Color.White,
                    modifier = modifier
                        .background(Color.Black.copy(0.7f))
                        .padding(start = 10.dp, top = 5.dp)
                        .width(140.dp)
                        .height(20.dp)
                )
                Text(
                    text = actorCardViewState.character,
                    style = MaterialTheme.typography.h4,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.Serif,
                    color = Color.White,
                    modifier = modifier
                        .background(Color.Black.copy(0.7f))
                        .padding(start = 10.dp)
                        .width(140.dp)
                        .height(25.dp)
                )
            }
        }
    }

}
@Preview
@Composable
private fun ActorCardPreview() {
    val actor = MoviesMock.getActor()
    val viewState = ActorCardViewState(actor.name, actor.character, actor.imageUrl.toString())

    ActorCard(actorCardViewState =MoviesMock.getActor())
}
