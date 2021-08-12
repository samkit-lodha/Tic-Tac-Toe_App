package com.example.tic_tac_toeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.example.tic_tac_toeapp.databinding.FragmentNameBinding

class NameFragment : Fragment() {

    private lateinit var binding: FragmentNameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_name,container,false)

        binding.startGame.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(NameFragmentDirections.actionNameFragmentToGameFragment(binding.editTextTextPersonName.text.toString(),binding.editTextTextPersonName2.text.toString()))
        }

        return binding.root
    }
}