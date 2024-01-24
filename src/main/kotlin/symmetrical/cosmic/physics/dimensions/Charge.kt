package symmetrical.cosmic.physics.dimensions
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

import symmetrical.cosmic.absorber.Absorber
import symmetrical.cosmic.physics.subatomic.balanced.values.Field
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.luminescent.IQuasiParticle
import symmetrical.cosmic.physics.subatomic.luminescent.QuasiParticle
/*
https://en.wikipedia.org/wiki/Charge_(physics)
 */
class Charge (
    private val field: QuasiParticle = QuasiParticle()
) :
    IQuasiParticle by field {

    object Static {
        const val PLUS:Byte  = +1
        const val ZERO:Byte  = 0
        const val MINUS:Byte = -1
    }
    init {
        setCharge(Static.ZERO)
    }

    override fun absorb(photon: Photon) : Photon {
        var remainder : Photon = photon.propagate()
        remainder = field.absorb(remainder)
        return remainder
    }
    fun charge() : Any? {
        return field.getContent()
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    public fun getClassId() : String {
        return getLocalClassId()
    }
    fun getField() : Field {
        return field.getField()
    }
    fun setCharge(content:Any?) : Any? {
        return setContent(content)
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Charge::class)
    }
    private fun radiate() : String {
        return getLocalClassId()+
                field.emit().radiate()
    }
}