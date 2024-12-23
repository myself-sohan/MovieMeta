package com.example.movieapp.widgets

import android.widget.ImageView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movieapp.Model.Movie

@Composable
fun HorizontalScrollableImageView(newMovieList: List<Movie>,
                                  modifier: Modifier
)
{
    LazyRow(modifier = modifier)
    {
        items(items = newMovieList[0].images)
        { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(140.dp),
                elevation = CardDefaults.cardElevation(5.dp)
            )
            {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    GlideImageLoader(
                        url = image,
                        imageScale = ImageView.ScaleType.FIT_CENTER,
                        modifier = Modifier
                    )
                }
            }

        }
    }
}

