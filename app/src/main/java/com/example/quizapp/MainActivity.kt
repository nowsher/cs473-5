package com.example.quizapp

import android.os.Bundle
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ///////////////////////////////////
//        var c = flag()
        button.setOnClickListener {

            var dt: Date = Date()

            //radioGroup.check(radioButton3.id)
            var score: Double = 0.0
            if (radioButton3.isChecked) {
                score += 50.0
            }

            if (checkBox1.isChecked) {
                score += 16.66
            }
            if (checkBox2.isChecked) {
                score += 16.66
            }
            if (checkBox3.isChecked) {
                score += 16.66
            }
            //var df:DecimalFormat = DecimalFormat("#.##")
            //df.format(score)
            var roundScore:Int = score.roundToInt()

            if (roundScore > 0) {
                var builder = AlertDialog.Builder(this)
                builder.setTitle("Congratulations!")
                builder.setMessage("You submitted on: $dt . \r\n You achieved: $roundScore%")
                builder.setIcon(R.drawable.ic_launcher_foreground)

                builder.setPositiveButton("OK") { dialogueInterface, whichId ->
                    dialogueInterface.dismiss()
                    finish()
                }
                builder.setNegativeButton("Cancel") { dialogueInterface, whichId ->
                    dialogueInterface.dismiss()
                }
                builder.setNeutralButton("Do nothing") { dialogueInterface, whichId ->

                }

                var dialogue: AlertDialog = builder.create()
                dialogue.show()

            }
        }

        button2.setOnClickListener { abc ->
            radioGroup.clearCheck();

            for (i in 0 until radioGroup1.childCount) {
                val o = radioGroup1.getChildAt(i)
                if (o is CheckBox) {
                    o.isChecked = false
                }
            }

            Toast.makeText(this,"Answers were reset",Toast.LENGTH_LONG).show()

//            checkBox1.isChecked=false
//            checkBox2.isChecked=false
//            checkBox3.isChecked=false
        }


    }
//    fun flag(): Boolean {
//        return true
//    }
}