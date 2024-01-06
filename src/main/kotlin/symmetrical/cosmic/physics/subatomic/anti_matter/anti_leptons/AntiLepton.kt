package symmetrical.cosmic.physics.subatomic.anti_matter.anti_leptons
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
import symmetrical.cosmic.physics.subatomic.luminescent.IAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.AntiMatter
import symmetrical.cosmic.physics.subatomic.matter.leptons.Lepton

/*
https://en.wikipedia.org/wiki/Lepton
 */
open class AntiLepton(
    private val antiMatter: IAntiMatter = AntiMatter(AntiLepton::class, Lepton::class),
) : symmetrical.cosmic.physics.subatomic.balanced.Particle(),
    IAntiMatter by antiMatter,
    IEmitter
{
    constructor() : this(
        AntiMatter(AntiLepton::class, Lepton::class),
    )

    open fun i() : AntiLepton {
        return this
    }
    override fun absorb(photon: Photon) : Photon {
        antiMatter.check(photon);
        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    private fun radiate() : String {
        return antiMatter.getClassId()+
                super.emit().radiate()
    }

}