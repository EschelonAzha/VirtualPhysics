package symmetrical.physics.atomic.atoms.elements
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

import symmetrical.physics.atomic.atoms.Atom
import symmetrical.physics.atomic.atoms.Element
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter


// For more information visit:  https://en.wikipedia.org/wiki/Hydrogen

open class Hydrogen(
    private val matterAntiMatter: IMatter = Matter().with(Hydrogen::class),
) : Atom(),
    IMatter by matterAntiMatter
{
    // Hydrogen is automatically constructed with one Proton (ValueProton).
    // An Atom always has at least one proton.  All other atoms add more protons as
    // they go up the Periodic Table

    override fun with(value:Any?) : Hydrogen {
        super.with(value)
        return this
    }





    // ########################### EMISSIONS ###########################
    override fun absorb(photon: Photon) : Photon {
        return super.absorb(matterAntiMatter.check(photon).propagate())
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }
    private fun radiate() : String {
        return matterAntiMatter.getClassId()+super.emit().radiate()
    }
    // ########################### EMISSIONS ###########################
}