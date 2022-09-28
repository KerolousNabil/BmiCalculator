package com.example.bmicalculator

import android.graphics.Color.parseColor
import android.graphics.Color.red
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.graphics.toColorInt
import java.lang.Math.round
import kotlin.math.roundToInt

class result : AppCompatActivity() {
    private lateinit var textgender : TextView
    private lateinit var texthight : TextView
    private lateinit var textweight : TextView
    private lateinit var textbmi : TextView
    private lateinit var textdevice : TextView
    private lateinit var textcalory: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resulr)

        window.statusBarColor = this.resources.getColor(R.color.backgrounds)
        window.navigationBarColor = this.resources.getColor(R.color.backgrounds)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        textcalory = findViewById(R.id.textgetcalory)
        texthight = findViewById(R.id.textgetheight)
        textweight =  findViewById(R.id.textgetweight)
        textbmi =  findViewById(R.id.textgetbmi)
        textdevice  =  findViewById(R.id.textgetadvice)
        textgender = findViewById(R.id.resulttext)


        texthight.text=  "your height :   "+ intent.getStringExtra("height") +"   cm"
        textweight.text=  "your weight :    "+ intent.getStringExtra("weight") +"   kg"
        textgender.text = "your gender :   "+ intent.getStringExtra("switch")
        var x =intent.getStringExtra("height").toString().toFloat()
        var y = intent.getStringExtra("weight").toString().toFloat()
        var gender = intent.getStringExtra("switch")
        var z = x *  x
        var bmi = (y / z)*10000
        textbmi.text = " your BMI : \n${bmi.toString().subSequence(0,5)}"

        if(bmi<=18.5)
        {
            textdevice.text = "Under weight"
            textdevice.setBackgroundColor(parseColor("#FFC9C9"))


        }

        if(bmi in 18.5..24.9  )
        {
            textdevice.text = "Healthy Weight"
            textdevice.setBackgroundColor(parseColor("#D2FFC9"))
        }
        if (bmi in 25.0 ..29.9) {
            textdevice.text = "Over Weight"
            textdevice.setBackgroundColor(parseColor("#FF5858"))


        }
        if (bmi in 30.0 ..39.9) {
            textdevice.text = "Obesity"
            textdevice.setBackgroundColor(parseColor("#FF1919"))


        }
        if (bmi > 40.0) {
            textdevice.text = "Severe Obesity"
            textdevice.setBackgroundColor(parseColor("#8A0808"))


        }


        if(gender== "male")
        {
            textcalory.text = "your calory :     ${y * 24 * 1} "


        }
        else
        {
            textcalory.text = "your calory :     ${y * 24 * 0.9} "

        }
//
    }
}