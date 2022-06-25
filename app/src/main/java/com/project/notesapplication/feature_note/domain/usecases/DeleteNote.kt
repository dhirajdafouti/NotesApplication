package com.project.notesapplication.feature_note.domain.usecases

import com.project.notesapplication.feature_note.domain.model.Note
import com.project.notesapplication.feature_note.domain.repository.NoteRepository

class DeleteNote(private val repository:NoteRepository) {

    suspend operator fun invoke(note: Note){
        repository.deleteNotes(note)
    }
}