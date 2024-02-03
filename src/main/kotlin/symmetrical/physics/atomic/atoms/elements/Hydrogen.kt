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
    private val matterAntiMatter: IMatter = Matter().with(symmetrical.physics.atomic.atoms.elements.Hydrogen::class),
) : symmetrical.physics.atomic.atoms.Element(),
    IMatter by matterAntiMatter
{
    // Hydrogen is automatically constructed with one Proton (ValueProton) and can have no others
    override fun with(value:Any?) : symmetrical.physics.atomic.atoms.elements.Hydrogen {
        super.with(value)
        return this
    }
    override fun absorb(photon: Photon) : Photon {
        return super.absorb(matterAntiMatter.check(photon).propagate())
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }
    private fun radiate() : String {
        return matterAntiMatter.getClassId()+super.emit().radiate()
    }
}