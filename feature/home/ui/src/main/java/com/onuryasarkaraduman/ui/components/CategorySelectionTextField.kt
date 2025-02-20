package com.onuryasarkaraduman.ui.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onuryasarkaraduman.core.ui.R

@Composable
fun CategorySelectionTextField(
    items: List<String>,
    selectedItem: String,
    showBottomSheetState: Boolean = false,
) {
    var showBottomSheet by remember { mutableStateOf(showBottomSheetState) }
    var capitalizedSelectedItem = selectedItem.split(" ").joinToString(" ") {
        it.replaceFirstChar { c -> c.uppercaseChar() }
    }
    OutlinedTextField(
        value = capitalizedSelectedItem,
        onValueChange = { },
        readOnly = true,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            unfocusedIndicatorColor = colorResource(id = R.color.yellow),

            ),
        placeholder = { },
        modifier = Modifier
            .width(150.dp)
            .height(50.dp),
        trailingIcon = {
            Icon(
                modifier = Modifier.clickable {
                    showBottomSheet = true
                },
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Çek Statüsü ",
                tint = colorResource(id = R.color.yellow)
            )
        },
    )
if (showBottomSheet)
    BottomSheetList(
        items = items,
        buttonText = stringResource(id = R.string.add_other_categories),
        selectedItem = selectedItem,
        onItemSelected = { capitalizedSelectedItem = it },
        label = "",
        labelMapper = {it},
        onDismiss = {showBottomSheet = false},


    )
}

@Preview(showBackground = true)
@Composable
fun CategorySelectionTextFieldPreview() {
    CategorySelectionTextField(
        items = listOf("Action", "Fantasy", "Science", "fiction"),
        selectedItem = "Action",
    )
}