package com.onuryasarkaraduman.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onuryasarkaraduman.core.ui.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> BottomSheetList(
    items: List<T>,
    buttonText: String,
    selectedItem: T?,
    onItemSelected: (T) -> Unit,
    label: String,
    labelMapper: (T) -> String,  // Generic item'ı stringe çeviren fonksiyon
    onDismiss: () -> Unit,

    ) {
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = bottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() }
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = label,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
                IconButton(onClick = onDismiss) {
                    Icon(Icons.Default.Close, contentDescription = null, tint = Color.Gray)
                }
            }

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(items) { item ->
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .clickable { onItemSelected(item) }
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (selectedItem == item),
                            onClick = { onItemSelected(item) },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = colorResource(R.color.yellow_selection),
                                unselectedColor = Color.LightGray
                            )
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = labelMapper(item))
                    }
                    HorizontalDivider()
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LitLinkAppButton(
                    text = buttonText,
                    onClick = {}
                )
            }


        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewBottomSheetList() {
    val sampleItems = listOf("Action", "Science", "Art", "Fantasy")
    var selectedItem = remember { sampleItems[0] }

    BottomSheetList(
        items = sampleItems,
        buttonText = stringResource(id = R.string.add_other_categories),
        selectedItem = selectedItem,
        onItemSelected = { selectedItem = it },
        label = "User Categories",
        labelMapper = { it },
        onDismiss = { },

        )
}
