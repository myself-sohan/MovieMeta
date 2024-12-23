package com.example.movieapp.Screens.Home.details

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.Model.getMovies
import com.example.movieapp.widgets.HorizontalScrollableImageView
import com.example.movieapp.widgets.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController, movieId: String?)
{
    val newMovieList= getMovies().filter {
        movie-> movie.id==movieId
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row (horizontalArrangement = Arrangement.Start){
                        Image(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Go back",
                            modifier = Modifier.clickable{
                                navController.popBackStack()
                            }
                        )
                    }
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center)
                    {
                        Text(text = "movies")
                    }
                        },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Cyan)
            )

        }
    )
    {
            innerPadding ->
        Surface (modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .fillMaxWidth()) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(10.dp)
            ) {
                Surface(modifier = Modifier.weight(8f)){
                    MovieRow(movie = newMovieList[0])
                    {}
                }
                Spacer(modifier = Modifier.height(28.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.Gray)
                        .padding(3.dp)
                )
                Spacer(modifier = Modifier.height(28.dp))
                Text(text = "Movie Images",
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.headlineLarge)
                HorizontalScrollableImageView(newMovieList=newMovieList,
                    modifier = Modifier.weight(3f))
                }
            }
        }
    }



