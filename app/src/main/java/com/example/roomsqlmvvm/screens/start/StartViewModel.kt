package com.example.roomsqlmvvm.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.roomsqlmvvm.REPOSITORY
import com.example.roomsqlmvvm.db.NoteDataBase
import com.example.roomsqlmvvm.db.repository.NoteRealisation
import com.example.roomsqlmvvm.model.NoteModel

class StartViewModel(application: Application) : AndroidViewModel(application) {
    val context = application

    fun initDatabase() {
        val daoNote = NoteDataBase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealisation(daoNote)
    }

    fun getAllNotes(): LiveData<List<NoteModel>> {
        return REPOSITORY.allNotes
    }
}