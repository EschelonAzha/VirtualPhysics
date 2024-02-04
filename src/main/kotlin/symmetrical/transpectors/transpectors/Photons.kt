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

import symmetrical.transpectors.printable_characters.Base52

object Photons {
    fun chopClassId(emission:String) : String {
        return Strings.chop(2, emission)
    }

    fun parse(lthLength:Int, emission:String) : Pair<String, String> {
        val (base52Lth,line) = Strings.remainder(lthLength, emission)
        val lth = Base52.toInt(base52Lth)
        val (value, remainder) = Strings.remainder(lth, line)
        return Pair<String, String>(value, remainder)
    }
}