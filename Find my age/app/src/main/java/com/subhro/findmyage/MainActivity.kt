package com.subhro.findmyage

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Find.setOnClickListener{
            try{
                var Mydate:Int = Age.text!!.toString().toInt()
                var Cul= Calendar.getInstance()

                var curYear=Cul.get(Calendar.YEAR)
                if(Mydate >= curYear){
                    show.setText("The date isn't Valid")
                    Age.setText("")
                }
                else if(Mydate <(curYear-100)){
                    show.setText("The date isn't Valid")
                    Age.setText("")
                }

                else {
                    var age: Int = curYear - Mydate
                    show.setText("Your Age is $age")
                }
            }
            catch (e:Exception){

            }
        }

    }
    fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)

    fun resetText(view:View) = try {
        show.setText("")
        Age.setText("")
    }
    catch (ex:Exception){
        show.setText(ex.message.toString())
    }
}
