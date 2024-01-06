package symmetrical.cosmic.transpectors.transpectors
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

object Longs {
    fun toByteArray(long: Long): ByteArray {
        val bytes = ByteArray(8)
        bytes[0] = (long ushr 56).toByte()
        bytes[1] = (long ushr 48).toByte()
        bytes[2] = (long ushr 40).toByte()
        bytes[3] = (long ushr 32).toByte()
        bytes[4] = (long ushr 24).toByte()
        bytes[5] = (long ushr 16).toByte()
        bytes[6] = (long ushr 8).toByte()
        bytes[7] = long.toByte()
        return bytes
    }
}