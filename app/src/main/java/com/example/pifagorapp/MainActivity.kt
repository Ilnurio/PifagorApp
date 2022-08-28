package com.example.pifagorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pifagorapp.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }
// слушатель для кнопки
    fun onClickResult(view: View) {
        if(!isFieldEmpty()) {
            val result = getString(R.string.result_info) + getResult()
            bindingClass.tvResult.text = result
        }
    }

// чтобы вывести ошибку на экран
    private fun isFieldEmpty(): Boolean {
        bindingClass.apply{
            if(edA.text.isNullOrEmpty()) edA.error = getString(R.string.error1)
            if(edB.text.isNullOrEmpty()) edB.error = getString(R.string.error1)
            return edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty()
        }
    }

// функция для вычисления Теоремы Пифагора
    private fun getResult(): String{
       val a:Double
       val b:Double
       bindingClass.apply {
           a = edA.text.toString().toDouble()
           b = edB.text.toString().toDouble()
       }
    return sqrt((a.pow(2) + b.pow(2))).toString()
    }

}