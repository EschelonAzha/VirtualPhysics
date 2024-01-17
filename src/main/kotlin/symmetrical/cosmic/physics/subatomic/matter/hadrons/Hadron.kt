package symmetrical.cosmic.physics.subatomic.matter.hadrons
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

import symmetrical.cosmic.physics.subatomic.bosons.IEmitter
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.spacial.ParticleBeam
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_hadrons.AntiHadron
import symmetrical.cosmic.physics.subatomic.balanced.Particle
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter

/*
https://en.wikipedia.org/wiki/Hadron
 */
open class Hadron(
    private val matterAntiMatter: IMatter = Matter(Hadron::class),
) : ParticleBeam(),
    IMatter by matterAntiMatter,
    IEmitter
{
    constructor() : this(
        Matter(Hadron::class),
    )


    object Static {
        const val LAST : Int = ParticleBeam.Static.LAST

    }
    fun i(size:Int) : Hadron {
        return this
    }

    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)

        return remainder
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }

    private fun radiate() : String {
        if (Particle.Static.debuggingOn) {
            println("Hadron")
        }
        val classId      : String = matterAntiMatter.getClassId()
        val particleBeam : String = super.emit().radiate()
        return classId+particleBeam
    }
}