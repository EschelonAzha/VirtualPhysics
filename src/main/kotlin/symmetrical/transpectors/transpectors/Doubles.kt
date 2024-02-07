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

object Doubles {
    // This fixes a bug where numbers with decimal points are reported as integers
    // and integers are reported as doubles
    fun isDouble(value: Any?): Boolean {
        if (value == null)
            return false
        if (value is Double)
            return value.toString().contains(".")
        if (value is Int) {
            val containsDot = value.toString().contains(".")
            return containsDot
        }
        return false
    }
    fun isInt(value: Any?): Boolean {
        if (value == null)
            return false
        if (value is Double)
            return !value.toString().contains(".")
        if (value is Int) {
            return !value.toString().contains(".")
        }
        return false
    }
}