package com.example.movieapp.Screens.Home.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.Model.Movie
import com.example.movieapp.Model.getMovies
import com.example.movieapp.Navigation.MovieScreens
import com.example.movieapp.widgets.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController)
{
    Scaffold(
        topBar = {
            TopAppBar(
                title =
                 {
                    Row (modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center){
                        Text(text = "movies")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Cyan),

            )
        }
    )
    {
            innerPadding ->
        Box(modifier = Modifier.padding(innerPadding))
        {
            MainContent(navController=navController)
        }
    }
}
@Composable
fun MainContent(
    navController: NavController,
    movieList : List<Movie> = getMovies()
)
{
    Column(modifier = Modifier.padding(12.dp))
    {
        LazyColumn()
        {
            items(items = movieList)
            {

                MovieRow(movie =it)
                {
                        movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")
                }
            }
        }
    }

}