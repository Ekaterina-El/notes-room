package com.example.roomsqlmvvm.db.repository

import androidx.lifecycle.LiveData
import com.example.roomsqlmvvm.model.NoteModel


// "Список" функций и переменных для работы с БД
interface NoteRepository {
    val allNotes: LiveData<List<NoteModel>>

    suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit)
    suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit)
}