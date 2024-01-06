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


open class Bits08 {
    constructor()

    lateinit var high: Bits04
    lateinit var low: Bits04

    private var byte: UByte = 0u


    constructor(byte: UByte) : this() {
        this.byte = byte
        setDecimal(byte)
    }
    constructor(high: Bits04, low: Bits04) : this() {
        this.high = high
        this.low  = low
        this.byte = toDecimal().toUByte()
    }

    fun getByte() : UByte {
        return byte
    }
    fun setDecimal(value:UByte) : Bits08 {
        this.byte = value
        val highNibble: UByte = ((byte.toInt() shr 4) and 0x0F).toUByte()
        val lowNibble: UByte = (byte and 15u).toUByte()
        high = Bits04(highNibble)
        low = Bits04(lowNibble)
        return this
    }
    fun size() : Int {
        return 1
    }
    fun toDecimal() : Int {
        val upper: Int = high.toDecimal() * 16
        val lower: Int = low.toDecimal()
        return upper+lower;
    }
    override fun toString() : String {
        return "$high $low"
    }
}