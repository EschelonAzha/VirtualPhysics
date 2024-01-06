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


class Bits64 {
    constructor()

    private var high   : Bits32 = Bits32()
    private var low    : Bits32 = Bits32()

    init {
        high  = Bits32(0u, 0u, 0u, 0u)
        low   = Bits32(0u, 0u, 0u, 0u)
    }

    constructor(byte1:UByte=0u, byte2:UByte=0u, byte3:UByte=0u, byte4:UByte=0u, byte5:UByte=0u, byte6:UByte=0u, byte7:UByte=0u, byte8:UByte=0u) : this() {
        high  = Bits32(byte1, byte2, byte3, byte4)
        low   = Bits32(byte5, byte6, byte7, byte8)
    }
    constructor(byteArray:ByteArray) :this(byteArray[0].toUByte(), byteArray[1].toUByte(),byteArray[2].toUByte(), byteArray[3].toUByte(),byteArray[4].toUByte(), byteArray[5].toUByte(),byteArray[6].toUByte(), byteArray[7].toUByte()) {
    }
    fun toDecimal() : Long {
        val high:Long = high.toDecimal() * 4294967296
        val low :Long = low.toDecimal().toLong()
        return high + low
    }
    override fun toString() : String {
        return "$high :: $low"
    }
}