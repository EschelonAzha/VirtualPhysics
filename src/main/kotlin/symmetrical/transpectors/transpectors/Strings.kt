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

import asymmetrical.physics.machine.transpectors.ABytes
import symmetrical.transpectors.printable_characters.Base52


object Strings {

    fun chop(number:Int, str:String) : String {
        return str.substring(number)
    }
    fun crlfTerminated(value:String) : String {
        return value+CRLF()
    }
    fun doubleQuoted(value:String) : String {
        if (value == null)
            return "\"\""
        return "\""+value+"\""
    }
    fun isAlpha(value:String) : Boolean {
        return value.all(Char::isLetter)
    }
    fun isCrLfTerminated(value:String) : Boolean {
        return value.endsWith(CRLF())
    }
    fun isDoubleCrLfTerminated(value:String) : Boolean {
        return value.endsWith(CRLF()+CRLF())
    }
    fun CRLF() : String {
        return "\r\n"
    }
    fun nullTerminated(value:String) : String {
        return value + '\u0000'
    }
    fun prefixBase52LthToString(lth:Int, value:Any?) : String {
        if (value == null)
            return Base52.toFixedBase52(lth, 0)
        val str = value.toString()
        val lth = Base52.toFixedBase52(lth, str.length)
        return lth+str
    }
    fun remainder(number:Int, str:String) : Pair<String, String> {
        val leading:String = str.substring(0, number)
        val remaining:String = str.substring(number)
        return  Pair<String, String>(leading, remaining)
    }
    fun removeCharacter(characterToRemove: Char, value: String): String {
        var charArray:CharArray = value.toCharArray()
        var result:String = ""
        for (i in charArray.indices) {
            if (charArray[i] != characterToRemove){
                result += charArray[i]
            }
        }
        return result
    }
    fun removeDoubleQuotes(text:String) : String {
        return removeBookends(text);
    }
    fun removeSingleQuotes(text:String) : String {
        return removeBookends(text);
    }

    fun scramble(payload:String, pattern:Int=44) : String {

        val byteArray = toByteArray(payload)

        val mod = byteArray.size % 2
        var size = byteArray.size
        if (mod == 1) {
            size--
        }
        var result = ByteArray(byteArray.size)
        for (i in 0 until size step 2) {
            val first :Byte = byteArray[i]
            val second:Byte = byteArray[i+1]
            var mangled:Pair<Byte, Byte>
            if (pattern == 44)
                mangled = Bytes.mangleBytes44(first, second)
            else mangled = Bytes.mangleBytes53(first, second)
            result[i] = mangled.first
            result[i+1] = mangled.second
        }
        if (mod == 1) {
            result[size] = byteArray[size]
        }

        return Bytes.toString(result)

    }
    fun toByteArray(str: String): ByteArray {
        return ABytes.toByteArray(str.toCharArray())
    }

    fun toDelimitedString(delimiter:String, array: Array<Any?>) : String {
        if (array.isEmpty())
            return ""

        var result = array[0].toString()
        for (i in 1 until array.size) {
            result += delimiter
            result += array[i].toString()
        }

        return result
    }
    fun toFixedLength(lth:Int, padChar:String, value:String) : String {
        var result = value;
        while (result.length < lth) {
            result = padChar+result;
        }
        return result;
    }
    fun trimLeading(character:String, value:String) : String {
        return value.trimStart(character[0])
    }
    private fun removeBookends(text:String) : String {
        return text.substring(1, text.length-1);
    }
}