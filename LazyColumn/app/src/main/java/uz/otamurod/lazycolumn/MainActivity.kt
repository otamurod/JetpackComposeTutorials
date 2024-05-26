package uz.otamurod.lazycolumn

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.otamurod.lazycolumn.repository.PersonRepository
import uz.otamurod.lazycolumn.ui.theme.LazyColumnTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnTheme {
                val personRepository = PersonRepository()
                val allData = personRepository.getAllData()

                val sections = listOf("A", "B", "C", "D", "E", "F", "G")

                Column(modifier = Modifier.fillMaxSize()) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        contentPadding = PaddingValues(all = 12.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(
                            items = allData
                        ) { person ->
                            CustomItem(person = person)
                        }

                        itemsIndexed(
                            items = allData,
                            key = { index, item ->
                                item.id
                            }
                        ) { index, person ->
                            CustomItem(person = person)
                            Log.d(TAG, "onCreate: $index")
                        }
                    }

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        contentPadding = PaddingValues(all = 12.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        sections.forEach { section ->
                            stickyHeader {
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color.LightGray)
                                        .padding(12.dp),
                                    text = "Section $section"
                                )
                            }

                            items(10) {
                                Text(
                                    modifier = Modifier.padding(12.dp),
                                    text = "Item $it from Section $section"
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LazyColumnTheme {

    }
}