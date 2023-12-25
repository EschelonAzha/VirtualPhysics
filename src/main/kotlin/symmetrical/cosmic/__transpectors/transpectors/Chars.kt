package symmetrical.cosmic.__transpectors.transpectors

import symmetrical.cosmic.__transpectors.printable_characters.LowerCase
import symmetrical.cosmic.__transpectors.printable_characters.Numbers
import symmetrical.cosmic.__transpectors.printable_characters.SpecialCharacters
import symmetrical.cosmic.__transpectors.printable_characters.UpperCase


object Chars {
    val lowerCase:String = LowerCase().getCharacters()
    val numeric  :String = Numbers().getCharacters()
    val special  :String = SpecialCharacters().getCharacters()
    val upperCase:String = UpperCase().getCharacters()

    fun isLowerCase(char:String) : Boolean {
        val result = lowerCase.indexOf(char)
        return result != -1
    }
    fun isNumeric(char:String) : Boolean {
        val result = numeric.indexOf(char)
        return result != -1
    }
    fun isSpace(char:String) : Boolean {
        return char == " "
    }
    fun isSpecial(char:String) : Boolean {
        val result = special.indexOf(char)
        return result != -1
    }
    fun isText(char:String) : Boolean {
        if (isLowerCase(char))
            return true
        if (isUpperCase(char))
            return true
        if (isNumeric(char))
            return true
        if (isSpace(char))
            return true
        if (isSpecial(char))
            return true
        return false
    }
    fun isUpperCase(char:String) : Boolean {
        val result = upperCase.indexOf(char)
        return result != -1
    }
}