package com.example.tic_tac_toeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.tic_tac_toeapp.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding
    private lateinit var viewModel: MainViewModel

    private lateinit var playerOneName : String
    private lateinit var playerTwoName : String
    private lateinit var args: GameFragmentArgs

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_game,container,false)

        args = GameFragmentArgs.fromBundle(requireArguments())
        playerOneName = args.player1
        playerTwoName = args.player2
        binding.lastPlayerOne.text = "$playerOneName : "
        binding.lastPlayerTwo.text = "$playerTwoName : "

        viewModel = ViewModelProvider(this,MainViewModelFactory(playerOneName,playerTwoName)).get(MainViewModel::class.java)

        viewModel.oneView.observe(viewLifecycleOwner,{
            binding.one.text = it
        })
        viewModel.twoView.observe(viewLifecycleOwner,{
            binding.two.text = it
        })
        viewModel.threeView.observe(viewLifecycleOwner,{
            binding.three.text = it
        })
        viewModel.fourView.observe(viewLifecycleOwner,{
            binding.four.text = it
        })
        viewModel.fiveView.observe(viewLifecycleOwner,{
            binding.five.text = it
        })
        viewModel.sixView.observe(viewLifecycleOwner,{
            binding.six.text = it
        })
        viewModel.sevenView.observe(viewLifecycleOwner,{
            binding.seven.text = it
        })
        viewModel.eightView.observe(viewLifecycleOwner,{
            binding.eight.text = it
        })
        viewModel.nineView.observe(viewLifecycleOwner,{
            binding.nine.text = it
        })

        viewModel.currPlayer.observe(viewLifecycleOwner,{
            binding.PlayerTurn.text = it
        })

        viewModel.score1.observe(viewLifecycleOwner,{
            binding.lastPlayerOneScore.text = it.toString()
        })

        viewModel.score2.observe(viewLifecycleOwner,{
            binding.lastPlayerTwoScore.text = it.toString()
        })


        binding.one.setOnClickListener {
            viewModel.updateOne()
        }
        binding.two.setOnClickListener {
            viewModel.updateTwo()
        }
        binding.three.setOnClickListener {
            viewModel.updateThree()
        }
        binding.four.setOnClickListener {
            viewModel.updateFour()
        }
        binding.five.setOnClickListener {
            viewModel.updateFive()
        }
        binding.six.setOnClickListener {
            viewModel.updateSix()
        }
        binding.seven.setOnClickListener {
            viewModel.updateSeven()
        }
        binding.eight.setOnClickListener {
            viewModel.updateEight()
        }
        binding.nine.setOnClickListener {
            viewModel.updateNine()
        }

        binding.playAgain.setOnClickListener {
            viewModel.reset()
        }

        binding.scoreButton.setOnClickListener {
            val wonPlayerName : String = viewModel.whoWon()
            NavHostFragment.findNavController(this).navigate(GameFragmentDirections.actionGameFragmentToScoreFragment(wonPlayerName))
        }

        return binding.root
    }
}