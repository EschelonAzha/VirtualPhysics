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

import symmetrical.cosmic.transpectors.transpectors.Doubles
// For more information visit:   https://en.wikipedia.org/wiki/Scalar_field
class Field() : IField {

    private var type   :String = "0"
    private var content:Any?   = null

    fun with(content:Any?) : Field {
        setContent(content)
        return this
    }
    object Static {
        const val NULL      = "0"
        const val BOOLEAN   = "B"
        const val BYTE      = "1"
        const val INT       = "I"
        const val DOUBLE    = "D"
        const val STRING1   = "s"
        const val STRING2   = "S"
        const val STRING3   = "!"
        const val VECTOR    = "V"

        const val TYPE_LTH    = 1
        const val NUMBERS_LTH = 1
        const val STRING1_LTH = 1
        const val STRING2_LTH = 2
        const val STRING3_LTH = 3
        const val VECTOR_LTH  = 3

    }
    override fun asArray() : Array<Any> {
        return Converter().with(this).asArray()
    }
    override fun asBoolean() : Boolean? {
        return Converter().with(this).asBoolean()
    }
    override fun asByte() : Byte? {
        return Converter().with(this).asByte()
    }
    override fun asDouble() : Double? {
        return Converter().with(this).asDouble()
    }
    override fun asInt() : Int? {
        return Converter().with(this).asInt()
    }
    override fun asString() : String? {
        return Converter().with(this).asString()
    }


    override fun equals(field:Field) : Boolean {
        if (type != field.type)
            return false
        return content == field.getContent()
    }
    override fun getType() : String {
        return type
    }
    override fun getContent() : Any? {
        return content
    }
    override fun isChange(content:Any?)    : Boolean {
        return this.content != content
    }
    override fun isNull() : Boolean {
        return content == null
    }
    override fun setField(field:Field) : Field {
        content = field.getContent()
        type    = field.getType()
        return this
    }
    override fun setContent(content:Any?) : Any? {
        val previous = this.content
        this.content = content

        type = getTypeStr(content)
        return previous
    }
    override fun toArray() : Array<Any> {
        return Converter().with(this).toArray()
    }
    override fun toBoolean() : Boolean {
        return Converter().with(this).toBoolean()
    }

    override fun toByte() : Byte {
        return Converter().with(this).toByte()
    }

    override fun toDouble() : Double {
        return Converter().with(this).toDouble()
    }

    override fun toInt() : Int {
        return Converter().with(this).toInt()
    }

    override fun toString() : String {
        return Converter().with(this).toString()
    }


    private fun getTypeStr(value:Any?) : String {
        if (value == null)
            return Static.NULL

        if (value is String) {
            if (value.length <52)
                return Static.STRING1
            if (value.length < 2704)
                return Static.STRING2
            return Static.STRING3
        }

        if (Doubles.isDouble(value))  // This is needed for JS Bug
            return Static.DOUBLE

        if (value is Int)
            return Static.INT

        if (value is Double)
            return Static.DOUBLE

        if (value is Boolean)
            return Static.BOOLEAN

        if (value is Byte)
            return Static.BYTE

        return Static.VECTOR
    }
}