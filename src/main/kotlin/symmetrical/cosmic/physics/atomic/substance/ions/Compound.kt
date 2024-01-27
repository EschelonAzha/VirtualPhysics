package symmetrical.cosmic.physics.atomic.substance.ions
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

import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.atomic.bonds.covalent.Molecular
import symmetrical.cosmic.physics.atomic.bonds.ionic.Ionic
import symmetrical.cosmic.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.MatterAntiMatter


// For more information visit:  https://en.wikipedia.org/wiki/Chemical_compound

open class Compound(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter().with(Compound::class),
) : Molecular(),
    IMatterAntiMatter by matterAntiMatter,
    Ionic
{
    override fun with(initialCapacity:Int) : Compound {
        super.with(initialCapacity);
        return this
    }
    object Static {
        const val LAST      : Int = -1
    }

    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

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
    private fun radiate() : String {
        val classId = matterAntiMatter.getClassId()
        val molecular = super.emit().radiate()
        return classId+molecular
    }
}