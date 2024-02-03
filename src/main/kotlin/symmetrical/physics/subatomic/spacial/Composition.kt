package symmetrical.physics.subatomic.spacial
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

import symmetrical.physics.subatomic.balanced.IParticle
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter

open class Composition(
    private val matterAntiMatter: IMatter = Matter().with(Composition::class),
) : ParticleBeam(),
    IMatter by matterAntiMatter
{


    open fun with(first: symmetrical.physics.subatomic.balanced.IParticle, last: symmetrical.physics.subatomic.balanced.IParticle) : Composition {
        add(first)
        add(last)
        return this
    }
    object Static {
        const val FIRST  = ParticleBeam.Static.LAST + 1
        const val LAST  = ParticleBeam.Static.LAST + 2
    }

    override fun absorb(photon: Photon) : Photon {
        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    fun getFirst() : symmetrical.physics.subatomic.balanced.IParticle {
        return get(Static.FIRST) as symmetrical.physics.subatomic.balanced.IParticle
    }
    fun getLast() : symmetrical.physics.subatomic.balanced.IParticle {
        return get(Static.LAST) as symmetrical.physics.subatomic.balanced.IParticle
    }

    private fun radiate() : String {
        return matterAntiMatter.getClassId()+super.emit().radiate()
    }
}