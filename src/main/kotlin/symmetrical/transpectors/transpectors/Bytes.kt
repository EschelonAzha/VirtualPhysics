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

import asymmetrical.physics.machine.transpectors.ABytes

object Bytes {
    fun appendByteArrays(first:ByteArray, second:ByteArray) : ByteArray {
        val result = ByteArray(first.size + second.size)
        for (i in first.indices) {
            result[i] = first[i]
        }
        var next = result.size
        for (i in second.indices) {
            result[next++] = second[i]
        }
        return result
    }
    fun combineNibbles(byte1:Byte, byte2:Byte) : Byte {
        val highNibble = (byte1.toInt() and 0xF0) // Extract the high-order nibble from byte1
        val lowNibble = (byte2.toInt() and 0x0F) // Extract the low-order nibble from byte2

        return ((highNibble or lowNibble).toByte())
    }

    fun mangleBytes53(byte1: Byte, byte2: Byte): Pair<Byte, Byte> {
        val byte1Top = zeroBottom3Nibble(byte1)
        val byte2Top = zeroBottom3Nibble(byte2)

        val byte1Bot = zeroTop5Nibble(byte1)
        val byte2Bot = zeroTop5Nibble(byte2)

        val new1 = (byte1Top+byte2Bot).toByte()
        val new2 = (byte2Top+byte1Bot).toByte()
        return Pair(new1, new2)
    }
    fun mangleBytes44(byte1: Byte, byte2: Byte): Pair<Byte, Byte> {
        val byte1Top = zeroBottom4Nibble(byte1)
        val byte2Top = zeroBottom4Nibble(byte2)

        val byte1Bot = zeroTop4Nibble(byte1)
        val byte2Bot = zeroTop4Nibble(byte2)

        val new1 = (byte1Top+byte2Bot).toByte()
        val new2 = (byte2Top+byte1Bot).toByte()
        return Pair(new1, new2)
    }
    fun selectBytes(from:Int, length:Int, bytes:ByteArray) : ByteArray {
        var result = ByteArray(length)
        var pos = 0
        for (i in from until length+from) {
            result[pos++] = bytes[i]
        }
        return result
    }
    fun toByte(character:String?) : Byte? {
        if (character == null)
            return null
        if (character == "")
            return null

        val character = character.single() // Extract the single character from the string
        return character.code.toByte()
    }
    fun toByteArray(byte1:Byte, byte2:Byte) : ByteArray {
        val result = ByteArray(2)
        result[0] = byte1;
        result[1] = byte2;
        return result
    }
    fun toNibbleArray(byteValue: Byte): ByteArray {
        val highNibble = ((byteValue.toInt() and 0xF0) ushr 4).toByte() // High order nibble
        val lowNibble = (byteValue.toInt() and 0x0F).toByte() // Low order nibble
        return byteArrayOf(highNibble, lowNibble)
    }
    fun toString(byteArray:ByteArray) : String {
        return ABytes.toString(byteArray)
    }
    private fun zeroBottom3Nibble(byte:Byte) : Byte {
        val topNibbleMask: Byte = (0xF8).toByte()
        return (byte.toInt() and topNibbleMask.toInt()).toByte()
    }
    private fun zeroBottom4Nibble(byte:Byte) : Byte {
        val topNibbleMask: Byte = (0xF0).toByte()
        return (byte.toInt() and topNibbleMask.toInt()).toByte()
    }
    private fun zeroTop4Nibble(byte:Byte) : Byte {
        val topNibbleMask: Byte = (0x0F).toByte()
        return (byte.toInt() and topNibbleMask.toInt()).toByte()
    }
    private fun zeroTop5Nibble(byte:Byte) : Byte {
        val topNibbleMask: Byte = (0x07).toByte()
        return (byte.toInt() and topNibbleMask.toInt()).toByte()
    }

}