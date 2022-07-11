package com.project.notesapplication.feature_note.presentation.editnotes

data class NoteTextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean=true,
)
