package honey.calculatormvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.TextView
import android.widget.Toast
import honey.calculatormvp.R
import honey.calculatormvp.presentor.CalculatorImpl
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ViewInterface {
    override fun updateUI(mCalculation: String, mAnswer: String) {
        textCalculation.text = mCalculation
        textTotal.text = mAnswer
    }

    lateinit var calculatorImpl: CalculatorImpl
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculatorImpl = CalculatorImpl()
        calculatorImpl.setView(this)
        textCalculation.movementMethod = ScrollingMovementMethod()
        textCalculation.text = "0 \n 2 \n 4 \n 5 \n 6 \n 7"
        textDel.setOnClickListener(View.OnClickListener {
            calculatorImpl.clearAll() // after clearnig vars, we have to
        })
    }

    fun onClickedNumber(view: View) {

        when (view.id) {
            R.id.text0,
            R.id.text1,
            R.id.text2,
            R.id.text3,
            R.id.text4,
            R.id.text5,
            R.id.text6,
            R.id.text7,
            R.id.text8,
            R.id.text9 -> {
                val bn = view as TextView
                calculatorImpl.calculating(bn.text as String)
                Toast.makeText(this, "It is clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun onClickedOperator(view: View) {
        when (view.id) {
            R.id.textDivide,
            R.id.textMultiply,
            R.id.textPlus -> {
                val txt = view as TextView
                calculatorImpl.operatorClicked(txt.text as String)
            }
        }
    }
}