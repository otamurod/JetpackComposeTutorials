package uz.otamurod.paging3.screens.search

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import uz.otamurod.paging3.screens.common.ListContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalPagingApi::class, ExperimentalCoilApi::class)
@Composable
fun SearchScreen(
    navController: NavHostController, searchViewModel: SearchViewModel = hiltViewModel()
) {
    val searchQuery by searchViewModel.searchQuery
    val searchedImages = searchViewModel.searchedImages.collectAsLazyPagingItems()

    Scaffold(topBar = {
        SearchWidget(text = searchQuery, onTextChange = {
            searchViewModel.updateSearchQuery(query = it)
        }, onSearchClicked = {
            searchViewModel.searchHeroes(query = it)
        }, onCloseClicked = {
            navController.popBackStack()
        })
    }, content = {
        ListContent(items = searchedImages)
    })
}

@OptIn(ExperimentalPagingApi::class)
@Preview(name = "SearchScreen")
@Composable
private fun PreviewSearchScreen() {
    SearchScreen(rememberNavController())
}