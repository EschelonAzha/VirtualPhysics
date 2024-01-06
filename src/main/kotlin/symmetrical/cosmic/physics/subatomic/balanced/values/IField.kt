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


interface IField {
    fun asArray()               : Array<Any>
    fun asBoolean()             : Boolean?
    fun asByte()                : Byte?
    fun asDouble()              : Double?
    fun asInt()                 : Int?
    fun asString()              : String?
    fun getContent()            : Any?
    fun getType()               : String

    fun isChange(value:Any?)    : Boolean
    fun isNull()                : Boolean
    fun setContent(content:Any?): Any?
    fun setField(field:Field)   : Field

    fun toArray()               : Array<Any>
    fun toBoolean()             : Boolean
    fun toByte()                : Byte
    fun toDouble()              : Double
    fun toInt()                 : Int

    override fun toString()     : String
}