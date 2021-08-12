package com.example.tic_tac_toeapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.example.tic_tac_toeapp.databinding.FragmentScoreBinding

class ScoreFragment : Fragment() {

    private lateinit var binding: FragmentScoreBinding
    private lateinit var winner : String
    private lateinit var args : ScoreFragmentArgs

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_score,container,false)

        args = ScoreFragmentArgs.fromBundle(requireArguments())
        winner = args.playerWon

        binding.message.text = "$winner wins the game"
        Toast.makeText(inflater.context,"$winner takes it all",Toast.LENGTH_SHORT).show()

        binding.playAgain.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(ScoreFragmentDirections.actionScoreFragmentToNameFragment())
        }

        binding.shareScore.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.setType("text/plain").putExtra(Intent.EXTRA_TEXT,winner)
            startActivity(intent)
        }

        return binding.root
    }
}