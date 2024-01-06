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

import symmetrical.cosmic.transpectors.transpectors.Shorts

open class Bits16 {
    constructor()

    private var high: Bits08 = Bits08()
    private var low : Bits08 = Bits08()

    constructor(byte1:UByte, byte2:UByte) : this() {
        high = Bits08(byte1)
        low  = Bits08(byte2)
    }
    constructor(byteArray:ByteArray) :this(byteArray[0].toUByte(), byteArray[1].toUByte()) {
    }
    constructor(value:UShort) : this() {
        val byteArray = Shorts.toByteArray(value)
        high = Bits08(byteArray[0].toUByte())
        low  = Bits08(byteArray[1].toUByte())
    }

    fun getByteArray() : ByteArray {
        var result = ByteArray(2)
        result[0] = high.getByte().toByte()
        result[1] = low.getByte().toByte()
        return result
    }
    fun size() : Int {
        return 2
    }
    fun toDecimal(): Int {
        return (high.getByte().toInt() shl 8) or (low.getByte().toInt() and 0xFF)
    }
    override fun toString() : String {
        return "$high : $low"
    }
}