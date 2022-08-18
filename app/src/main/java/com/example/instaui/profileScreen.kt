package com.example.instaui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TopBar(
    name : String,
    modifier: Modifier
){
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ){
        Row(modifier = Modifier
            .weight(8f)
            .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            Spacer( Modifier.width(5.dp))
            Text(text = name, fontSize = 20.sp, fontWeight = FontWeight.Bold, overflow = TextOverflow.Ellipsis)
            Icon(imageVector = Icons.Default.Face, contentDescription = "Face")
        }
        Row(modifier = Modifier.weight(1f)) {
            Icon(imageVector = Icons.Default.Face, contentDescription = "Face")
        }
    }
}


@Composable
fun ProfileStat(){
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ){
        Image( painter = painterResource(id = R.drawable.ic_launcher_background),
               contentDescription = "",
            Modifier
                .size(100.dp)
                .weight(3f)
                .border(1.dp, Color.Gray, CircleShape)
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .padding(5.dp)
                .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.weight(7f)
            ) {

                Column( verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,) {
                    Text(text = "25", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Posts")
                }
                Column ( verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,){
                    Text(text = "11M", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Followers" )
                }

                Column( verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,) {
                    Text(text = "1", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Following")
                }
            }
    }
    profileDesc()
    Spacer(modifier = Modifier.height(20.dp))
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
        actionButton("Following")
        actionButton("Message")
        actionButton("Email")
    }
    Spacer(modifier = Modifier.height(20.dp))
    storyHighlights(list = listOf("one", "two", "two", "two", "two", "two" ))
    Spacer(modifier = Modifier.height(20.dp))
    btn(
        listOf("one","two","three", "four")
    ) {
        selectedIndex = it
    }
        when(selectedIndex){
            0 -> println("")
            1 -> Text(text = "TWO", textAlign = TextAlign.Center, modifier = Modifier.fillMaxSize())
            2 -> Text(text = "THREE", textAlign = TextAlign.Center, modifier = Modifier.fillMaxSize())
            3 -> Text(text = "FOUR", textAlign = TextAlign.Center, modifier = Modifier.fillMaxSize())
        }
}

@Composable
fun actionButton(text : String){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .defaultMinSize(minWidth = 95.dp)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
    }
}

@Composable
fun profileDesc(){
    Column (modifier = Modifier.padding(start = 20.dp)){
        Text(text = "Shailey Jain", fontWeight = FontWeight.Bold)
        Text(text = "some years of coding experience.", fontSize = 15.sp, letterSpacing = 0.5.sp, lineHeight = 20.sp)
        Text(text = "want me to make your app?.", fontSize = 15.sp, letterSpacing = 0.5.sp, lineHeight = 20.sp)
        Text(text = "https://youtube/c/sahil jain",
            fontSize = 15.sp,
            color = Color(0xFF3D3D91),
            letterSpacing = 0.5.sp,
            lineHeight = 20.sp)
    }
}

@Composable
fun storyHighlights(
    list : List<String>
){
    LazyRow(content = {
        items(list.size){
            Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                modifier = Modifier
                    .size(80.dp)
                    .border(1.dp, Color.Gray, CircleShape)
                    .padding(5.dp)
                    .clip(CircleShape)
                ,
                contentDescription = "")
            Spacer(modifier = Modifier.width(10.dp))
        }
    })
}

@Composable
fun btn(
    list : List<String>,
    onTabSelected : (selectedIndex: Int) -> Unit
){
    var selected by remember{
        mutableStateOf(0)
    }
    TabRow(selectedTabIndex = selected, backgroundColor = Color.Transparent
    ) {
        list.forEachIndexed{ index, item->
            Tab(selected = index == selected,
                unselectedContentColor = Color.Gray,
                selectedContentColor = Color.Black,
                onClick = {
                    selected = index
                    onTabSelected(index)
                }){
                Icon(imageVector = Icons.Default.Face, contentDescription = "")
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun posts(
    list : List<String>,
    onClick : (index : Int)-> Unit
){
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = Modifier.fillMaxWidth()
    ){
        itemsIndexed(list){ index, item->
            Image(painter = painterResource(id = R.drawable.ic_launcher_background)
                , contentDescription = "posts",
                modifier = Modifier.border(2.dp, Color.White, RectangleShape)
                    .aspectRatio(1f)
                    .clickable(
                        enabled = true,
                        onClick = { onClick(index) }
                    )
            )
        }
    }
}