package com.example.notepade_room_myapp.screens.notebook.detail_note_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.currentRecomposeScope
import androidx.lifecycle.ViewModelProvider
import com.example.notepade_room_myapp.APP
import com.example.notepade_room_myapp.R
import com.example.notepade_room_myapp.databinding.FragmentDetailNoteBinding
import com.example.notepade_room_myapp.model.NoteModel

class DetailNoteFragment : Fragment() {
    lateinit var binding: FragmentDetailNoteBinding
    lateinit var currentNote: NoteModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailNoteBinding.inflate(layoutInflater, container, false)
        currentNote = arguments?.getSerializable("note") as NoteModel
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[DetailNoteViewModel::class.java]

        binding.edDescTitle.text = currentNote.title
        binding.edDescDescription.text = currentNote.description

        binding.fbDeleteNote.setOnClickListener {
            viewModel.delete(currentNote){}
            APP.navController.navigate(R.id.action_detailNoteFragment_to_startNoteFragment)
        }

        binding.fbBack.setOnClickListener {
            APP.navController.navigate(R.id.action_detailNoteFragment_to_startNoteFragment)
        }
    }


}