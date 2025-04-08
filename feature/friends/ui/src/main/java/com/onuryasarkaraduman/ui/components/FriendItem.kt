package com.onuryasarkaraduman.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onuryasarkaraduman.core.ui.R
import com.onuryasarkaraduman.datasource.user.Friend
import com.onuryasarkaraduman.datasource.user.FriendshipStatus
import com.onuryasarkaraduman.datasource.user.RelatedBooks
import com.onuryasarkaraduman.ui.extensions.boldBorder
import com.onuryasarkaraduman.ui.extensions.noRippleClickable


@Composable
internal fun FriendItem(
    friend: Friend,
    onFriendClick: (String) -> Unit,
    onRelatedBooksClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(4.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp),
            )
            .boldBorder(color = colorResource(id = R.color.yellow))
            .noRippleClickable { onFriendClick(friend.friendUid) },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AppCircleImage(
            modifier = Modifier.padding(start = 8.dp),
            imageResId = R.drawable.fiction,
            size = 90.dp
        )


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .fillMaxWidth()
            ) {
                HeaderText(
                    text = friend.userName,
                    maxLines = 1,
                    fontSize = 18
                )
                AppFollowButton(
                    modifier = Modifier.align(Alignment.End),
                    status = friend.status,
                    friend = friend,
                    onFollowClick = {}
                )
            }

            RelatedBooksItem(
                relatedBooks = friend.relatedBooks,
                modifier = Modifier.align(Alignment.BottomEnd),
                onClick = { onRelatedBooksClick() }

            )
        }
    }
}


@Preview(showBackground = true)
@Composable
internal fun FriendItemFollowPreview() {
    FriendItem(
        friend = Friend(
            friendUid = "",
            userName = "Joe Doe",
            since = 12345687L,
            status = FriendshipStatus.PENDING,
            relatedBooks = listOf(
                RelatedBooks(
                    "1", "Book 1", "https://example.com/1.jpg",
                ),
                RelatedBooks(
                    "2", "Book 2", "https://example.com/1.jpg",
                ),
                RelatedBooks(
                    "3", "Book 3", "https://example.com/1.jpg",
                ),
                RelatedBooks(
                    "3", "Book 3", "https://example.com/1.jpg",
                ),

                )
        ),
        onFriendClick = {},
        onRelatedBooksClick = {}
    )
}

@Preview(showBackground = true)
@Composable
internal fun FriendItemUnfollowPreview1() {
    FriendItem(
        friend = Friend(
            friendUid = "",
            userName = "Joe Doe",
            since = 12345687L,
            status = FriendshipStatus.ACCEPTED,
            relatedBooks = listOf(
                RelatedBooks(
                    "1", "Book 1", "https://example.com/1.jpg",
                ),

                )
        ),
        onFriendClick = {},
        onRelatedBooksClick = {}
    )
}

@Preview(showBackground = true)
@Composable
internal fun FriendItemUnfPreview1() {
    FriendItem(
        friend = Friend(
            friendUid = "",
            userName = "Joe Doe",
            since = 12345687L,
            status = FriendshipStatus.NONE,
            relatedBooks = listOf(
                RelatedBooks(
                    "1", "Book 1", "https://example.com/1.jpg",
                ),

                )
        ),
        onFriendClick = {},
        onRelatedBooksClick = {}
    )
}