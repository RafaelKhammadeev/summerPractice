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
        pointBMI = findViewById(R.id.BMI_point)

        fun messageError() {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
        }

        buttonCalculate?.setOnClickListener {
            try {
                val peopleName: Int = name!!.length() // если будет null то выкенет null pointer exception
                val peopleWeight: Int = weight!!.text.toString().toInt()
                val peopleHeight: Int = height!!.text.toString().toInt()
                val peopleAge: Int = age!!.text.toString().toInt()

                if (peopleName <= 0 || peopleName > 50) messageError()

                if (peopleHeight <= 0 || peopleHeight > 250) messageError()

                if (peopleWeight <= 0 || peopleWeight > 250) messageError()

                if (peopleAge <= 0 || peopleAge > 150) messageError()

                val point: Int = peopleWeight / (peopleHeight * peopleHeight)

                pointBMI?.text = "$point"
            } catch (e: NumberFormatException) {
                messageError()
            }
        }
    }
}