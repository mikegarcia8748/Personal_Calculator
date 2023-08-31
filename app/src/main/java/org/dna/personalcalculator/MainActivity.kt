package org.dna.personalcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {


    private var txtInput: TextInputEditText? = null
    private var btn1: MaterialButton? = null
    private var btn2: MaterialButton? = null
    private var btn3: MaterialButton? = null
    private var btn4: MaterialButton? = null
    private var btn5: MaterialButton? = null
    private var btn6: MaterialButton? = null
    private var btn7: MaterialButton? = null
    private var btn8: MaterialButton? = null
    private var btn9: MaterialButton? = null
    private var btn0: MaterialButton? = null

    private var btnAddition: MaterialButton? = null
    private var btnSubtract: MaterialButton? = null
    private var btnDivide: MaterialButton? = null
    private var btnMultiply: MaterialButton? = null

    private var btnEquals: MaterialButton? = null
    private var btnPoint: MaterialButton? = null
    private var btnClear: MaterialButton? = null
    private var btnPercent: MaterialButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initWidgets()
        initButtonActions()
    }

    private fun initWidgets(){
        txtInput = findViewById(R.id.txt_CalculatorInput)
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        btn0 = findViewById(R.id.btn_0);
        btnAddition = findViewById(R.id.btn_addition);
        btnSubtract = findViewById(R.id.btn_subtract);
        btnDivide = findViewById(R.id.btn_divide);
        btnMultiply = findViewById(R.id.btn_multiply);
        btnEquals = findViewById(R.id.btn_equals);
        btnPoint = findViewById(R.id.btn_point);
        btnPercent = findViewById(R.id.btn_percent);
        btnClear = findViewById(R.id.btn_clear);
    }

    private fun initButtonActions(){
        btn1?.setOnClickListener {

        }
    }

    private fun appendButtonText(foBtn:MaterialButton){
        txtInput?.append(foBtn.text)
    }
}