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

import symmetrical.cosmic.transpectors.transpectors.Ints

open class Bits32 {
    constructor()

    private var high   : Bits16 = Bits16()
    private var low    : Bits16 = Bits16()

    constructor(byte1:UByte, byte2:UByte, byte3:UByte, byte4:UByte) : this() {
        high  = Bits16(byte1, byte2)
        low   = Bits16(byte3, byte4)

    }
    constructor(byteArray:ByteArray) :this(byteArray[0].toUByte(), byteArray[1].toUByte(),byteArray[2].toUByte(), byteArray[3].toUByte()) {
    }
    constructor(value:Int=0) : this() {
        val byteArray = Ints.toByteArray(value)
        high = Bits16(byteArray[0].toUByte(), byteArray[1].toUByte())
        low  = Bits16(byteArray[2].toUByte(), byteArray[3].toUByte())
    }


    fun getByteArray() : ByteArray {
        var result = ByteArray(4)
        val highArray:ByteArray  = high.getByteArray()
        val lowArray :ByteArray  = low.getByteArray()
        result[0] = highArray[0]
        result[1] = highArray[1]
        result[2] = lowArray[0]
        result[3] = lowArray[1]
        return result
    }
    fun size() : Int {
        return 4
    }
    fun toDecimal() : Int {
        val high:Int = high.toDecimal() * 65536
        val low :Int = low.toDecimal()
        return high + low
    }
    override fun toString() : String {
        return "$high :: $low"
    }
}