package symmetrical.physics.subatomic.balanced.color
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

import symmetrical.physics.subatomic.balanced.Particle
import symmetrical.physics.subatomic.matter.hadrons.baryons.Baryon


// For more information visit:   https://en.wikipedia.org/wiki/Color_charge

open class ChromoCharge  {


    public var _value: Any? = null

    public var color :Short = COLORLESS

    companion object {
        const val COLORLESS :Short   = 0
        const val RED       :Short   = 1
        const val BLUE      :Short   = 2
        const val GREEN     :Short   = 3
        const val ANTI_RED  :Short   = -1
        const val ANTI_BLUE :Short   = -2
        const val ANTI_GREEN:Short   = -3
    }
    open fun clone() : ChromoCharge {
        return ChromoCharge()
    }
    open fun getString() : String {
        return _value.toString()
    }
    fun isAntiBlue() : Boolean {
        return color == ANTI_BLUE
    }
    fun isAntiGreen() : Boolean {
        return color == ANTI_GREEN
    }
    fun isAntiRed() : Boolean {
        return color == ANTI_RED
    }
    fun isBlue() : Boolean {
        return color == BLUE
    }

    fun isGreen() : Boolean {
        return color == GREEN
    }
    fun isRed() : Boolean {
        return color == RED
    }
    fun reinitialize() : ChromoCharge {
        return this
    }
    fun setBaryon(baryon: Baryon) : ChromoCharge {
        // setQuark(baryon.quarks[0].value)
        return this
    }
//    fun setQuark(quark:Quark) : ChromoCharge {
//
//        quark.gluon.color = this as Color
//        return this
//    }

    public fun setValue(value:Any?) : ChromoCharge {
        this._value = value
        return this
    }
}