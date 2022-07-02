package com.example.hw01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() { //

    // входные данные
    private var name: EditText? = null
    private var height: EditText? = null
    private var weight: EditText? = null
    private var age: EditText? = null

    // кнопка
    private var buttonCalculate: Button? = null

    // данные которые будет менять
    private var pointBMI: TextView? = null

    // сообщение для ошибки


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = findViewById(R.id.name)
        height = findViewById(R.id.height)
        weight = findViewById(R.id.weight)
        age = findViewById(R.id.age)
        buttonCalculate = findViewById(R.id.buttonCalculate)
        pointBMI = findViewById(R.id.pointBMI)

        fun messageError() {
            Toast.makeText(this, "Error", Toast.LENGTH_LONG)
                .show()
        }

        buttonCalculate?.setOnClickListener {
            var peopleWeight = 0F
            var peopleHeight = 0F


            try {

                if (name!!.length() > 50) messageError()

                if (weight!!.text.toString().toInt() <= 0 || weight!!.text.toString()
                        .toInt() > 250
                ) {
                    messageError()
                }else{
                    peopleWeight = weight!!.text.toString().toFloat()
                }

                if (height!!.text.toString().toInt() <= 0 || height!!.text.toString()
                        .toInt() > 250
                ) {
                    messageError()
                } else {
                    peopleHeight = height!!.text.toString().toFloat() / 100
                }

                if (age!!.text.toString().toInt() <= 0 || age!!.text.toString()
                        .toInt() > 150
                ) messageError()

                val point: Float = peopleWeight / (peopleHeight * peopleHeight)

                pointBMI?.text = "$point"

            } catch (e: NumberFormatException) {
                messageError()
            } catch (e: NullPointerException) {
                messageError()
            }
        }
    }
}