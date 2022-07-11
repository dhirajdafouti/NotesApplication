package com.project.notesapplication.feature_note.presentation.editnotes


import android.text.Html
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.notesapplication.feature_note.domain.model.Note
import com.project.notesapplication.feature_note.domain.usecases.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    init {
        savedStateHandle.get<Int>("noteId")?.let { noteId ->
            if (noteId != -1) {
                viewModelScope.launch {
                    noteUseCases.getNote(noteId)?.also {note->
                        currentNoteId=note.id
                        _noteTitle.value =noteTitle.value.copy(
                            text =note.title,
                            isHintVisible = false
                        )
                        _noteContent.value =noteContent.value.copy(
                            text=note.content,
                            isHintVisible = false
                        )
                        _noteColor.value=note.color
                    }
                }
            }
        }
    }

    private val _noteTitle =
        mutableStateOf<NoteTextFieldState>(NoteTextFieldState(text = "Enter the Note"))
    val noteTitle: State<NoteTextFieldState> = _noteTitle

    private val _noteContent =
        mutableStateOf<NoteTextFieldState>(NoteTextFieldState(hint = "Enter the content"))
    val noteContent: State<NoteTextFieldState> = _noteContent

    private val _noteColor = mutableStateOf<Int>(Note.noteColors.random().toArgb())
    val noteColor: State<Int> = _noteColor

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentNoteId: Int? = null

    fun onEvent(event: AddEditNoteEvent) {
        when (event) {
            is AddEditNoteEvent.EnteredTitle -> {
                _noteTitle.value = noteTitle.value.copy(
                    text = event.value
                )
            }

            is AddEditNoteEvent.ChangeTitleFocus -> {
                _noteTitle.value = noteTitle.value.copy(
                    isHintVisible = !event.focusState.isFocused && noteTitle.value.text.isBlank()
                )
            }

            is AddEditNoteEvent.EnteredContent -> {
                _noteContent.value = noteContent.value.copy(
                    text = event.value
                )
            }

            is AddEditNoteEvent.ChangeContentFocus -> {
                _noteContent.value = noteContent.value.copy(
                    isHintVisible = !event.focusState.isFocused && noteContent.value.text.isBlank()
                )
            }

            is AddEditNoteEvent.ChangeColor -> {
                _noteColor.value = event.color
            }

            is AddEditNoteEvent.SaveNote -> {
                viewModelScope.launch {
                    try {
                        noteUseCases.addNote(
                            Note(title = noteTitle.value.text,
                                content = noteContent.value.hint,
                                timestamp = System.currentTimeMillis(),
                                color = noteColor.value,
                                id = currentNoteId)
                        )
                        _eventFlow.emit(UiEvent.saveNote)
                    } catch (e: Note.InvalidNoteException) {
                        _eventFlow.emit(
                            UiEvent.showSnackbar(
                                message = e.message ?: "error"
                            )
                        )
                    }
                }
            }
        }

    }

    sealed class UiEvent {
        data class showSnackbar(val message: String) : UiEvent()
        object saveNote : UiEvent()

    }

    companion object {
        val TAG: String = AddEditViewModel::class.java.simpleName
    }
}