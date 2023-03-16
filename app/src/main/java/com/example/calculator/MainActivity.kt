package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //numerics
        btm_0.setOnClickListener {
            setField("0")
        }
        btm_1.setOnClickListener {
            setField("1")
        }
        btm_2.setOnClickListener {
            setField("2")
        }
        btm_3.setOnClickListener {
            setField("3")
        }
        btm_4.setOnClickListener {
            setField("4")
        }
        btm_5.setOnClickListener {
            setField("5")
        }
        btm_6.setOnClickListener {
            setField("6")
        }
        btm_7.setOnClickListener {
            setField("7")
        }
        btm_8.setOnClickListener {
            setField("8")
        }
        btm_9.setOnClickListener {
            setField("9")
        }
        //operation
        btm_pls.setOnClickListener { setFieldo("+") }
        btm_mns.setOnClickListener { setFieldo("-") }
        btm_div.setOnClickListener { setFieldo("/") } /*   if (math_operation.text.last().isDigit()) {
                setField("/")
            }
            if (math_operation.text.last()=='.')
                setField("")
            else {
                val str1 = math_operation.text.toString()
                math_operation.text = str1.substring(0, str1.length - 1)
                setField("/")
            }*/
        btm_mult.setOnClickListener { setFieldo("*") }

        //other actions
        btn_dot.setOnClickListener {
            var mathcycle = math_operation.text.toString()
            val dotz = "."
            if (math_operation.text.toString().last()=='-'||
                math_operation.text.toString().last()=='+'||
                math_operation.text.toString().last()=='/'||
                math_operation.text.toString().last()=='*'||
                math_operation.text.toString().last()=='.'||
                math_operation.text.contains('.'))
            {setField("")}
            else {
                setFieldz(".")
            }
        } //problema s tochkoi
        btm_prsnt.setOnClickListener {
            Toast.makeText(this,
                "Count= " + math_operation.text.count()
                    .toString() + "\nText= " + math_operation.text,
                Toast.LENGTH_LONG
            ).show()
        }
        btm_bck.setOnClickListener {
            val str = math_operation.text.toString()
            if (str.length == 1 || str.isEmpty()) {
                math_operation.text = "0"
            } else {
                math_operation.text = str.substring(0, str.length - 1)
            }
            result_text.text = ""
        }
        btm_plms.setOnClickListener {
            if (math_operation.text == "0" || result_text.text == "0") {
            } else {
                if (result_text.text.isNotEmpty()) {
                    math_operation.text = ""
                    math_operation.text = result_text.text
                    setFieldz("")
                }
                if (math_operation.text[0] == '-') {
                    val rezzz = math_operation.text
                    val rezzzpm = rezzz.toString().drop(1)
                    math_operation.text = ""
                    setFieldz(rezzzpm)
                } else {
                    val resplms = math_operation.text.toString()
                    val rezzzpm = "-" + resplms
                    math_operation.text = ""
                    setFieldz(rezzzpm)
                }
            }
        }
        btm_eq.setOnClickListener {
            try {
                val exp = ExpressionBuilder(math_operation.text.toString()).build()
                val rez = exp.evaluate()
                val longRes = rez.toLong()
                if (rez == longRes.toDouble()) {
                    result_text.text = longRes.toString()
                } else {
                    result_text.text = rez.toString()
                }

            } catch (e: Exception) {
                Log.d("Error", "Message:, ${e.message}")
                if (math_operation.text.last() == '0') {
                    result_text.text = e.message
                }
            }
        }
        btm_clr.setOnClickListener {
            math_operation.text = "0"
            result_text.text = ""
        }
    }

    fun setField(str: String) {
        if (result_text.text != "") {
            math_operation.text = result_text.text
            result_text.text = ""
        }
        if (math_operation.text[0] == '0' && math_operation.text.count() == 1) {
            math_operation.text = ""
            math_operation.append(str)
        } else {
            math_operation.append(str)
        }
    } //function for numerics

    fun setFieldo(stro: String) {
        if (result_text.text != "") {
            math_operation.text = result_text.text
            result_text.text = ""
        }
        if (math_operation.text.last().isDigit()) {
            math_operation.append(stro)
        }
        if (math_operation.text.last() == '.') {
        } else {
            val str1 = math_operation.text.toString()
            math_operation.text = str1.substring(0, str1.length - 1)
            math_operation.append(stro)
        }
    } //function for operation

    fun setFieldz(strz: String) {
        if (result_text.text != "") {
            math_operation.text = result_text.text
            result_text.text = ""
        }
        math_operation.append(strz)
    }
    fun fieldDotControl (strd: String)
    {

    }
}