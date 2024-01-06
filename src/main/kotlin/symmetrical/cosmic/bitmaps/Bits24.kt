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

class Bits24 {
    constructor()

    var bottom  : Bits08 = Bits08()
    var middle  : Bits08 = Bits08()
    var top     : Bits08 = Bits08()

    constructor(byte1:UByte, byte2:UByte, byte3:UByte) : this() {
        top     = Bits08(byte1)
        middle  = Bits08(byte2)
        bottom  = Bits08(byte3)
    }


    fun size() : Int {
        return 3
    }
    override fun toString() : String {
        return "$top : $middle : $bottom"
    }
}