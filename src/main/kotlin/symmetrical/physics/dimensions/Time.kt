package symmetrical.physics.dimensions
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

import symmetrical.dictionary.absorber.Absorber
import symmetrical.physics.subatomic.balanced.IQuantum
import symmetrical.physics.subatomic.balanced.values.Field
import symmetrical.physics.subatomic.balanced.values.IField
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IQuasiParticle
import symmetrical.physics.subatomic.luminescent.QuasiParticle

// For more information visit:   https://en.wikipedia.org/wiki/Time_in_physics

class Time(
    private val field: QuasiParticle = QuasiParticle()
) :
    IQuasiParticle  by field
{
    fun withQuantum(quantum:IQuantum) : Time {
        this.field.setQuantum(quantum)
        return this
    }

    fun getField() : Field {
        return field.getField()
    }
//    fun setTime(content:Any?) : Any? {
//        return setContent(content)
//    }
//    fun time() : Any? {
//        return field.getContent()
//    }







    // ########################### EMISSIONS ###########################
    override fun absorb(photon: Photon) : Photon {
        var remainder : Photon = photon.propagate()
        remainder = field.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }
    public fun getClassId() : String {
        return getLocalClassId()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Time::class)
    }
    private fun radiate() : String {
        return getLocalClassId()+
                field.emit().radiate()
    }
    // ########################### EMISSIONS ###########################
}