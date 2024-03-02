package symmetrical.physics.subatomic.balanced.values
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


import symmetrical.physics.subatomic.balanced.values.booleans.*
import symmetrical.physics.subatomic.balanced.values.bytes.*
import symmetrical.physics.subatomic.balanced.values.doubles.*
import symmetrical.physics.subatomic.balanced.values.ints.*
import symmetrical.physics.subatomic.balanced.values.nil.*
import symmetrical.physics.subatomic.balanced.values.strings.*
import symmetrical.physics.subatomic.balanced.values.vector.*

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
class Converter() {
    lateinit var field : Field
    fun with(field:Field) : Converter {
        this.field = field
        return this
    }

    fun asArray() : Array<Any> {
        if (field.getType() == Field.Static.NULL)
            return NilVector().with(field.getContent()).asArray()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanVector().with(field.getContent() as Boolean).asArray() as Array<Any>
        if (field.getType() == Field.Static.BYTE)
            return ByteVector().with(field.getContent() as Byte).asArray() as Array<Any>
        if (field.getType() == Field.Static.INT)
            return IntVector().with(field.getContent() as Int).asArray() as Array<Any>
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleVector().with(field.getContent() as Double).asArray() as Array<Any>
        if (field.getType() == Field.Static.STRING1)
            return StringVector().with(field.getContent() as String).asArray() as Array<Any>
        if (field.getType() == Field.Static.STRING2)
            return StringVector().with(field.getContent() as String).asArray() as Array<Any>
        if (field.getType() == Field.Static.STRING3)
            return StringVector().with(field.getContent() as String).asArray() as Array<Any>
        if (field.getType() == Field.Static.ARRAY)
            return ArrayArray().with(field.getContent() as Array<Any>).asArray() as Array<Any>

        println("Converter::asArray:  UnknownType")
        return Array<Any>(0){false}
    }

    fun toArray() : Array<Any> {
        if (field.getType() == Field.Static.NULL)
            return NilVector().with(field.getContent()).toArray()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanVector().with(field.getContent() as Boolean).toArray() as Array<Any>
        if (field.getType() == Field.Static.BYTE)
            return ByteVector().with(field.getContent() as Byte).toArray() as Array<Any>
        if (field.getType() == Field.Static.INT)
            return IntVector().with(field.getContent() as Int).toArray() as Array<Any>
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleVector().with(field.getContent() as Double).toArray() as Array<Any>
        if (field.getType() == Field.Static.STRING1)
            return StringVector().with(field.getContent() as String).toArray() as Array<Any>
        if (field.getType() == Field.Static.STRING2)
            return StringVector().with(field.getContent() as String).toArray() as Array<Any>
        if (field.getType() == Field.Static.STRING3)
            return StringVector().with(field.getContent() as String).toArray() as Array<Any>
        if (field.getType() == Field.Static.ARRAY)
            return ArrayArray().with(field.getContent() as Array<Any>).toArray() as Array<Any>
        println("Converter::toArray:  UnknownType")
        return Array<Any>(0){false}
    }

    fun asBoolean() : Boolean? {
        if (field.getType() == Field.Static.NULL)
            return NilBoolean().with(field.getContent()).asBoolean()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanBoolean().with(field.getContent() as Boolean).asBoolean()
        if (field.getType() == Field.Static.BYTE)
            return ByteBoolean().with(field.getContent() as Byte).asBoolean()
        if (field.getType() == Field.Static.INT)
            return IntBoolean().with(field.getContent() as Int).asBoolean()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleBoolean().with(field.getContent() as Double).asBoolean()
        if (field.getType() == Field.Static.STRING1)
            return StringBoolean().with(field.getContent() as String).asBoolean()
        if (field.getType() == Field.Static.STRING2)
            return StringBoolean().with(field.getContent() as String).asBoolean()
        if (field.getType() == Field.Static.STRING3)
            return StringBoolean().with(field.getContent() as String).asBoolean()
        if (field.getType() == Field.Static.ARRAY)
            return ArrayBoolean().with(field.getContent() as Array<Any>).asBoolean()
        println("Converter::asBoolean:  UnknownType")
        return null
    }

    fun toBoolean() : Boolean {
        if (field.getType() == Field.Static.NULL)
            return NilBoolean().with(field.getContent()).toBoolean()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanBoolean().with(field.getContent() as Boolean).toBoolean()
        if (field.getType() == Field.Static.BYTE)
            return ByteBoolean().with(field.getContent() as Byte).toBoolean()
        if (field.getType() == Field.Static.INT)
            return IntBoolean().with(field.getContent() as Int).toBoolean()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleBoolean().with(field.getContent() as Double).toBoolean()
        if (field.getType() == Field.Static.STRING1)
            return StringBoolean().with(field.getContent() as String).toBoolean()
        if (field.getType() == Field.Static.STRING2)
            return StringBoolean().with(field.getContent()as String).toBoolean()
        if (field.getType() == Field.Static.STRING3)
            return StringBoolean().with(field.getContent() as String).toBoolean()
        if (field.getType() == Field.Static.ARRAY)
            return ArrayBoolean().with(field.getContent() as Array<Any>).toBoolean()
        println("Converter::toBoolean:  UnknownType")
        return false
    }
    fun asByte() : Byte? {
        if (field.getType() == Field.Static.NULL)
            return NilByte().with(field.getContent()).asByte()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanByte().with(field.getContent() as Boolean).asByte()
        if (field.getType() == Field.Static.BYTE)
            return ByteByte().with(field.getContent() as Byte).asByte()
        if (field.getType() == Field.Static.INT)
            return IntByte().with(field.getContent() as Int).asByte()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleByte().with(field.getContent() as Double).asByte()
        if (field.getType() == Field.Static.STRING1)
            return StringByte().with(field.getContent() as String).asByte()
        if (field.getType() == Field.Static.STRING2)
            return StringByte().with(field.getContent() as String).asByte()
        if (field.getType() == Field.Static.STRING3)
            return StringByte().with(field.getContent() as String).asByte()
        if (field.getType() == Field.Static.ARRAY)
            return ArrayByte().with(field.getContent() as Array<Any>).asByte()
        println("Converter::asByte:  UnknownType")
        return null
    }

    fun toByte() : Byte {
        if (field.getType() == Field.Static.NULL)
            return NilByte().with(field.getContent()).toByte()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanByte().with(field.getContent() as Boolean).toByte()
        if (field.getType() == Field.Static.BYTE)
            return ByteByte().with(field.getContent() as Byte).toByte()
        if (field.getType() == Field.Static.INT)
            return IntByte().with(field.getContent() as Int).toByte()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleByte().with(field.getContent() as Double).toByte()
        if (field.getType() == Field.Static.STRING1)
            return StringByte().with(field.getContent() as String).toByte()
        if (field.getType() == Field.Static.STRING2)
            return StringByte().with(field.getContent() as String).toByte()
        if (field.getType() == Field.Static.STRING3)
            return StringByte().with(field.getContent() as String).toByte()
        if (field.getType() == Field.Static.ARRAY)
            return ArrayByte().with(field.getContent() as Array<Any>).toByte()
        println("Converter::toByte:  UnknownType")
        return 0
    }
    fun asInt() : Int? {
        if (field.getType() == Field.Static.NULL)
            return NilInt().with(field.getContent()).asInt()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanInt().with(field.getContent() as Boolean).asInt()
        if (field.getType() == Field.Static.BYTE)
            return ByteInt().with(field.getContent() as Byte).asInt()
        if (field.getType() == Field.Static.INT)
            return IntInt().with(field.getContent() as Int).asInt()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleInt().with(field.getContent() as Double).asInt()
        if (field.getType() == Field.Static.STRING1)
            return StringInt().with(field.getContent() as String).asInt()
        if (field.getType() == Field.Static.STRING2)
            return StringInt().with(field.getContent() as String).asInt()
        if (field.getType() == Field.Static.STRING3)
            return StringInt().with(field.getContent() as String).asInt()
        if (field.getType() == Field.Static.ARRAY)
            return ArrayInt().with(field.getContent() as Array<Any>).asInt()
        println("Converter::asInt:  UnknownType")
        return null
    }

    fun toInt() : Int {
        if (field.getType() == Field.Static.NULL)
            return NilInt().with(field.getContent()).toInt()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanInt().with(field.getContent() as Boolean).toInt()
        if (field.getType() == Field.Static.BYTE)
            return ByteInt().with(field.getContent() as Byte).toInt()
        if (field.getType() == Field.Static.INT)
            return IntInt().with(field.getContent() as Int).toInt()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleInt().with(field.getContent() as Double).toInt()
        if (field.getType() == Field.Static.STRING1)
            return StringInt().with(field.getContent() as String).toInt()
        if (field.getType() == Field.Static.STRING2)
            return StringInt().with(field.getContent() as String).toInt()
        if (field.getType() == Field.Static.STRING3)
            return StringInt().with(field.getContent() as String).toInt()
        if (field.getType() == Field.Static.ARRAY)
            return ArrayInt().with(field.getContent() as Array<Any>).toInt()
        println("Converter::toInt:  UnknownType")
        return 0
    }
    fun asDouble() : Double? {
        if (field.getType() == Field.Static.NULL)
            return NilDouble().with(field.getContent()).asDouble()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanDouble().with(field.getContent() as Boolean).asDouble()
        if (field.getType() == Field.Static.BYTE)
            return ByteDouble().with(field.getContent() as Byte).asDouble()
        if (field.getType() == Field.Static.INT)
            return IntDouble().with(field.getContent() as Int).asDouble()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleDouble().with(field.getContent() as Double).asDouble()
        if (field.getType() == Field.Static.STRING1)
            return StringDouble().with(field.getContent() as String).asDouble()
        if (field.getType() == Field.Static.STRING2)
            return StringDouble().with(field.getContent() as String).asDouble()
        if (field.getType() == Field.Static.STRING3)
            return StringDouble().with(field.getContent() as String).asDouble()
        if (field.getType() == Field.Static.ARRAY)
            return ArrayDouble().with(field.getContent() as Array<Any>).asDouble()
        println("Converter::asDouble:  UnknownType")
        return null
    }

    fun toDouble() : Double {
        if (field.getType() == Field.Static.NULL)
            return NilDouble().with(field.getContent()).toDouble()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanDouble().with(field.getContent() as Boolean).toDouble()
        if (field.getType() == Field.Static.BYTE)
            return ByteDouble().with(field.getContent() as Byte).toDouble()
        if (field.getType() == Field.Static.INT)
            return IntDouble().with(field.getContent() as Int).toDouble()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleDouble().with(field.getContent() as Double).toDouble()
        if (field.getType() == Field.Static.STRING1)
            return StringDouble().with(field.getContent() as String).toDouble()
        if (field.getType() == Field.Static.STRING2)
            return StringDouble().with(field.getContent() as String).toDouble()
        if (field.getType() == Field.Static.STRING3)
            return StringDouble().with(field.getContent() as String).toDouble()
        if (field.getType() == Field.Static.ARRAY)
            return ArrayDouble().with(field.getContent() as Array<Any>).toDouble()
        println("Converter::toDouble:  UnknownType")
        return 0.0
    }

    fun asString() : String? {
        if (field.getType() == Field.Static.NULL)
            return NilString().with(field.getContent()).asString()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanString().with(field.getContent() as Boolean).asString()
        if (field.getType() == Field.Static.BYTE)
            return ByteString().with(field.getContent() as Byte).asString()
        if (field.getType() == Field.Static.INT)
            return IntString().with(field.getContent() as Int).asString()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleString().with(field.getContent() as Double).asString()
        if (field.getType() == Field.Static.STRING1)
            return StringString().with(field.getContent() as String).asString()
        if (field.getType() == Field.Static.STRING2)
            return StringString().with(field.getContent() as String).asString()
        if (field.getType() == Field.Static.STRING3)
            return StringString().with(field.getContent() as String).asString()
        if (field.getType() == Field.Static.ARRAY)
            return ArrayString().with(field.getContent() as Array<Any>).asString()
        println("Converter::asString:  UnknownType")
        return null
    }

    override fun toString() : String {
        if (field.getType() == Field.Static.NULL)
            return NilString().with(field.getContent()).toString()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanString().with(field.getContent() as Boolean).toString()
        if (field.getType() == Field.Static.BYTE)
            return ByteString().with(field.getContent() as Byte).toString()
        if (field.getType() == Field.Static.INT)
            return IntString().with(field.getContent() as Int).toString()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleString().with(field.getContent() as Double).toString()
        if (field.getType() == Field.Static.STRING1)
            return StringString().with(field.getContent() as String).toString()
        if (field.getType() == Field.Static.STRING2)
            return StringString().with(field.getContent() as String).toString()
        if (field.getType() == Field.Static.STRING3)
            return StringString().with(field.getContent() as String).toString()
        if (field.getType() == Field.Static.ARRAY)
            return ArrayString().with(field.getContent() as Array<Any>).toString()
        println("Converter::toString:  UnknownType")
        return ""
    }
}