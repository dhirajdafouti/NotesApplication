package com.project.notesapplication.feature_note.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.notesapplication.feature_note.domain.model.Note
import com.project.notesapplication.feature_note.domain.usecases.NoteUseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

class NotesViewModel @Inject constructor(private val notesUseCases: NoteUseCases) : ViewModel() {

    private val _state = mutableStateOf<NotesState>(NotesState())
    val state: State<NotesState> = _state

    private var recentlyDeletedNote: Note? = null
    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.Order -> {

            }
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    notesUseCases.deleteNote(event.note)
                    recentlyDeletedNote = event.note
                }
            }
            is NotesEvent.RestoreNote -> {
                viewModelScope.launch {

                }

            }
            is NotesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }
}