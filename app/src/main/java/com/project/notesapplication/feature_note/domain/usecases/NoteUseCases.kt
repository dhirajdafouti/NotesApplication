package com.project.notesapplication.feature_note.domain.usecases

//This class will inject the combination of two use cases to the view model
data class NoteUseCases(
    val getNotes: GetNotes,
    val deleteNote: DeleteNote,

    )
