package com.project.notesapplication.feature_note.presentation.editnotes

import androidx.lifecycle.ViewModel
import com.project.notesapplication.feature_note.domain.usecases.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddEditViewModel @Inject constructor(private val noteUseCases: NoteUseCases)
    : ViewModel() {
}