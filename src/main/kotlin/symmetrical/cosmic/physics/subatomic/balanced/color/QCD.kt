package symmetrical.cosmic.physics.subatomic.balanced.color
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

/*
https://en.wikipedia.org/wiki/Quantum_chromodynamics
 */
class QCD() {

    /*
        ARRAY      A-???
        BOOLEAN    T-0/1
        BYTE       B-byte
        DOUBLE     D-nn-Value
        INT        I-nn-Value
        STRING     S-nnnnnnnn-value
     */


    fun blue(value:Any?) : Any {
        if (value == null) {
            return "N"
        }
        if (value is Boolean) {
            var asString    = 0
            if (value)
                asString    = 1
            return "T-$asString"
        }
        if (value is Byte) {
            val asString    = value.toString()
            val count       = asString.length.toString()
            return "B-$asString"
        }
        if (value is Double) {
            val asString    = value.toString()
            val fixedLength = digits(2, asString)
            return "D-$fixedLength-$asString"
        }
        if (value is Int) {
            val asString    = value.toString()
            val fixedLength = digits(2, asString)
            return "I-$fixedLength-$asString"
        }
        if (value is String) {
            val asString    = value
            val fixedLength = digits(8, asString)
            return "S-$fixedLength-$asString"
        }

        println("QCD::blue(value)  Type cannot be translated")
    //    return Exit.exit(-1);
        return ""
    }

    fun green(value:Any?) : Any {
        if (value == null) {
            return "null"
        }
        if (value is Boolean) {
            return value.toString()
        }
        if (value is Byte) {
            return value.toString()
        }
        if (value is Double) {
            return value.toString()
        }
        if (value is Int) {
            return value.toString()
        }
        if (value is String) {
            return value
        }

        println("QCD::green(value)  Type cannot be translated")
    //    return Exit.exit(-1)
        return ""
    }


    private fun digits(digits:Int, value:String) : String {
        var length = value.length.toString().length
        var result = fixedString(digits-length, "0")
        return result+value.length
    }
    private fun fixedString(length:Int, init:String) : String {
        var i       =   0
        var result  =   ""
        while (i<length) {
            result += init
            i++
        }
        return result
    }
}