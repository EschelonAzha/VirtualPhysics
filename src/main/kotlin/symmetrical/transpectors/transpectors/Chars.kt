package symmetrical.transpectors.transpectors
/*
 * This file is part of Virtual Physics.
 *
 * Copyright (C) [2024] Stephen R. DeSofi AKA Eschelon Azha
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import symmetrical.transpectors.printable_characters.LowerCase
import symmetrical.transpectors.printable_characters.Numbers
import symmetrical.transpectors.printable_characters.SpecialCharacters
import symmetrical.transpectors.printable_characters.UpperCase


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