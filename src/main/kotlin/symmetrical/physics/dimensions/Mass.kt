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
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IQuasiParticle
import symmetrical.physics.subatomic.luminescent.QuasiParticle

// For more information visit:   https://en.wikipedia.org/wiki/Mass

class Mass (
    private val field: QuasiParticle = QuasiParticle()
) :
    IQuasiParticle by field
{
    var quantum : IQuantum? = null
    init {
        setMass(Static.PHOTON)
    }
    fun withQuantum(quantum: IQuantum) : Mass {
        this.quantum = quantum
        return this
    }
    object Static {
        const val PHOTON        : Byte = 0
        const val NEUTRINO      : Byte = 1
        const val ELECTRON      : Byte = 2
        const val MUON          : Byte = 3
        const val TAU           : Byte = 4
        const val UP_QUARK      : Byte = 5
        const val DOWN_QUARK    : Byte = 6
        const val STRANGE_QUARK : Byte = 7
        const val CHARM_QUARK   : Byte = 8
        const val BOTTOM_QUARK  : Byte = 9
        const val TOP_QUARK     : Byte = 10
        const val PROTON        : Byte = 11
        const val NEUTRON       : Byte = 12
    }
    override fun absorb(photon: Photon) : Photon {
        var remainder : Photon = photon.propagate()
        remainder = field.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }

    fun getClassId() : String {
        return getLocalClassId()
    }
    fun getField() : Field {
        return field.getField()
    }

    fun mass() : Any? {
        return field.getContent()
    }

    fun setMass(content:Any?) : Any? {
        return setContent(content)
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Mass::class)
    }
    private fun radiate() : String {
        return getLocalClassId()+
                field.emit().radiate()
    }
}