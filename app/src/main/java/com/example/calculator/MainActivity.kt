package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.text.isDigitsOnly
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //numerics
        btm_0.setOnClickListener {
            if (math_operation.text != "0" )
                setField("0")
            else{
                setField("")
            }
        }
        btm_1.setOnClickListener {
            if (math_operation.text != "0")
                setField("1")
            else {
                math_operation.text = ""
                setField("1")
            }
        }
        btm_2.setOnClickListener {
            if (math_operation.text != "0")
                setField("2")
            else {
                math_operation.text = ""
                setField("2")
            }
        }
        btm_3.setOnClickListener {
            if (math_operation.text != "0")
                setField("3")
            else {
                math_operation.text = ""
                setField("3")
            }
        }
        btm_4.setOnClickListener {
            if (math_operation.text != "0")
                setField("4")
            else {
                math_operation.text = ""
                setField("4")
            }
        }
        btm_5.setOnClickListener {
            if (math_operation.text != "0")
                setField("5")
            else {
                math_operation.text = ""
                setField("5")
            }
        }
        btm_6.setOnClickListener {
            if (math_operation.text != "0")
                setField("6")
            else {
                math_operation.text = ""
                setField("6")
            }
        }
        btm_7.setOnClickListener {
            if (math_operation.text != "0")
                setField("7")
            else {
                math_operation.text = ""
                setField("7")
            }
        }
        btm_8.setOnClickListener {
            if (math_operation.text != "0")
                setField("8")
            else {
                math_operation.text = ""
                setField("8")
            }
        }
        btm_9.setOnClickListener {
            if (math_operation.text != "0")
                setField("9")
            else {
                math_operation.text = ""
                setField("9")
            }
        }
        //operation
        btm_pls.setOnClickListener {
            if (math_operation.text.last().isDigit()) {
                setField("+")
            }
            if (math_operation.text.last()=='.')
                setField("")
            else {
                val str1 = math_operation.text.toString()
                math_operation.text = str1.substring(0, str1.length - 1)
                setField("+")
            }
        }

        btm_mns.setOnClickListener {
            if (math_operation.text.last().isDigit()) {
                setField("-")
            }
            if (math_operation.text.last()=='.')
                setField("")
            else {
                val str1 = math_operation.text.toString()
                math_operation.text = str1.substring(0, str1.length - 1)
                setField("-")
            }
        }
        btm_div.setOnClickListener {

            if (math_operation.text.last().isDigit()) {
                setField("/")
            }
            if (math_operation.text.last()=='.')
                setField("")
            else {
                val str1 = math_operation.text.toString()
                math_operation.text = str1.substring(0, str1.length - 1)
                setField("/")
            }
        }
        btm_mult.setOnClickListener {
            if (math_operation.text.last().isDigit()) {
                setField("*")
            }
            if (math_operation.text.last()=='.')
                setField("")
            else {
                val str1 = math_operation.text.toString()
                math_operation.text = str1.substring(0, str1.length - 1)
                setField("*")
            }
        }
        btn_dot.setOnClickListener {
            //if (math_operation.text.first()=='0' ||
            //    math_operation.text == "")
            //   setField("")
            val dotz = "."
            if (math_operation.text.toString().contains(dotz))
                setField("")
            //if (math_operation.text.toString().last() != '.')
            //if (math_operation.text.toString().last() == '/') setField("")
            //if (math_operation.text.toString().last() == '-') setField("")
            //if (math_operation.text.toString().last() == '*') setField("")
            //if (math_operation.text.toString().last() == '+') setField("")
            //if (math_operation.text.first()=='.')
             //   setField("")
            else {
                setField(".")
            }

        }
        btm_bck.setOnClickListener {
            val str = math_operation.text.toString()
            if (str == "0" || str.isEmpty()) {
                setField("0")
            } else {
                math_operation.text = str.substring(0, str.length - 1)
            }
            result_text.text = ""
        }
        btm_plms.setOnClickListener {
            if(result_text.text.isNotEmpty())
            {
                math_operation.text=""
                math_operation.text = result_text.text
                setField("")
            }
            if (math_operation.text[0] == '-')
            {
                val rezzz = math_operation.text
                val rezzzpm = rezzz.toString().drop(1)
                math_operation.text=""
                setField(rezzzpm)
            }
            else {
                val resplms = math_operation.text.toString()
                val rezzzpm = "-" + resplms
                math_operation.text=""
                setField(rezzzpm)
            }
        } //vse zbs
        btm_eq.setOnClickListener {
            try {
                val exp = ExpressionBuilder(math_operation.text.toString()).build()
                val rez = exp.evaluate()
                val longRes = rez.toLong()
                if (rez == longRes.toDouble()) {
                    result_text.text = longRes.toString()
                   // math_operation.text = "???"
                } else {
                    result_text.text = rez.toString()
                   // math_operation.text = "???"
                }

            } catch (e: Exception) {
                Log.d("Error", "Message:, ${e.message}")
                if (math_operation.text.last()=='0')
                {
                    result_text.text =e.message
                }
            }
        }
        btm_clr.setOnClickListener {
            math_operation.text = "0"
            result_text.text = ""
        }
    }

    fun setField(str: String) {
        if (result_text.text !="") {
            math_operation.text = result_text.text
            result_text.text = ""
        }
        math_operation.append(str)

        if (math_operation.text.length >=1 && math_operation.text[0]=='0') {
            val dropz = math_operation.text.drop(1)
            math_operation.text = dropz.toString()
        }
    }

}