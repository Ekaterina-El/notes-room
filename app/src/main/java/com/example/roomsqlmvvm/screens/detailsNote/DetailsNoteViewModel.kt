package com.example.roomsqlmvvm.screens.detailsNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomsqlmvvm.REPOSITORY
import com.example.roomsqlmvvm.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsNoteViewModel: ViewModel() {
    fun deleteNote(noteModel: NoteModel) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteNote(noteModel) {}
        }
    }
}