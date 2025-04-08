package com.onuryasarkaraduman.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.onuryasarkaraduman.core.ui.R
import com.onuryasarkaraduman.datasource.user.Friend
import com.onuryasarkaraduman.datasource.user.FriendshipStatus
import com.onuryasarkaraduman.ui.extensions.boldBorder
import com.onuryasarkaraduman.ui.extensions.noRippleClickable

@Composable
fun AppFollowButton(
    modifier: Modifier = Modifier,
    status: FriendshipStatus? = null,
    friend: Friend,
    onFollowClick: (String) -> Unit,

) {
    val text = when (status) {
        FriendshipStatus.PENDING -> "Pending"
        FriendshipStatus.ACCEPTED -> "Unfollow"
        else -> "+ Follow"
    }
    val borderColor = when (status) {
        FriendshipStatus.PENDING ->  colorResource(id = R.color.gray)
        FriendshipStatus.ACCEPTED -> colorResource(id = R.color.yellow)
        else ->  colorResource(id = R.color.blue)
    }
    val textColor = when (status) {
        FriendshipStatus.PENDING ->  colorResource(id = R.color.gray)
        FriendshipStatus.ACCEPTED -> colorResource(id = R.color.black)
        else ->  colorResource(id = R.color.blue)
    }
    Column(
        modifier = modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(4.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            )
            .boldBorder(
                color = borderColor

            )
            .noRippleClickable { onFollowClick(friend.friendUid) }
    ) {
       Text(
           modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
           text = text,
           fontSize = 16.sp,
           color = textColor
       )
    }

}

@Preview(showBackground = true)
@Composable
fun AppFollowButtonPendingPreview(){
    AppFollowButton(
        status = FriendshipStatus.PENDING,
        friend = Friend(friendUid = ""),
        onFollowClick = {}
    )
}
@Preview(showBackground = true)
@Composable
fun AppFollowButtonAcceptedPreview(){
    AppFollowButton(
        status = FriendshipStatus.ACCEPTED,
        friend = Friend(friendUid = ""),
        onFollowClick = {}
    )
}
@Preview(showBackground = true)
@Composable
fun AppFollowButtonUnfollowPreview(){
    AppFollowButton(
        friend = Friend(friendUid = ""),
        onFollowClick = {}
    )
}