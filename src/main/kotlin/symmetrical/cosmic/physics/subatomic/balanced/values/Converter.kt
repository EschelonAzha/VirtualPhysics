package symmetrical.cosmic.physics.subatomic.balanced.values
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


import symmetrical.cosmic.physics.subatomic.balanced.values.booleans.*
import symmetrical.cosmic.physics.subatomic.balanced.values.bytes.*
import symmetrical.cosmic.physics.subatomic.balanced.values.doubles.*
import symmetrical.cosmic.physics.subatomic.balanced.values.ints.*
import symmetrical.cosmic.physics.subatomic.balanced.values.nil.*
import symmetrical.cosmic.physics.subatomic.balanced.values.strings.*
import symmetrical.cosmic.physics.subatomic.balanced.values.vector.*

/*
        const val NULL      = "0"
        const val BOOLEAN   = "B"
        const val BYTE      = "1"
        const val INT       = "I"
        const val DOUBLE    = "D"
        const val STRING1   = "s"
        const val STRING2   = "S"
        const val STRING3   = "!"
        const val VECTOR    = "V"
 */
class Converter {
    val field : Field
    constructor(field:Field) {
        this.field = field
    }

    fun asArray() : Array<Any> {
        if (field.getType() == Field.Static.NULL)
            return NilVector(field.getContent()).asArray()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanVector().with(field.getContent() as Boolean).asArray() as Array<Any>
        if (field.getType() == Field.Static.BYTE)
            return ByteVector(field.getContent() as Byte).asArray() as Array<Any>
        if (field.getType() == Field.Static.INT)
            return IntVector(field.getContent() as Int).asArray() as Array<Any>
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleVector(field.getContent() as Double).asArray() as Array<Any>
        if (field.getType() == Field.Static.STRING1)
            return StringVector(field.getContent() as String).asArray() as Array<Any>
        if (field.getType() == Field.Static.STRING2)
            return StringVector(field.getContent() as String).asArray() as Array<Any>
        if (field.getType() == Field.Static.STRING3)
            return StringVector(field.getContent() as String).asArray() as Array<Any>
        if (field.getType() == Field.Static.VECTOR)
            return VectorVector(field.getContent() as Array<Any>).asArray() as Array<Any>

        println("Converter::asArray:  UnknownType")
        return Array<Any>(0){false}
    }

    fun toArray() : Array<Any> {
        if (field.getType() == Field.Static.NULL)
            return NilVector(field.getContent()).toArray()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanVector().with(field.getContent() as Boolean).toArray() as Array<Any>
        if (field.getType() == Field.Static.BYTE)
            return ByteVector(field.getContent() as Byte).toArray() as Array<Any>
        if (field.getType() == Field.Static.INT)
            return IntVector(field.getContent() as Int).toArray() as Array<Any>
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleVector(field.getContent() as Double).toArray() as Array<Any>
        if (field.getType() == Field.Static.STRING1)
            return StringVector(field.getContent() as String).toArray() as Array<Any>
        if (field.getType() == Field.Static.STRING2)
            return StringVector(field.getContent() as String).toArray() as Array<Any>
        if (field.getType() == Field.Static.STRING3)
            return StringVector(field.getContent() as String).toArray() as Array<Any>
        if (field.getType() == Field.Static.VECTOR)
            return VectorVector(field.getContent() as Array<Any>).toArray() as Array<Any>
        println("Converter::toArray:  UnknownType")
        return Array<Any>(0){false}
    }

    fun asBoolean() : Boolean? {
        if (field.getType() == Field.Static.NULL)
            return NilBoolean(field.getContent()).asBoolean()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanBoolean().with(field.getContent() as Boolean).asBoolean()
        if (field.getType() == Field.Static.BYTE)
            return ByteBoolean(field.getContent() as Byte).asBoolean()
        if (field.getType() == Field.Static.INT)
            return IntBoolean(field.getContent() as Int).asBoolean()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleBoolean(field.getContent() as Double).asBoolean()
        if (field.getType() == Field.Static.STRING1)
            return StringBoolean(field.getContent() as String).asBoolean()
        if (field.getType() == Field.Static.STRING2)
            return StringBoolean(field.getContent() as String).asBoolean()
        if (field.getType() == Field.Static.STRING3)
            return StringBoolean(field.getContent() as String).asBoolean()
        if (field.getType() == Field.Static.VECTOR)
            return VectorBoolean(field.getContent() as Array<Any>).asBoolean()
        println("Converter::asBoolean:  UnknownType")
        return null
    }

    fun toBoolean() : Boolean {
        if (field.getType() == Field.Static.NULL)
            return NilBoolean(field.getContent()).toBoolean()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanBoolean().with(field.getContent() as Boolean).toBoolean()
        if (field.getType() == Field.Static.BYTE)
            return ByteBoolean(field.getContent() as Byte).toBoolean()
        if (field.getType() == Field.Static.INT)
            return IntBoolean(field.getContent() as Int).toBoolean()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleBoolean(field.getContent() as Double).toBoolean()
        if (field.getType() == Field.Static.STRING1)
            return StringBoolean(field.getContent() as String).toBoolean()
        if (field.getType() == Field.Static.STRING2)
            return StringBoolean(field.getContent()as String).toBoolean()
        if (field.getType() == Field.Static.STRING3)
            return StringBoolean(field.getContent() as String).toBoolean()
        if (field.getType() == Field.Static.VECTOR)
            return VectorBoolean(field.getContent() as Array<Any>).toBoolean()
        println("Converter::toBoolean:  UnknownType")
        return false
    }
    fun asByte() : Byte? {
        if (field.getType() == Field.Static.NULL)
            return NilByte(field.getContent()).asByte()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanByte().with(field.getContent() as Boolean).asByte()
        if (field.getType() == Field.Static.BYTE)
            return ByteByte(field.getContent() as Byte).asByte()
        if (field.getType() == Field.Static.INT)
            return IntByte(field.getContent() as Int).asByte()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleByte(field.getContent() as Double).asByte()
        if (field.getType() == Field.Static.STRING1)
            return StringByte(field.getContent() as String).asByte()
        if (field.getType() == Field.Static.STRING2)
            return StringByte(field.getContent() as String).asByte()
        if (field.getType() == Field.Static.STRING3)
            return StringByte(field.getContent() as String).asByte()
        if (field.getType() == Field.Static.VECTOR)
            return VectorByte(field.getContent() as Array<Any>).asByte()
        println("Converter::asByte:  UnknownType")
        return null
    }

    fun toByte() : Byte {
        if (field.getType() == Field.Static.NULL)
            return NilByte(field.getContent()).toByte()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanByte().with(field.getContent() as Boolean).toByte()
        if (field.getType() == Field.Static.BYTE)
            return ByteByte(field.getContent() as Byte).toByte()
        if (field.getType() == Field.Static.INT)
            return IntByte(field.getContent() as Int).toByte()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleByte(field.getContent() as Double).toByte()
        if (field.getType() == Field.Static.STRING1)
            return StringByte(field.getContent() as String).toByte()
        if (field.getType() == Field.Static.STRING2)
            return StringByte(field.getContent() as String).toByte()
        if (field.getType() == Field.Static.STRING3)
            return StringByte(field.getContent() as String).toByte()
        if (field.getType() == Field.Static.VECTOR)
            return VectorByte(field.getContent() as Array<Any>).toByte()
        println("Converter::toByte:  UnknownType")
        return 0
    }
    fun asInt() : Int? {
        if (field.getType() == Field.Static.NULL)
            return NilInt(field.getContent()).asInt()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanInt().with(field.getContent() as Boolean).asInt()
        if (field.getType() == Field.Static.BYTE)
            return ByteInt(field.getContent() as Byte).asInt()
        if (field.getType() == Field.Static.INT)
            return IntInt(field.getContent() as Int).asInt()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleInt(field.getContent() as Double).asInt()
        if (field.getType() == Field.Static.STRING1)
            return StringInt(field.getContent() as String).asInt()
        if (field.getType() == Field.Static.STRING2)
            return StringInt(field.getContent() as String).asInt()
        if (field.getType() == Field.Static.STRING3)
            return StringInt(field.getContent() as String).asInt()
        if (field.getType() == Field.Static.VECTOR)
            return VectorInt(field.getContent() as Array<Any>).asInt()
        println("Converter::asInt:  UnknownType")
        return null
    }

    fun toInt() : Int {
        if (field.getType() == Field.Static.NULL)
            return NilInt(field.getContent()).toInt()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanInt().with(field.getContent() as Boolean).toInt()
        if (field.getType() == Field.Static.BYTE)
            return ByteInt(field.getContent() as Byte).toInt()
        if (field.getType() == Field.Static.INT)
            return IntInt(field.getContent() as Int).toInt()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleInt(field.getContent() as Double).toInt()
        if (field.getType() == Field.Static.STRING1)
            return StringInt(field.getContent() as String).toInt()
        if (field.getType() == Field.Static.STRING2)
            return StringInt(field.getContent() as String).toInt()
        if (field.getType() == Field.Static.STRING3)
            return StringInt(field.getContent() as String).toInt()
        if (field.getType() == Field.Static.VECTOR)
            return VectorInt(field.getContent() as Array<Any>).toInt()
        println("Converter::toInt:  UnknownType")
        return 0
    }
    fun asDouble() : Double? {
        if (field.getType() == Field.Static.NULL)
            return NilDouble(field.getContent()).asDouble()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanDouble().with(field.getContent() as Boolean).asDouble()
        if (field.getType() == Field.Static.BYTE)
            return ByteDouble(field.getContent() as Byte).asDouble()
        if (field.getType() == Field.Static.INT)
            return IntDouble(field.getContent() as Int).asDouble()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleDouble(field.getContent() as Double).asDouble()
        if (field.getType() == Field.Static.STRING1)
            return StringDouble(field.getContent() as String).asDouble()
        if (field.getType() == Field.Static.STRING2)
            return StringDouble(field.getContent() as String).asDouble()
        if (field.getType() == Field.Static.STRING3)
            return StringDouble(field.getContent() as String).asDouble()
        if (field.getType() == Field.Static.VECTOR)
            return VectorDouble(field.getContent() as Array<Any>).asDouble()
        println("Converter::asDouble:  UnknownType")
        return null
    }

    fun toDouble() : Double {
        if (field.getType() == Field.Static.NULL)
            return NilDouble(field.getContent()).toDouble()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanDouble().with(field.getContent() as Boolean).toDouble()
        if (field.getType() == Field.Static.BYTE)
            return ByteDouble(field.getContent() as Byte).toDouble()
        if (field.getType() == Field.Static.INT)
            return IntDouble(field.getContent() as Int).toDouble()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleDouble(field.getContent() as Double).toDouble()
        if (field.getType() == Field.Static.STRING1)
            return StringDouble(field.getContent() as String).toDouble()
        if (field.getType() == Field.Static.STRING2)
            return StringDouble(field.getContent() as String).toDouble()
        if (field.getType() == Field.Static.STRING3)
            return StringDouble(field.getContent() as String).toDouble()
        if (field.getType() == Field.Static.VECTOR)
            return VectorDouble(field.getContent() as Array<Any>).toDouble()
        println("Converter::toDouble:  UnknownType")
        return 0.0
    }

    fun asString() : String? {
        if (field.getType() == Field.Static.NULL)
            return NilString(field.getContent()).asString()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanString().with(field.getContent() as Boolean).asString()
        if (field.getType() == Field.Static.BYTE)
            return ByteString(field.getContent() as Byte).asString()
        if (field.getType() == Field.Static.INT)
            return IntString(field.getContent() as Int).asString()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleString(field.getContent() as Double).asString()
        if (field.getType() == Field.Static.STRING1)
            return StringString(field.getContent() as String).asString()
        if (field.getType() == Field.Static.STRING2)
            return StringString(field.getContent() as String).asString()
        if (field.getType() == Field.Static.STRING3)
            return StringString(field.getContent() as String).asString()
        if (field.getType() == Field.Static.VECTOR)
            return VectorString(field.getContent() as Array<Any>).asString()
        println("Converter::asString:  UnknownType")
        return null
    }

    override fun toString() : String {
        if (field.getType() == Field.Static.NULL)
            return NilString(field.getContent()).toString()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanString().with(field.getContent() as Boolean).toString()
        if (field.getType() == Field.Static.BYTE)
            return ByteString(field.getContent() as Byte).toString()
        if (field.getType() == Field.Static.INT)
            return IntString(field.getContent() as Int).toString()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleString(field.getContent() as Double).toString()
        if (field.getType() == Field.Static.STRING1)
            return StringString(field.getContent() as String).toString()
        if (field.getType() == Field.Static.STRING2)
            return StringString(field.getContent() as String).toString()
        if (field.getType() == Field.Static.STRING3)
            return StringString(field.getContent() as String).toString()
        if (field.getType() == Field.Static.VECTOR)
            return VectorString(field.getContent() as Array<Any>).toString()
        println("Converter::toString:  UnknownType")
        return ""
    }
}