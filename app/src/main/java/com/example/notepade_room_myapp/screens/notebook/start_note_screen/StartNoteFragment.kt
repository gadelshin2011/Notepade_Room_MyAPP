package com.example.notepade_room_myapp.screens.notebook.start_note_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.notepade_room_myapp.APP
import com.example.notepade_room_myapp.R
import com.example.notepade_room_myapp.adapter.NoteAdapter
import com.example.notepade_room_myapp.databinding.FragmentStartNoteBinding


class StartNoteFragment : Fragment() {

    lateinit var binding: FragmentStartNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartNoteBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(StartNoteViewModel::class.java)
        viewModel.initDatabase()
        var recyclerView = binding.rcViewNotes
        val adapter = NoteAdapter()
        recyclerView.adapter = adapter
        viewModel.getAllNotes().observe(viewLifecycleOwner){ listNote ->
            adapter.setList(listNote.asReversed())

            binding.fbAddNote.setOnClickListener {
                APP.navController.navigate(R.id.action_startNoteFragment_to_addNoteFragment)
            }

        }

    }


}