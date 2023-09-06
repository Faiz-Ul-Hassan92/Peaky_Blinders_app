package com.example.peakyblinders

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.PeakyBlindersTheme
import com.example.peakyblinders.model.Character
import com.example.peakyblinders.model.CharacterRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PeakyBlindersTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                       CharacterApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterApp(modifier : Modifier = Modifier) {

    val characters = CharacterRepository

    Scaffold(
        topBar = { AppTopBar() }

    ){ it ->
        LazyColumn(contentPadding = it) {
            items(characters.characterList) { character ->
                CharacterCard(
                    character = character,
                    modifier = Modifier.padding(
                        start = 12.dp,
                        end = 12.dp,
                        bottom = 12.dp,
                        top = 18.dp
                    )
                )
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(modifier : Modifier = Modifier) {
   CenterAlignedTopAppBar (
       title = {
           Box() {
               Row(
                   verticalAlignment = Alignment.CenterVertically,
                   horizontalArrangement = Arrangement.Center
               ) {

                   Image(
                       painter = painterResource(R.drawable.symbol),
                       contentDescription = stringResource(R.string.app_name),
                       modifier = Modifier.size(44.dp)
                   )

                   Spacer(modifier = Modifier.width(4.dp))


                   Text(
                       text = stringResource(R.string.app_name),
                       style = MaterialTheme.typography.titleLarge,
                       fontSize = 25.sp,
                       textAlign = TextAlign.Center
                   )
               }
           }
       }
           )
}


@Composable
fun CharacterCard(character : Character,modifier : Modifier = Modifier) {

    var expand by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
    ) {



        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            ),
            modifier = Modifier
                .clip(shape = MaterialTheme.shapes.medium)

        ) {


            Box(
                modifier = Modifier
                    .padding(start = 18.dp,end = 18.dp,top = 10.dp, bottom = 8.dp)
            ) {


                Column(
                    modifier = Modifier
                        .animateContentSize(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                stiffness = Spring.StiffnessLow
                            )
                        )
                ) {
                    CharacterNumber(
                        num = character.num,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    CharacterName(
                        name = character.name,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    CharacterImage(
                        imageResource = character.imageResource,
                        name = character.name,
                        modifier = Modifier
                    )

                    if(expand){
                        Spacer(modifier = Modifier.height(2.dp))
                        CharacterDetails(des = character.description)
                    }

                }





            }
        }

        Button(
            onClick = { expand = !expand },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            modifier = if(!expand){
                Modifier
                    .height(384.dp)
                    .width(400.dp)
            }else {
                Modifier
                    .height(500.dp)
                    .width(400.dp)
                  },
            shape = MaterialTheme.shapes.medium
        
        ) {

        }


    }
}


@Composable
fun CharacterNumber(@StringRes num : Int,modifier : Modifier  = Modifier) {
  Box(modifier = modifier) {
      Text(
          text = stringResource(num),
          style = MaterialTheme.typography.labelSmall
      )
  }
}



@Composable
fun CharacterName(@StringRes name : Int, modifier : Modifier = Modifier) {
  Box(modifier = modifier) {
      Text(
          text = stringResource(name),
          style = MaterialTheme.typography.titleMedium
      )
  }
}

@Composable
fun CharacterImage(@DrawableRes imageResource : Int,@StringRes name : Int,  modifier : Modifier = Modifier) {

     Box(modifier = modifier) {
         Image(
             painter = painterResource(imageResource),
             contentDescription = stringResource(name),
             modifier = Modifier
                 .width(400.dp)
                 .height(300.dp)
                 .clip(shape = MaterialTheme.shapes.large)
         )
     }
}

@Composable
fun CharacterDetails(@StringRes des : Int,modifier : Modifier = Modifier) {
  Box(modifier = modifier) {
      Text(
          text = stringResource(des)
      )
  }
}


@Preview(showBackground = true)
@Composable
fun PeakyBlindersPreview() {
    PeakyBlindersTheme {
        CharacterApp()

    }
}