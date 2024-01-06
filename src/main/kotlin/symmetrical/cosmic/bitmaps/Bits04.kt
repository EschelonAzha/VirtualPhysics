package symmetrical.cosmic.bitmaps
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


open class Bits04 {
    constructor()

    var b00:Short = 0
    var b01:Short = 0
    var b02:Short = 0
    var b03:Short = 0

    constructor(byte:UByte) : this() {

        var opCode = byte and 8u
        if (opCode.toUInt() > 0u)
            b00 = 1
        opCode = byte and 4u
        if (opCode > 0u) {
            b01 = 1
        }
        opCode = byte and 2u
        if (opCode > 0u) {
            b02 = 1
        }
        opCode = byte and 1u
        if (opCode > 0u) {
            b03 = 1
        }

        return
    }
    fun get0() : Int {
        return b00.toInt()
    }
    fun get1() : Int {
        return b01.toInt()
    }
    fun get2() : Int {
        return b02.toInt()
    }
    fun get3() : Int {
        return b03.toInt()
    }
    open fun setO(bit:Short) : Bits04 {
        b00 = bit
        return this
    }
    fun set1(bit:Short) : Bits04 {
        b01 = bit
        return this
    }
    fun set2(bit:Short) : Bits04 {
        b02 = bit
        return this
    }
    fun set3(bit:Short) : Bits04 {
        b03 = bit
        return this
    }
    fun toDecimal() : Int {
        var result = 0
        if (get3()==1)
            result+=1

        if (get2() == 1)
            result+=2

        if (get1() == 1)
            result+=4

        if (get0() == 1)
            result+=8

        return result
    }
    override fun toString() : String {
        return b00.toString()+b01.toString()+b02.toString()+b03.toString()
    }

}