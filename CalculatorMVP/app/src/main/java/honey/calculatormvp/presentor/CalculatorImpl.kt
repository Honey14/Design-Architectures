package honey.calculatormvp.presentor

import honey.calculatormvp.view.ViewInterface
import java.text.DecimalFormat
import kotlin.math.pow

class CalculatorImpl : CalculateInterface {


    private lateinit var format: DecimalFormat
    private lateinit var longformat: DecimalFormat
    private lateinit var view: ViewInterface
    var sCalculation = ""
    var mAnswer = ""
    var number = ""
    var currentOperator = ""
    var mResult = 0.0
    var numbers1 = 0.0
    var numbers2 = 0.0
    var temp = 0.0

    override fun operatorClicked(getText: String) {
        if (mAnswer != "") {
            sCalculation += "\n" + getText
            number = ""
            numbers1 = 0.0
            numbers2 = 0.0
            mResult = temp
            temp = 0.0
            mAnswer = format.format(mResult).toString()
            currentOperator = getText
            view.updateUI(sCalculation, mAnswer)
        }
    }

    override fun calculating(getText: String) {
        format = DecimalFormat("#.####")
        longformat = DecimalFormat("0.#E0")
        sCalculation += getText
        number += getText
        numbers1 = java.lang.Double.parseDouble(number)
        when (currentOperator) {
            "" -> temp = mResult + numbers1
            "+" -> temp = mResult + numbers1
            "*" -> temp = mResult * numbers1
            "/" -> try { // divided by 0 cause execption {
                temp = mResult / numbers2.pow(numbers1)
            } catch (e: Exception) {
                mAnswer = e.message.toString()
            }

        }
        mAnswer = format.format(temp).toString()
        view.updateUI(sCalculation, mAnswer)
    }

    override fun setView(view: ViewInterface) {
        this.view = view
    }

    override fun clearAll() {
        sCalculation = ""
        mAnswer = ""
        number = ""
        currentOperator = ""
        mResult = 0.0
        numbers1 = 0.0
        numbers2 = 0.0
        temp = 0.0
        view.updateUI(sCalculation, mAnswer)
    }


}