package com.example.roomsqlmvvm.screens.start

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.roomsqlmvvm.APP
import com.example.roomsqlmvvm.R
import com.example.roomsqlmvvm.adapter.NoteAdapter
import kotlinx.android.synthetic.main.fragment_start.view.*

class StartFragment : Fragment(R.layout.fragment_start) {
    lateinit var adapter: NoteAdapter
    lateinit var mView: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mView = view
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        viewModel.initDatabase()

        adapter = NoteAdapter()
        mView.rv_notes.adapter = adapter
        viewModel.getAllNotes().observe(viewLifecycleOwner) { listNotes ->
            adapter.setNotes(listNotes.asReversed())
        }

        mView.btn_add.setOnClickListener {
            APP.navController.navigate(R.id.action_startFragment_to_addNoteFragment)
        }
    }
}