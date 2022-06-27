package com.project.notesapplication.feature_note.domain.usecases

import com.project.notesapplication.feature_note.domain.model.Note
import com.project.notesapplication.feature_note.domain.repository.NoteRepository

class AddNote(private val repository: NoteRepository) {

    @Throws(Note.InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
           throw Note.InvalidNoteException("The title of the note cannot be empty!!!!")
        }
        if(note.content.isBlank()){
            throw Note.InvalidNoteException("The Content of the note is not empty!!!")
        }
        repository.insertNote(note)
    }
}