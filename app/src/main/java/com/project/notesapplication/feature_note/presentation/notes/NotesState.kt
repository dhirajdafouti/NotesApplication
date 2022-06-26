package com.project.notesapplication.feature_note.presentation.notes

import com.project.notesapplication.feature_note.domain.model.Note
import com.project.notesapplication.feature_note.domain.util.NoteOrder
import com.project.notesapplication.feature_note.domain.util.OrderType

data class NotesState(
    val noted: List<Note> = emptyList(),
    val notesOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false)
