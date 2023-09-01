package org.dna.personalcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import java.lang.ArithmeticException

class ActivityCalculator : AppCompatActivity() {

    private var txtInput: TextInputEditText? = null
    private var txtResult: TextInputEditText? = null

    private var btnAddition: MaterialButton? = null
    private var btnSubtract: MaterialButton? = null
    private var btnDivide: MaterialButton? = null
    private var btnMultiply: MaterialButton? = null

    private var btnEquals: MaterialButton? = null
    private var btnPoint: MaterialButton? = null
    private var btnClear: MaterialButton? = null
    private var btnPercent: MaterialButton? = null

    private var lbNumeric: Boolean = false
    private var lbLastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        initWidgets()
        initButtonActions()
    }

    private fun initWidgets(){
        txtInput = findViewById(R.id.txt_CalculatorInput)
        txtResult = findViewById(R.id.txt_CalculatorResult)
        btnAddition = findViewById(R.id.btn_addition)
        btnSubtract = findViewById(R.id.btn_subtract)
        btnDivide = findViewById(R.id.btn_divide)
        btnMultiply = findViewById(R.id.btn_multiply)
        btnEquals = findViewById(R.id.btn_equals)
        btnPoint = findViewById(R.id.btn_point)
        btnPercent = findViewById(R.id.btn_percent)
        btnClear = findViewById(R.id.btn_clear)
    }

    fun initNumericButtons(view: View) {
        txtInput?.append((view as MaterialButton).text)
        lbNumeric = true
        lbLastDot = false
    }

    private fun initButtonActions(){
        btnClear?.setOnClickListener {
            txtInput?.setText("")
        }
    }

    fun initOperators(view: View) {
        txtInput?.text?.let {
            if (lbNumeric && !isOperatorAdded(it.toString())){
                txtInput?.append((view as MaterialButton).text)
                lbNumeric = false
                lbLastDot = false
            }
        }
//        txtInput?.append((view as MaterialButton).text)
    }

    fun onDecimalPoint(view: View) {
        if(lbNumeric && !lbLastDot){
            txtInput?.append(".")
            lbNumeric = false
            lbLastDot = true
        }
    }
    private fun isOperatorAdded(fsValue: String) : Boolean{
        return if(fsValue.startsWith("-")){
            false
        } else {
            fsValue.contains("/")
                    || fsValue.contains("*")
                    || fsValue.contains("+")
                    || fsValue.contains("-")
        }
    }

    fun onCalculate(view: View) {
        if(lbNumeric){
            var lsInput = txtInput?.text.toString()
            var lsPrefix = ""

            try{
                if(lsInput.startsWith("-")){
                    lsPrefix = "-"
                    lsInput = lsInput.substring(1)
                }

                if(lsInput.contains("-")) {

                    val laSplitVal = lsInput.split("-")
                    var lsFirst = laSplitVal[0]
                    var lsSecnd = laSplitVal[1]

                    if(lsPrefix.isNotEmpty()){
                        lsFirst = lsPrefix + lsFirst
                    }

                    var lnResult = lsFirst.toDouble() - lsSecnd.toDouble()

                    txtInput?.setText(removeDecimal(lnResult.toString()))
                } else if(lsInput.contains("+")) {

                    val laSplitVal = lsInput.split("+")
                    var lsFirst = laSplitVal[0]
                    var lsSecnd = laSplitVal[1]

                    if(lsPrefix.isNotEmpty()){
                        lsFirst = lsPrefix + lsFirst
                    }

                    var lnResult = lsFirst.toDouble() + lsSecnd.toDouble()

                    txtInput?.setText(removeDecimal(lnResult.toString()))
                } else if(lsInput.contains("*")) {

                    val laSplitVal = lsInput.split("*")
                    var lsFirst = laSplitVal[0]
                    var lsSecnd = laSplitVal[1]

                    if(lsPrefix.isNotEmpty()){
                        lsFirst = lsPrefix + lsFirst
                    }

                    var lnResult = lsFirst.toDouble() * lsSecnd.toDouble()

                    txtInput?.setText(removeDecimal(lnResult.toString()))
                } else if(lsInput.contains("/")) {

                    val laSplitVal = lsInput.split("/")
                    var lsFirst = laSplitVal[0]
                    var lsSecnd = laSplitVal[1]

                    if(lsPrefix.isNotEmpty()){
                        lsFirst = lsPrefix + lsFirst
                    }

                    var lnResult = lsFirst.toDouble() / lsSecnd.toDouble()

                    txtInput?.setText(removeDecimal(lnResult.toString()))
                }

            } catch (e: ArithmeticException){
                e.printStackTrace()
            }
        }
    }

    private fun removeDecimal(fnResult: String) : String{
        var lsResult = fnResult;
        if(lsResult.contains(".0")){
            lsResult = lsResult.substring(0, lsResult.length -2)
        }

        return lsResult
    }
}