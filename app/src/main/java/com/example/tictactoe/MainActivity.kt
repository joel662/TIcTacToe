package com.example.tictactoe

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.R.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var b0: Button
    lateinit var b1: Button
    lateinit var b2: Button
    lateinit var b3: Button
    lateinit var b4: Button
    lateinit var b5: Button
    lateinit var b6: Button
    lateinit var b7: Button
    lateinit var b8: Button
    lateinit var restart: Button

    var gameActive = true
    lateinit var txt : TextView
    var filledPos = intArrayOf(-1,-1,-1,-1,-1,-1,-1,-1,-1)
    var turn = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt = findViewById(R.id.textView2)
        b0 = findViewById(R.id.b0)
        b1 = findViewById(R.id.b1)
        b2 = findViewById(R.id.b2)
        b3 = findViewById(R.id.b3)
        b4 = findViewById(R.id.b4)
        b5 = findViewById(R.id.b5)
        b6= findViewById(R.id.b6)
        b7 = findViewById(R.id.b7)
        b8 = findViewById(R.id.b8)
        restart = findViewById(R.id.restart)

        b0.setOnClickListener(this)
        b1.setOnClickListener(this)
        b2.setOnClickListener(this)
        b3.setOnClickListener(this)
        b4.setOnClickListener(this)
        b5.setOnClickListener(this)
        b6.setOnClickListener(this)
        b7.setOnClickListener(this)
        b8.setOnClickListener(this)
        restart.setOnClickListener{
            restartGame()
        }
    }
    @SuppressLint("ResourceAsColor")
    private fun restartGame(){
        gameActive = true
        b0.setText("")
        b1.setText("")
        b2.setText("")
        b3.setText("")
        b4.setText("")
        b5.setText("")
        b6.setText("")
        b7.setText("")
        b8.setText("")
        turn = 0
        filledPos = intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1)
        b0.setBackgroundColor(color.design_default_color_primary)
        b1.setBackgroundColor(color.design_default_color_primary)
        b2.setBackgroundColor(color.design_default_color_primary)
        b3.setBackgroundColor(color.design_default_color_primary)
        b4.setBackgroundColor(color.design_default_color_primary)
        b5.setBackgroundColor(color.design_default_color_primary)
        b6.setBackgroundColor(color.design_default_color_primary)
        b7.setBackgroundColor(color.design_default_color_primary)
        b8.setBackgroundColor(color.design_default_color_primary)
        txt.setText("Player-1's turn")
    }

    override fun onClick(v: View?) {
        var bClicked = findViewById<Button>(v!!.id)
        var clickedTag = Integer.parseInt(bClicked.tag.toString())

        if(!gameActive)
            return
        if(filledPos[clickedTag] != -1)
            return

        if(turn%2 ==0){
            bClicked.setText("X")
            txt.setText("Player-2's turn")
            turn++
            filledPos[clickedTag] = 1
            bClicked.setTextColor(Color.BLACK)
            bClicked.setBackgroundColor(Color.CYAN)
        }else{
            bClicked.setText("0")
            txt.setText("Player-1's turn")
            turn++
            filledPos[clickedTag] = 2
            bClicked.setTextColor(Color.WHITE)
            bClicked.setBackgroundColor(Color.BLUE)
        }
        checkWin()


    }
    private fun checkWin(){
        var winPos = arrayOf(intArrayOf(0,1,2),intArrayOf(3,4,5),intArrayOf(6,7,8),
            intArrayOf(0,3,6),intArrayOf(1,4,7),intArrayOf(2,5,8),
            intArrayOf(0,4,8), intArrayOf(2,4,6))
        for(i in 0 until winPos.size ){
            var val0 = winPos[i][0]
            var val1 = winPos[i][1]
            var val2 = winPos[i][2]
            if(turn == 9)
                txt.setText("It's a tie")

            if(filledPos[val0] == filledPos[val1] && filledPos[val1] == filledPos[val2]){
                if(filledPos[val0] != -1){
                    gameActive = false
                    if(filledPos[val0] == 1){
                        txt.setText("PLAYER 1 WINS")
                    }
                    else{
                        txt.setText("PLAYER 2 WINS")
                    }
                    return

                }

            }
        }

    }




}


