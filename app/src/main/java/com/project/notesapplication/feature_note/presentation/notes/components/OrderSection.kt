package com.project.notesapplication.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.project.notesapplication.R
import com.project.notesapplication.feature_note.domain.util.NoteOrder
import com.project.notesapplication.feature_note.domain.util.OrderType
import com.project.notesapplication.feature_note.presentation.notes.NotesEvent

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit,
) {
    Column(modifier = Modifier) {
        Row(modifier.fillMaxWidth()) {
            DefaultRadioButton(text = stringResource(R.string.title),
                selected = noteOrder is NoteOrder.Title,
                onSelect = {
                    onOrderChange(NoteOrder.Title(noteOrder.orderType))
                })

            Spacer(modifier = Modifier.height(8.dp))
            DefaultRadioButton(text = stringResource(R.string.date),
                selected = noteOrder is NoteOrder.Date,
                onSelect = {
                    onOrderChange(NoteOrder.Date(noteOrder.orderType))
                })
            Spacer(modifier = Modifier.height(8.dp))
            DefaultRadioButton(text = stringResource(R.string.color),
                selected = noteOrder is NoteOrder.Color,
                onSelect = {
                    onOrderChange(NoteOrder.Color(noteOrder.orderType))
                })

        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton(text = stringResource(R.string.ascending),
                selected = noteOrder.orderType is OrderType.Ascending,
                onSelect = {
                    onOrderChange(noteOrder.copy(OrderType.Ascending))
                })

            Spacer(modifier = Modifier.height(8.dp))
            DefaultRadioButton(text = stringResource(R.string.decending),
                selected = noteOrder.orderType is OrderType.Descending,
                onSelect = {
                    onOrderChange(noteOrder.copy(OrderType.Descending))
                })
        }
    }

}