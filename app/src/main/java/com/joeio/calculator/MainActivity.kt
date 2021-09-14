package com.joeio.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.joeio.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var operatorStringList = mutableListOf<Char>('+', '-', 'x', '÷', '^')
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var showString: String = "0"
        var operatorString: String = ""
        binding.showWindow.text = showString
        binding.btn0.setOnClickListener {
            if (showString != "0"){
                showString+="0"
            }
            binding.showWindow.text = showString
        }
        binding.btn1.setOnClickListener {
            if (showString == "0"){
                showString = "1"
                binding.showWindow.text = showString
            }else{
                showString+="1"
                binding.showWindow.text = showString
            }
        }
        binding.btn2.setOnClickListener {
            if (showString == "0"){
                showString = "2"
                binding.showWindow.text = showString
            }else{
                showString+="2"
                binding.showWindow.text = showString
            }
        }
        binding.btn3.setOnClickListener {
            if (showString == "0"){
                showString = "3"
                binding.showWindow.text = showString
            }else{
                showString+="3"
                binding.showWindow.text = showString
            }
        }
        binding.btn4.setOnClickListener {
            if (showString == "0"){
                showString = "4"
                binding.showWindow.text = showString
            }else{
                showString+="4"
                binding.showWindow.text = showString
            }
        }
        binding.btn5.setOnClickListener {
            if (showString == "0"){
                showString = "5"
                binding.showWindow.text = showString
            }else{
                showString+="5"
                binding.showWindow.text = showString
            }
        }
        binding.btn6.setOnClickListener {
            if (showString == "0"){
                showString = "6"
                binding.showWindow.text = showString
            }else{
                showString+="6"
                binding.showWindow.text = showString
            }
        }
        binding.btn7.setOnClickListener {
            if (showString == "0"){
                showString = "7"
                binding.showWindow.text = showString
            }else{
                showString+="7"
                binding.showWindow.text = showString
            }
        }
        binding.btn8.setOnClickListener {
            if (showString == "0"){
                showString = "8"
                binding.showWindow.text = showString
            }else{
                showString+="8"
                binding.showWindow.text = showString
            }
        }
        binding.btn9.setOnClickListener {
            if (showString == "0"){
                showString = "9"
                binding.showWindow.text = showString
            }else{
                showString+="9"
                binding.showWindow.text = showString
            }
        }
        binding.btnPoint.setOnClickListener {
            showString+="."
            binding.showWindow.text = showString
        }
        binding.btnPlus.setOnClickListener {
            if(operatorString.isEmpty() and showString.isNotEmpty()){
                operatorString = "+"
                showString+=operatorString
                showString+="\n"
                binding.showWindow.text = showString
            }
        }
        binding.btnMinus.setOnClickListener {
            if(operatorString.isEmpty() and showString.isNotEmpty()){
                operatorString = "-"
                showString+=operatorString
                showString+="\n"
                binding.showWindow.text = showString
            }
        }
        binding.btnMultiply.setOnClickListener {
            if(operatorString.isEmpty() and showString.isNotEmpty()){
                operatorString = "x"
                showString+=operatorString
                showString+="\n"
                binding.showWindow.text = showString
            }
        }
        binding.btnDivide.setOnClickListener {
            if(operatorString.isEmpty() and showString.isNotEmpty()){
                operatorString = "÷"
                showString+=operatorString
                showString+="\n"
                binding.showWindow.text = showString
            }
        }
        binding.btnPower.setOnClickListener {
            if(operatorString.isEmpty() and showString.isNotEmpty()){
                operatorString = "^"
                showString+=operatorString
                showString+="\n"
                binding.showWindow.text = showString
            }
        }
        binding.btnClear.setOnClickListener {
            binding.showWindow.text = "0"
            operatorString = ""
            showString = "0"
        }
        binding.btnDelete.setOnClickListener {
            if (showString != "0"){
                showString = showString.substring(0,showString.length-1)
                binding.showWindow.text = showString
                if (showString.isEmpty()){
                    showString = "0"
                    binding.showWindow.text = showString
                }
                if(!this.operatorIsInString(showString)){
                    operatorString = ""
                }
            }
        }
        binding.btnEqual.setOnClickListener {
            var numberPair = this.parseString(showString)
            var numberLeft = numberPair.first.toBigDecimal()
            var numberRight = numberPair.second.toBigDecimal()
            var result = when (operatorString){
                "+" -> numberLeft.plus(numberRight)
                "-" -> numberLeft.minus(numberRight)
                "x" -> numberLeft.multiply(numberRight)
                "÷" -> numberLeft.divide(numberRight)
                "^" -> numberLeft.pow(numberRight.toInt())
                else -> 0
            }
            showString += "\n"+result
            binding.showWindow.text = showString
        }
    }

    private fun operatorIsInString(str: String): Boolean {
        operatorStringList.forEach{
            if (str.contains(it)){
                return true
            }
        }
        return false
    }

    private fun parseString(str: String) : Pair<String, String> {
        var numberLeft = ""
        var numberRight = ""
        var flag = false
        str.forEach {
            if (this.operatorStringList.contains(it)){
                flag = true
            }else{
                if (flag) {
                    numberRight += it
                }else{
                    numberLeft += it
                }
            }
        }
        if (numberRight.isEmpty()){
            numberRight = "0"
        }
        return Pair(numberLeft.replace("\n", ""), numberRight.replace("\n", ""))
    }
}