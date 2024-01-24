package symmetrical.cosmic.physics.subatomic.balanced.values.booleans
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

class BooleanVector {
    var value : Boolean? = null
    fun with(value:Boolean?) : BooleanVector {
        this.value = value
        return this
    }
    fun asArray() : Array<out Boolean?> {
        if (value == null)
            return Array<Boolean>(0){false}

        return arrayOf(value)
    }
    fun toArray(): Array<Boolean> {
        return asArray() as Array<Boolean>
    }
}