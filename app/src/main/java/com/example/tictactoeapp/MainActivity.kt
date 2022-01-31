package com.example.tictactoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buClick(view: View){
        val buSelected:Button=view as Button

        var cellId=0
        when(buSelected.id){
            R.id.btn1->cellId=1
            R.id.btn2->cellId=2
            R.id.btn3->cellId=3
            R.id.btn4->cellId=4
            R.id.btn5->cellId=5
            R.id.btn6->cellId=6
            R.id.btn7->cellId=7
            R.id.btn8->cellId=8
            R.id.btn9->cellId=9
        }
//        Log.d("buClick:",buSelected.id.toString())
//        Log.d("buClick:cellId:",cellId.toString())
        playGame(cellId,buSelected)
    }

    private var activePlayer=1
    private var player1=ArrayList<Int>()
    private var player2=ArrayList<Int>()

    private fun playGame(cellId:Int, buSelected:Button)
    {
        if(activePlayer==1)
        {
            buSelected.text="X"
            buSelected.setBackgroundResource(R.color.black)
            player1.add(cellId)
            activePlayer=2
        }else
        {
            buSelected.text="0"
            buSelected.setBackgroundResource(R.color.black)
            player2.add(cellId)
            activePlayer=1
        }
        buSelected.isEnabled=false

        checkWinner()
    }

    private fun checkWinner(){
        var winner=-1

        //row1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3))
        {
            winner=1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3))
        {
            winner=2
        }

        //row2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6))
        {
            winner=1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6))
        {
            winner=2
        }

        //row3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9))
        {
            winner=1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9))
        {
            winner=2
        }

        //col1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7))
        {
            winner=1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7))
        {
            winner=2
        }

        //col2
        if(player1.contains(2) && player1.contains(5) && player1.contains(3))
        {
            winner=1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8))
        {
            winner=2
        }

        //col3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9))
        {
            winner=1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9))
        {
            winner=2
        }

        if(winner==1)
        {
            Toast.makeText(this,"Player 1 is the winner",Toast.LENGTH_SHORT).show()
        }
        else if(winner==2){
            Toast.makeText(this,"Player 2 is the winner",Toast.LENGTH_SHORT).show()
        }
    }
}