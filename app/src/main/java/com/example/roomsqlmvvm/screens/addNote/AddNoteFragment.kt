package com.example.roomsqlmvvm.screens.addNote

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.roomsqlmvvm.APP
import com.example.roomsqlmvvm.R
import com.example.roomsqlmvvm.model.NoteModel
import kotlinx.android.synthetic.main.fragment_add_note.view.*

class AddNoteFragment : Fragment(R.layout.fragment_add_note) {
    private lateinit var mView: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mView = view

        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(AddNoteViewModel::class.java)

        mView.btn_back.setOnClickListener {
            APP.navController.navigateUp()
        }

        mView.btn_add.setOnClickListener {
            val title = requireView().et_add_title.text.toString()
            val description = requireView().et_add_description.text.toString()

            viewModel.insertNote(
                NoteModel(
                    title = title, description = description
                )
            ) {}
            APP.navController.navigateUp()

        }
    }
}