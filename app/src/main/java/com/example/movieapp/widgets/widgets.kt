package com.example.movieapp.widgets

import android.widget.ImageView
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.Model.Movie
import com.example.movieapp.Model.getMovies


@Composable
fun MovieRow(movie: Movie = getMovies()[0],


             onItemClick: (String) -> Unit)
{
    val expanded = remember {
        mutableStateOf(false)
    }
    Card (modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        //.height(130.dp)
        .clickable
        { onItemClick(movie.id) },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(6.dp)
    )
    {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        )
        {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
                shape = RectangleShape,
                shadowElevation = 4.dp
            )
            {
                GlideImageLoader(
                    imageScale = ImageView.ScaleType.FIT_XY,
                    url = movie.images[0],
                    //applyCircleCrop = true,
                    modifier = Modifier
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end=8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier
                    .padding(4.dp)
                    .weight(9f)) {
                    Text(
                        text = movie.title,
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Text(
                        text = "Director: ${movie.director}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Released: ${movie.year}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    AnimatedVisibility(visible = expanded.value)
                    {
                        Column() {
                            Text(
                                text = buildAnnotatedString{
                                    withStyle(
                                        style = SpanStyle(
                                            color = Color.DarkGray,
                                            fontSize = 13.sp
                                        )
                                    ) {
                                        append("Plot: ")
                                    }
                                    withStyle(
                                        style = SpanStyle(
                                            color = Color.DarkGray,
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.Light
                                        )
                                    ) {
                                        append(movie.plot)
                                    }
                                },
                                modifier = Modifier.padding(6.dp)
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(Color.Gray)
                                    .padding(3.dp)
                            )
                            Text(
                                text="Genre: ${movie.genre}",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Actors: ${movie.actors}",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Rating: ${movie.rating}",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.Bottom
                )
                {
                    Image(
                        imageVector =
                        if(expanded.value)
                            Icons.Filled.KeyboardArrowUp
                        else
                            Icons.Filled.ArrowDropDown
                            ,
                        contentDescription = "arrow down",
                        modifier = Modifier
                            .size(40.dp)
                            .clickable {
                                    expanded.value=!expanded.value
                            },
                        colorFilter = ColorFilter.tint(Color.DarkGray)

                    )
                }
            }

        }
    }
}

