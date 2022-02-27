package com.example.roomsqlmvvm.screens.detailsNote

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.roomsqlmvvm.APP
import com.example.roomsqlmvvm.R
import com.example.roomsqlmvvm.model.NoteModel
import kotlinx.android.synthetic.main.fragment_details_note.view.*

class DetailsNoteFragment : Fragment(R.layout.fragment_details_note) {
    lateinit var currentNoteModel: NoteModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentNoteModel = arguments?.getSerializable("note") as NoteModel
        init()
    }

    private fun init() {
        requireView().details_title.text = currentNoteModel.title
        requireView().details_description.text = currentNoteModel.description

        val viewModel = ViewModelProvider(this).get(DetailsNoteViewModel::class.java)

        requireView().btn_back.setOnClickListener {
            APP.navController.navigateUp()
        }

        requireView().btn_delete.setOnClickListener {
            viewModel.deleteNote(currentNoteModel)
            APP.navController.navigateUp()
        }
    }
}