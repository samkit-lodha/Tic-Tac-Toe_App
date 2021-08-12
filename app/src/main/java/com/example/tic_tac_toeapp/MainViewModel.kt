package com.example.tic_tac_toeapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val s1 : String,private val s2 : String) : ViewModel() {

    private var score1dumy : Int = 0
    private var score2dumy : Int = 0

    private var playerOneName : String = s1
    private var playerTwoName : String = s2

    private lateinit var gridVisited : MutableList<Boolean>
    private lateinit var gridValue : MutableList<String>

    var oneView = MutableLiveData<String>("")
    var twoView = MutableLiveData<String>("")
    var threeView = MutableLiveData<String>("")
    var fourView = MutableLiveData<String>("")
    var fiveView = MutableLiveData<String>("")
    var sixView = MutableLiveData<String>("")
    var sevenView = MutableLiveData<String>("")
    var eightView = MutableLiveData<String>("")
    var nineView = MutableLiveData<String>("")

    var score1 = MutableLiveData<Int>(0)
    var score2 = MutableLiveData<Int>(0)

    var currPlayer = MutableLiveData<String>("")

    init {
        currPlayer.value = playerOneName
        reset()
    }

    fun reset(){

        gridVisited = mutableListOf(
            false,false,false,false,false,false,false,false,false
        )

        gridValue = mutableListOf(
            "","","","","","","","",""
        )

        oneView.value = ""
        twoView.value = ""
        threeView.value = ""
        fourView.value = ""
        fiveView.value = ""
        sixView.value = ""
        sevenView.value = ""
        eightView.value = ""
        nineView.value = ""
    }



    var setXO : String = "X"

    fun setXOvalue(){
        if(setXO == "X"){
            setXO = "O"
        }
        else{
            setXO = "X"
        }
    }

    fun setCurrPlayer(){
        if(setXO.equals("X")){
            currPlayer.value = playerOneName
        }
        else{
            currPlayer.value = playerTwoName
        }
    }

    fun updateOne() {
        if(!gridVisited[0]){
            oneView.value = setXO
            gridValue[0] = setXO
            gridVisited[0] = true
            checkWin()
            setXOvalue()
            setCurrPlayer()
        }
    }
    fun updateTwo() {
        if(!gridVisited[1]){
            twoView.value = setXO
            gridValue[1] = setXO
            gridVisited[1] = true
            checkWin()
            setXOvalue()
            setCurrPlayer()
        }
    }
    fun updateThree() {
        if(!gridVisited[2]){
            threeView.value = setXO
            gridValue[2] = setXO
            gridVisited[2] = true
            checkWin()
            setXOvalue()
            setCurrPlayer()
        }
    }
    fun updateFour() {
        if(!gridVisited[3]){
            fourView.value = setXO
            gridValue[3] = setXO
            gridVisited[3] = true
            checkWin()
            setXOvalue()
            setCurrPlayer()
        }
    }
    fun updateFive() {
        if(!gridVisited[4]){
            fiveView.value = setXO
            gridValue[4] = setXO
            gridVisited[4] = true
            checkWin()
            setXOvalue()
            setCurrPlayer()
        }
    }
    fun updateSix() {
        if(!gridVisited[5]){
            sixView.value = setXO
            gridValue[5] = setXO
            gridVisited[5] = true
            checkWin()
            setXOvalue()
            setCurrPlayer()
        }
    }
    fun updateSeven() {
        if(!gridVisited[6]){
            sevenView.value = setXO
            gridValue[6] = setXO
            gridVisited[6] = true
            checkWin()
            setXOvalue()
            setCurrPlayer()
        }
    }
    fun updateEight() {
        if(!gridVisited[7]){
            eightView.value = setXO
            gridValue[7] = setXO
            gridVisited[7] = true
            checkWin()
            setXOvalue()
            setCurrPlayer()
        }
    }
    fun updateNine() {
        if(!gridVisited[8]){
            nineView.value = setXO
            gridValue[8] = setXO
            gridVisited[8] = true
            checkWin()
            setXOvalue()
            setCurrPlayer()
        }
    }

    fun checkWin() {
        var flag = false
        if(gridValue[0]==gridValue[1] && gridValue[0]==gridValue[2] && gridValue[0]!=""){
            flag = true
        }
        if(gridValue[3]==gridValue[4] && gridValue[3]==gridValue[5] && gridValue[3]!=""){
            flag = true
        }
        if(gridValue[6]==gridValue[7] && gridValue[6]==gridValue[8] && gridValue[6]!=""){
            flag = true
        }
        if(gridValue[0]==gridValue[3] && gridValue[0]==gridValue[6] && gridValue[0]!=""){
            flag = true
        }
        if(gridValue[1]==gridValue[4] && gridValue[1]==gridValue[7] && gridValue[1]!=""){
            flag = true
        }
        if(gridValue[2]==gridValue[5] && gridValue[2]==gridValue[8] && gridValue[2]!=""){
            flag = true
        }
        if(gridValue[0]==gridValue[4] && gridValue[0]==gridValue[8] && gridValue[0]!=""){
            flag = true
        }
        if(gridValue[2]==gridValue[4] && gridValue[2]==gridValue[6] && gridValue[2]!=""){
            flag = true
        }

        if(flag){
            if(setXO.equals("X")){
                score1dumy++
                score1.value = score1dumy
            }
            else{
                score2dumy++
                score2.value = score2dumy
            }
            reset()
        }
    }

    fun whoWon() : String {
        if(score1dumy > score2dumy){
            return playerOneName
        }
        else if(score1dumy < score2dumy){
            return playerTwoName
        }
        return "Its a tie! No one"
    }
}