package honey.calculatormvp.presentor

import honey.calculatormvp.view.ViewInterface

interface CalculateInterface {
    fun calculating(getText: String)
    fun operatorClicked(getText: String)
    fun clearAll()
    fun setView(view : ViewInterface)
}