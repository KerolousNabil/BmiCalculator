package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var countheght = 20
    var countweight = 60
    private lateinit var editswitch : Switch
    private lateinit var edittextheight : TextView
    private lateinit var edittextweight : TextView
    private lateinit var btncalculat: Button
    private lateinit var addheight: ImageButton
    private lateinit var minusheight: ImageButton
    private lateinit var minusweight: ImageButton
    private lateinit var addweight: ImageButton



    var t = mytools(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.statusBarColor = this.resources.getColor(R.color.backgrounds)
        window.navigationBarColor = this.resources.getColor(R.color.backgrounds)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }


        textheightview.text ="180"
        textweightview.text = "60"
        edittextweight = findViewById(R.id.textweightview)
        edittextheight = findViewById(R.id.textheightview)
        btncalculat =   findViewById(R.id.btncalc)
        editswitch =  findViewById(R.id.switchgender)






        seekBar_hight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textheightview.text = p1.toString()            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }


        })

        seekbar_wight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textweightview.text = p1.toString()            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }


        })




        editswitch.setOnCheckedChangeListener{ btn , check ->
            if (check)
            {
                btn.setText("female")

            }
            else {
                btn.setText("male")
            }

        }


        btncalculat.setOnClickListener {
           startActivity(
                Intent(this, result::class.java)
                    .putExtra("height", edittextheight.text.toString())
                    .putExtra("weight", edittextweight.text.toString())
                    .putExtra("switch",editswitch.text.toString())
            )


        }




    }
}