package symmetrical.cosmic._physics._subatomic.balanced.values

import symmetrical.cosmic._physics._subatomic.balanced.values.booleans.*
import symmetrical.cosmic._physics._subatomic.balanced.values.bytes.*
import symmetrical.cosmic._physics._subatomic.balanced.values.doubles.*
import symmetrical.cosmic._physics._subatomic.balanced.values.ints.*
import symmetrical.cosmic._physics._subatomic.balanced.values.nil.*
import symmetrical.cosmic._physics._subatomic.balanced.values.strings.*
import symmetrical.cosmic._physics._subatomic.balanced.values.vector.*

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
            return NilVector(field.getValue()).asArray()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanVector(field.getValue() as Boolean).asArray() as Array<Any>
        if (field.getType() == Field.Static.BYTE)
            return ByteVector(field.getValue() as Byte).asArray() as Array<Any>
        if (field.getType() == Field.Static.INT)
            return IntVector(field.getValue() as Int).asArray() as Array<Any>
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleVector(field.getValue() as Double).asArray() as Array<Any>
        if (field.getType() == Field.Static.STRING1)
            return StringVector(field.getValue() as String).asArray() as Array<Any>
        if (field.getType() == Field.Static.STRING2)
            return StringVector(field.getValue() as String).asArray() as Array<Any>
        if (field.getType() == Field.Static.STRING3)
            return StringVector(field.getValue() as String).asArray() as Array<Any>
        if (field.getType() == Field.Static.VECTOR)
            return VectorVector(field.getValue() as Array<Any>).asArray() as Array<Any>

        println("Converter::asArray:  UnknownType")
        return Array<Any>(0){false}
    }

    fun toArray() : Array<Any> {
        if (field.getType() == Field.Static.NULL)
            return NilVector(field.getValue()).toArray()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanVector(field.getValue() as Boolean).toArray() as Array<Any>
        if (field.getType() == Field.Static.BYTE)
            return ByteVector(field.getValue() as Byte).toArray() as Array<Any>
        if (field.getType() == Field.Static.INT)
            return IntVector(field.getValue() as Int).toArray() as Array<Any>
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleVector(field.getValue() as Double).toArray() as Array<Any>
        if (field.getType() == Field.Static.STRING1)
            return StringVector(field.getValue() as String).toArray() as Array<Any>
        if (field.getType() == Field.Static.STRING2)
            return StringVector(field.getValue() as String).toArray() as Array<Any>
        if (field.getType() == Field.Static.STRING3)
            return StringVector(field.getValue() as String).toArray() as Array<Any>
        if (field.getType() == Field.Static.VECTOR)
            return VectorVector(field.getValue() as Array<Any>).toArray() as Array<Any>
        println("Converter::toArray:  UnknownType")
        return Array<Any>(0){false}
    }

    fun asBoolean() : Boolean? {
        if (field.getType() == Field.Static.NULL)
            return NilBoolean(field.getValue()).asBoolean()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanBoolean(field.getValue() as Boolean).asBoolean()
        if (field.getType() == Field.Static.BYTE)
            return ByteBoolean(field.getValue() as Byte).asBoolean()
        if (field.getType() == Field.Static.INT)
            return IntBoolean(field.getValue() as Int).asBoolean()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleBoolean(field.getValue() as Double).asBoolean()
        if (field.getType() == Field.Static.STRING1)
            return StringBoolean(field.getValue() as String).asBoolean()
        if (field.getType() == Field.Static.STRING2)
            return StringBoolean(field.getValue() as String).asBoolean()
        if (field.getType() == Field.Static.STRING3)
            return StringBoolean(field.getValue() as String).asBoolean()
        if (field.getType() == Field.Static.VECTOR)
            return VectorBoolean(field.getValue() as Array<Any>).asBoolean()
        println("Converter::asBoolean:  UnknownType")
        return null
    }

    fun toBoolean() : Boolean {
        if (field.getType() == Field.Static.NULL)
            return NilBoolean(field.getValue()).toBoolean()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanBoolean(field.getValue() as Boolean).toBoolean()
        if (field.getType() == Field.Static.BYTE)
            return ByteBoolean(field.getValue() as Byte).toBoolean()
        if (field.getType() == Field.Static.INT)
            return IntBoolean(field.getValue() as Int).toBoolean()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleBoolean(field.getValue() as Double).toBoolean()
        if (field.getType() == Field.Static.STRING1)
            return StringBoolean(field.getValue() as String).toBoolean()
        if (field.getType() == Field.Static.STRING2)
            return StringBoolean(field.getValue()as String).toBoolean()
        if (field.getType() == Field.Static.STRING3)
            return StringBoolean(field.getValue() as String).toBoolean()
        if (field.getType() == Field.Static.VECTOR)
            return VectorBoolean(field.getValue() as Array<Any>).toBoolean()
        println("Converter::toBoolean:  UnknownType")
        return false
    }
    fun asByte() : Byte? {
        if (field.getType() == Field.Static.NULL)
            return NilByte(field.getValue()).asByte()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanByte(field.getValue() as Boolean).asByte()
        if (field.getType() == Field.Static.BYTE)
            return ByteByte(field.getValue() as Byte).asByte()
        if (field.getType() == Field.Static.INT)
            return IntByte(field.getValue() as Int).asByte()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleByte(field.getValue() as Double).asByte()
        if (field.getType() == Field.Static.STRING1)
            return StringByte(field.getValue() as String).asByte()
        if (field.getType() == Field.Static.STRING2)
            return StringByte(field.getValue() as String).asByte()
        if (field.getType() == Field.Static.STRING3)
            return StringByte(field.getValue() as String).asByte()
        if (field.getType() == Field.Static.VECTOR)
            return VectorByte(field.getValue() as Array<Any>).asByte()
        println("Converter::asByte:  UnknownType")
        return null
    }

    fun toByte() : Byte {
        if (field.getType() == Field.Static.NULL)
            return NilByte(field.getValue()).toByte()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanByte(field.getValue() as Boolean).toByte()
        if (field.getType() == Field.Static.BYTE)
            return ByteByte(field.getValue() as Byte).toByte()
        if (field.getType() == Field.Static.INT)
            return IntByte(field.getValue() as Int).toByte()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleByte(field.getValue() as Double).toByte()
        if (field.getType() == Field.Static.STRING1)
            return StringByte(field.getValue() as String).toByte()
        if (field.getType() == Field.Static.STRING2)
            return StringByte(field.getValue() as String).toByte()
        if (field.getType() == Field.Static.STRING3)
            return StringByte(field.getValue() as String).toByte()
        if (field.getType() == Field.Static.VECTOR)
            return VectorByte(field.getValue() as Array<Any>).toByte()
        println("Converter::toByte:  UnknownType")
        return 0
    }
    fun asInt() : Int? {
        if (field.getType() == Field.Static.NULL)
            return NilInt(field.getValue()).asInt()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanInt(field.getValue() as Boolean).asInt()
        if (field.getType() == Field.Static.BYTE)
            return ByteInt(field.getValue() as Byte).asInt()
        if (field.getType() == Field.Static.INT)
            return IntInt(field.getValue() as Int).asInt()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleInt(field.getValue() as Double).asInt()
        if (field.getType() == Field.Static.STRING1)
            return StringInt(field.getValue() as String).asInt()
        if (field.getType() == Field.Static.STRING2)
            return StringInt(field.getValue() as String).asInt()
        if (field.getType() == Field.Static.STRING3)
            return StringInt(field.getValue() as String).asInt()
        if (field.getType() == Field.Static.VECTOR)
            return VectorInt(field.getValue() as Array<Any>).asInt()
        println("Converter::asInt:  UnknownType")
        return null
    }

    fun toInt() : Int {
        if (field.getType() == Field.Static.NULL)
            return NilInt(field.getValue()).toInt()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanInt(field.getValue() as Boolean).toInt()
        if (field.getType() == Field.Static.BYTE)
            return ByteInt(field.getValue() as Byte).toInt()
        if (field.getType() == Field.Static.INT)
            return IntInt(field.getValue() as Int).toInt()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleInt(field.getValue() as Double).toInt()
        if (field.getType() == Field.Static.STRING1)
            return StringInt(field.getValue() as String).toInt()
        if (field.getType() == Field.Static.STRING2)
            return StringInt(field.getValue() as String).toInt()
        if (field.getType() == Field.Static.STRING3)
            return StringInt(field.getValue() as String).toInt()
        if (field.getType() == Field.Static.VECTOR)
            return VectorInt(field.getValue() as Array<Any>).toInt()
        println("Converter::toInt:  UnknownType")
        return 0
    }
    fun asDouble() : Double? {
        if (field.getType() == Field.Static.NULL)
            return NilDouble(field.getValue()).asDouble()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanDouble(field.getValue() as Boolean).asDouble()
        if (field.getType() == Field.Static.BYTE)
            return ByteDouble(field.getValue() as Byte).asDouble()
        if (field.getType() == Field.Static.INT)
            return IntDouble(field.getValue() as Int).asDouble()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleDouble(field.getValue() as Double).asDouble()
        if (field.getType() == Field.Static.STRING1)
            return StringDouble(field.getValue() as String).asDouble()
        if (field.getType() == Field.Static.STRING2)
            return StringDouble(field.getValue() as String).asDouble()
        if (field.getType() == Field.Static.STRING3)
            return StringDouble(field.getValue() as String).asDouble()
        if (field.getType() == Field.Static.VECTOR)
            return VectorDouble(field.getValue() as Array<Any>).asDouble()
        println("Converter::asDouble:  UnknownType")
        return null
    }

    fun toDouble() : Double {
        if (field.getType() == Field.Static.NULL)
            return NilDouble(field.getValue()).toDouble()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanDouble(field.getValue() as Boolean).toDouble()
        if (field.getType() == Field.Static.BYTE)
            return ByteDouble(field.getValue() as Byte).toDouble()
        if (field.getType() == Field.Static.INT)
            return IntDouble(field.getValue() as Int).toDouble()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleDouble(field.getValue() as Double).toDouble()
        if (field.getType() == Field.Static.STRING1)
            return StringDouble(field.getValue() as String).toDouble()
        if (field.getType() == Field.Static.STRING2)
            return StringDouble(field.getValue() as String).toDouble()
        if (field.getType() == Field.Static.STRING3)
            return StringDouble(field.getValue() as String).toDouble()
        if (field.getType() == Field.Static.VECTOR)
            return VectorDouble(field.getValue() as Array<Any>).toDouble()
        println("Converter::toDouble:  UnknownType")
        return 0.0
    }

    fun asString() : String? {
        if (field.getType() == Field.Static.NULL)
            return NilString(field.getValue()).asString()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanString(field.getValue() as Boolean).asString()
        if (field.getType() == Field.Static.BYTE)
            return ByteString(field.getValue() as Byte).asString()
        if (field.getType() == Field.Static.INT)
            return IntString(field.getValue() as Int).asString()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleString(field.getValue() as Double).asString()
        if (field.getType() == Field.Static.STRING1)
            return StringString(field.getValue() as String).asString()
        if (field.getType() == Field.Static.STRING2)
            return StringString(field.getValue() as String).asString()
        if (field.getType() == Field.Static.STRING3)
            return StringString(field.getValue() as String).asString()
        if (field.getType() == Field.Static.VECTOR)
            return VectorString(field.getValue() as Array<Any>).asString()
        println("Converter::asString:  UnknownType")
        return null
    }

    override fun toString() : String {
        if (field.getType() == Field.Static.NULL)
            return NilString(field.getValue()).toString()
        if (field.getType() == Field.Static.BOOLEAN)
            return BooleanString(field.getValue() as Boolean).toString()
        if (field.getType() == Field.Static.BYTE)
            return ByteString(field.getValue() as Byte).toString()
        if (field.getType() == Field.Static.INT)
            return IntString(field.getValue() as Int).toString()
        if (field.getType() == Field.Static.DOUBLE)
            return DoubleString(field.getValue() as Double).toString()
        if (field.getType() == Field.Static.STRING1)
            return StringString(field.getValue() as String).toString()
        if (field.getType() == Field.Static.STRING2)
            return StringString(field.getValue() as String).toString()
        if (field.getType() == Field.Static.STRING3)
            return StringString(field.getValue() as String).toString()
        if (field.getType() == Field.Static.VECTOR)
            return VectorString(field.getValue() as Array<Any>).toString()
        println("Converter::toString:  UnknownType")
        return ""
    }
}