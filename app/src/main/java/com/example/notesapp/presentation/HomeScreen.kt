package com.example.notesapp.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.notesapp.viewModel.NoteViewModel
import com.example.notesapp.Screens


@Composable
fun HomeScreen(navController: NavController, viewModel: NoteViewModel){

    val notes by viewModel.notes.collectAsState(initial = emptyList())


        Column(
            modifier = Modifier.fillMaxSize()
                .systemBarsPadding()
                .background(Color(0xFFF5F9FF))
        ) {

            Row(
                modifier = Modifier.fillMaxWidth().systemBarsPadding(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {



                IconButton({ navController.popBackStack()}) {
                    Image(imageVector = Icons.Default.ArrowBack, "back")
                }

                Text("Notes ", fontSize = 28.sp, fontWeight = FontWeight.Bold)


                IconButton({ navController.navigate(Screens.NotesInputScreen.routes) }) {
                    Icon(Icons.Default.Add, "add")
                }
            }


            LazyColumn() {

                items(notes) { notesData ->



                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp), horizontalArrangement = Arrangement.SpaceEvenly) {

                        Card(
                            elevation = CardDefaults.elevatedCardElevation(8.dp),
                            colors = CardDefaults.cardColors(Color(0xFFE3F2FD)),
                            modifier = Modifier.fillMaxWidth(0.8f),
                            border = BorderStroke(1.dp, color = Color(0xFFBBDEFB)),

                            onClick = {navController.navigate(Screens.UpdateScreen.passingData(notesData.id))}

                        ) {

                            Column {


                                Text("Title",
                                    fontSize = 6.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 8.dp, top = 4.dp),
                                    color = Color.Black
                                )

                                Text(notesData.title?:"not title",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(6.dp),
                                    color = Color.Black
                                )
                                Text("Description",
                                    fontSize = 6.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 8.dp, top = 4.dp),
                                    color = Color.Black
                                )

                                Text(
                                    notesData.description?:"no desc",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(6.dp),
                                    color = Color(0xFF424242),
                                    maxLines = 4,
                                    overflow = TextOverflow.Ellipsis
                                )

                            }
                        }

                        Card(
                            elevation = CardDefaults.elevatedCardElevation(8.dp),
                            colors = CardDefaults.cardColors(Color(0xFFE3F2FD)),
                            modifier = Modifier.wrapContentWidth().wrapContentHeight().padding(start = 12.dp),
                            border = BorderStroke(1.dp, color = Color(0xFFBBDEFB)),
                            onClick = {viewModel.deleteNote(notesData)},


                        )
                        {
                            Icon(imageVector = Icons.Default.Delete,"delete", modifier = Modifier.padding(14.dp))
                        }

                    }







                }
            }
        }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    val navController = rememberNavController()
  // HomeScreen(navController, viewModel())
}


