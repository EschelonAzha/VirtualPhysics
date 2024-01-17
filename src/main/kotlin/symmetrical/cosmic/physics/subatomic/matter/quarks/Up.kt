package symmetrical.cosmic.physics.subatomic.matter.quarks
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

import symmetrical.cosmic.physics.subatomic.anti_matter.anti_quarks.AntiUp
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Baryon

/*
https://en.wikipedia.org/wiki/UpQuark
 */
class Up(
    private val matterAntiMatter: IMatter = Matter(Up::class),
) : Quark(),
    IMatter by matterAntiMatter
{
    constructor() : this(
        Matter(Up::class),
    )
    init {
    }
    constructor(baryon: Baryon) : this() {
        this.p_baryon = baryon
    }
    override fun i() : Up {
        super.i()
        return this
    }
    override fun absorb(photon: Photon) : Photon {
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

    override fun dissipate() : Unit {
      //  Recycler.Up_dissipate(this)
    }
    private fun radiate() : String {
        if (symmetrical.cosmic.physics.subatomic.balanced.Particle.Static.debuggingOn) {
            println("Up")
        }
        val classId:String = matterAntiMatter.getClassId()
        val quark  :String = super.emit().radiate()
        return classId+quark
    }
}