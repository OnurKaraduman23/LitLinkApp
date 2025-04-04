package com.onuryasarkaraduman.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onuryasarkaraduman.core.ui.R
import com.onuryasarkaraduman.datasource.user.ReadingStatus
import com.onuryasarkaraduman.domain.model.BookDetailModel



@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AddBookBottomSheet(
    bookDetail: BookDetailModel?,
    selectedStatus: ReadingStatus = ReadingStatus.NONE,
    onDismissRequest: () -> Unit,
    onStatusSelected: (ReadingStatus) -> Unit,
    onSaveClick: () -> Unit,
) {
    var currentSelection by remember { mutableStateOf(selectedStatus) }

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = onDismissRequest,
        tonalElevation = 4.dp,
        modifier = Modifier.wrapContentHeight()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = stringResource(R.string.add_book_options),
                style = MaterialTheme.typography.titleLarge
            )

            if (bookDetail != null) {
                Text(
                    text = bookDetail.bookTitle,
                    style = MaterialTheme.typography.titleMedium
                )
            }

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp),
                color = colorResource(id = R.color.yellow)
            )

            RadioOption(
                label = stringResource(R.string.i_read),
                selected = currentSelection == ReadingStatus.READ,
                onClick = {
                    currentSelection = ReadingStatus.READ
                    onStatusSelected(ReadingStatus.READ)
                }
            )

            RadioOption(
                label = stringResource(R.string.i_reading),
                selected = currentSelection == ReadingStatus.READING,
                onClick = {
                    currentSelection = ReadingStatus.READING
                    onStatusSelected(ReadingStatus.READING)
                }
            )

            RadioOption(
                label = stringResource(R.string.i_will_read),
                selected = currentSelection == ReadingStatus.WILL_READ,
                onClick = {
                    currentSelection = ReadingStatus.WILL_READ
                    onStatusSelected(ReadingStatus.WILL_READ)
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            LitLinkAppButton(
                onClick = {
                    onDismissRequest()
                    onSaveClick()
                },
                text = stringResource(id = R.string.save),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                isEnabled = if (currentSelection == ReadingStatus.NONE) false else true
            )
        }
    }
}

@Composable
private fun RadioOption(
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        RadioButton(
            selected = selected,
            onClick = onClick,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
internal fun AddBookBottomSheetPreview() {
    AddBookBottomSheet(
        bookDetail = BookDetailModel(
            id = "",
            bookTitle = "Dante's Inferno",
            description = "Lorem Ipsum Dolor",
            vote = 3.14f,
            authors = "",
            smallImageUrl = "",
            mediumImageUrl = "",
            largeImageUrl = "",
            categories = listOf("", "")
        ),
        selectedStatus = ReadingStatus.NONE,
        onDismissRequest = {},
        onStatusSelected = {},
        onSaveClick = {}
    )
}