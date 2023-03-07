package com.example.notepade_room_myapp.screens.notebook.add_note_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.notepade_room_myapp.APP
import com.example.notepade_room_myapp.R
import com.example.notepade_room_myapp.databinding.FragmentAddNoteBinding
import com.example.notepade_room_myapp.model.NoteModel

class AddNoteFragment : Fragment() {
    lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddNoteBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[AddNoteViewModel::class.java]

        binding.fbAddNote.setOnClickListener {

            val title = binding.edAddTitle.text.toString()
            val desc = binding.edAddDescription.text.toString()

            viewModel.insert(NoteModel(title = title, description = desc)) {}
            APP.navController.navigate(R.id.action_addNoteFragment_to_startNoteFragment)


        }

        binding.fbBack.setOnClickListener {
            APP.navController.navigate(R.id.action_addNoteFragment_to_startNoteFragment)
        }

    }


}