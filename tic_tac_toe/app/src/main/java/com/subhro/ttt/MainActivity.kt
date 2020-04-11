package com.subhro.ttt

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    private var player:Int = 1
    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()
    private var buttonSeted= arrayListOf<Int>(R.id.bu1,R.id.bu2,R.id.bu3,R.id.bu4,R.id.bu5,R.id.bu6,R.id.bu7,R.id.bu8,R.id.bu9)
    private fun disableButtons(){
        for(x in this.buttonSeted){
            val m=findViewById<Button>(x)
            m.isEnabled=false
        }
    }

    fun SetValueonClick(view: View) {
        val buttonSelected: Button = view as Button
        val buttonId:Int
        when(buttonSelected.id ){

            R.id.bu1->buttonId=1
            R.id.bu2->buttonId=2
            R.id.bu3->buttonId=3
            R.id.bu4->buttonId=4
            R.id.bu5->buttonId=5
            R.id.bu6->buttonId=6
            R.id.bu7->buttonId=7
            R.id.bu8->buttonId=8
            R.id.bu9->buttonId=9
            else->{
                buttonId=0
            }
        }
        play(buttonId,buttonSelected)

    }
    fun play(buttonId:Int,buttonSelected: Button){
        if(this.player==1){

            buttonSelected.isEnabled=false
            buttonSelected.textSize=50.0f
            buttonSelected.setBackgroundColor(resources.getColor(R.color.coral))
            buttonSelected.setTextColor(Color.BLACK)
            buttonSelected.text="X"
            player1.add(buttonId)
            player=2
            if(!findWinner()){
                autoplay()
            }
        }
        else{

            buttonSelected.isEnabled=false
            buttonSelected.textSize=50.0f
            buttonSelected.setBackgroundColor(resources.getColor(R.color.turquoise))
            buttonSelected.setTextColor(Color.BLACK)
            buttonSelected.text="O"
            player2.add(buttonId)
            player=1
            findWinner()
        }

       // Toast.makeText(this,"ID : $buttonId",Toast.LENGTH_LONG).show()


    }
    fun findWinner():Boolean{
        var flag=false
        if(player1.contains(1)&&player1.contains(2)&&player1.contains(3)){
            Winner.text=getString(R.string.winner_is_player_1)
            flag=true
        }
        if(player1.contains(4)&&player1.contains(5)&&player1.contains(6)){
            Winner.text=getString(R.string.winner_is_player_1)
            flag=true
        }
        if(player1.contains(7)&&player1.contains(8)&&player1.contains(9)){
            Winner.text=getString(R.string.winner_is_player_1)
            flag=true
        }
        if(player1.contains(1)&&player1.contains(4)&&player1.contains(7)){
            Winner.text=getString(R.string.winner_is_player_1)
            flag=true
        }
        if(player1.contains(2)&&player1.contains(5)&&player1.contains(8)){
            Winner.text=getString(R.string.winner_is_player_1)
            flag=true
        }
        if(player1.contains(3)&&player1.contains(6)&&player1.contains(9)){
            Winner.text=getString(R.string.winner_is_player_1)
            flag=true
        }
        if(player2.contains(1)&&player2.contains(2)&&player2.contains(3)){
            Winner.text=getString(R.string.winner_is_player_2)
            flag=true
        }
        if(player2.contains(4)&&player2.contains(5)&&player2.contains(6)){
            Winner.text=getString(R.string.winner_is_player_2)
            flag=true
        }
        if(player2.contains(7)&&player2.contains(8)&&player2.contains(9)){
            Winner.text=getString(R.string.winner_is_player_2)
            flag=true
        }
        if(player2.contains(1)&&player2.contains(4)&&player2.contains(7)){
            Winner.text=getString(R.string.winner_is_player_2)
            flag=true
        }
        if(player2.contains(2)&&player2.contains(5)&&player2.contains(8)){
            Winner.text=getString(R.string.winner_is_player_2)
            flag=true

        }
        if(player2.contains(3)&&player2.contains(6)&&player2.contains(9)){
            Winner.text=getString(R.string.winner_is_player_2)
            flag=true
        }
        if(flag){
            disableButtons()
        }
        return flag
    }

    fun autoplay(){
        val moves= ArrayList<Int>()
        for( i in 1..9){
           if( player1.contains(i)){
               continue
           }
            else if(player2.contains(i)){
               continue
           }
            else{
               moves.add(i)
           }
        }
        val r = Random()
        val buttonSelect:Button?
        try{
            val index=r.nextInt(moves.size-0)+0
            when(moves[index]){
                1->buttonSelect=bu1
                2->buttonSelect=bu2
                3->buttonSelect=bu3
                4->buttonSelect=bu4
                5->buttonSelect=bu5
                6->buttonSelect=bu6
                7->buttonSelect=bu7
                8->buttonSelect=bu8
                9->buttonSelect=bu9
                else->{
                    buttonSelect=bu1
                }
            }
            play(moves[index],buttonSelect)
        }
        catch(ex:Exception){
            Winner.text=getString(R.string.Draw)
        }

    }

    fun quit(view: View) {
        exitProcess(0)
    }
    fun restart(view: View){
        for(buttons in buttonSeted){
            player1.removeAll(player1)
            player2.removeAll(player2)
            val m=findViewById<Button>(buttons)
            m.setBackgroundColor(resources.getColor(R.color.white))
            m.text=""
            m.isEnabled=true
            player=1
            Winner.text=""
        }
    }
}
