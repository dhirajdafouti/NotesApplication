package com.project.notesapplication.feature_note.domain.usecases

import com.project.notesapplication.feature_note.domain.model.Note
import com.project.notesapplication.feature_note.domain.repository.NoteRepository

class GetNote(private val repository: NoteRepository) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}