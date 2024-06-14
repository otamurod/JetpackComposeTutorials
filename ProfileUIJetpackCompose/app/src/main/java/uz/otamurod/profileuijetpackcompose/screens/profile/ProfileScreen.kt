package uz.otamurod.profileuijetpackcompose.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uz.otamurod.profileuijetpackcompose.R
import uz.otamurod.profileuijetpackcompose.navigation.Screen

@Composable
fun ProfileScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    val rowItems = arrayListOf(
        RowItem(
            startIconId = R.drawable.btn_1,
            title = "Notification",
            endIconId = R.drawable.arrow,
            navDestination = Screen.Notifications.route
        ),
        RowItem(
            startIconId = R.drawable.btn_2,
            title = "Calendar",
            endIconId = R.drawable.arrow,
            navDestination = Screen.Calendar.route
        ),
        RowItem(
            startIconId = R.drawable.btn_3,
            title = "Gallery",
            endIconId = R.drawable.arrow,
            navDestination = Screen.Gallery.route
        ),
        RowItem(
            startIconId = R.drawable.btn_4,
            title = "My Playlist",
            endIconId = R.drawable.arrow,
            navDestination = Screen.Playlist.route
        ),
        RowItem(
            startIconId = R.drawable.btn_5,
            title = "Share",
            endIconId = R.drawable.arrow,
            navDestination = Screen.Share.route
        ),
        RowItem(
            startIconId = R.drawable.btn_6,
            title = "Log out",
            endIconId = null,
            navDestination = Screen.Main.route
        )
    )

    LazyColumn(
        modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color(android.graphics.Color.parseColor("#f2f1f6"))),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {
            ConstraintLayout(
                modifier = Modifier
                    .height(210.dp)
                    .background(color = Color(android.graphics.Color.parseColor("#32357a")))
            ) {
                val (topImg, profile, title, back, pen) = createRefs()

                Image(
                    painter = painterResource(id = R.drawable.arc_3),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(topImg) { bottom.linkTo(parent.bottom) })

                Image(
                    painter = painterResource(id = R.drawable.user_2),
                    contentDescription = null,
                    modifier = Modifier
                        .constrainAs(profile) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(topImg.bottom)
                        })

                Text(
                    text = "Profile",
                    style = TextStyle(color = Color.White),
                    fontSize = 30.sp,
                    modifier = Modifier.constrainAs(title) {
                        top.linkTo(parent.top, margin = 32.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                )

                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = null,
                    modifier = Modifier
                        .constrainAs(back) {
                            start.linkTo(parent.start, margin = 24.dp)
                            top.linkTo(parent.top, margin = 24.dp)
                        })

                Image(
                    painter = painterResource(id = R.drawable.write),
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .padding(start = 8.dp)
                        .constrainAs(pen) {
                            end.linkTo(profile.end)
                            top.linkTo(profile.top)
                        }
                        .clickable {
                            navController.navigate(Screen.EditProfile.route)
                        }
                )
            }
            Text(
                text = "Alex Flores",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp),
                color = Color(android.graphics.Color.parseColor("#32357a"))
            )

            Text(
                modifier = Modifier.padding(bottom = 22.dp),
                text = "alexflores@gmail.com",
                fontSize = 18.sp,
                color = Color(android.graphics.Color.parseColor("#747679"))
            )
        }

        items(items = rowItems) {
            RowItemView(rowItem = it, navController = navController)
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            )
        }
    }
}

@Composable
fun RowItemView(rowItem: RowItem, navController: NavHostController) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, top = 8.dp, bottom = 8.dp),
        shape = RoundedCornerShape(size = 50.dp),
        color = Color(android.graphics.Color.parseColor("#E0E6F8"))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp)
                .height(55.dp)
                .clickable {
                    navigateToDestination(navController, rowItem.navDestination)
                },
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                Image(
                    painter = painterResource(id = rowItem.startIconId),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 5.dp)
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            ) {
                Text(
                    text = rowItem.title,
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            if (rowItem.endIconId != null) {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = rowItem.endIconId),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 16.dp)
                    )
                }
            }
        }
    }
}

fun navigateToDestination(navController: NavHostController, navDestination: String) {
    if (navDestination == Screen.Main.route) {
        navController.popBackStack()
    }
    navController.navigate(navDestination)
}

@Preview(name = "ProfileScreen")
@Composable
private fun PreviewProfileScreen() {
    ProfileScreen(navController = rememberNavController())
}