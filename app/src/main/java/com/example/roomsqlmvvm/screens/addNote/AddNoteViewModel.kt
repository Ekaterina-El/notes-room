package com.example.roomsqlmvvm.screens.addNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomsqlmvvm.REPOSITORY
import com.example.roomsqlmvvm.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel : ViewModel() {
    fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insertNote(noteModel, onSuccess)
        }
}