package symmetrical.cosmic.chemistry.diatomics
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

import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.atomic.bonds.covalent.Diatomic
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter

open class KeyValue(
    private val matterAntiMatter: IMatter = Matter().with(KeyValue::class),
) : Diatomic(),
    IMatter by matterAntiMatter
{

    override fun with(key: Atom, value: Atom) : KeyValue {
        add(key)
        add(value)
        return this
    }

    object Static {
        const val KEY       : Int = Diatomic.Static.LAST+1
        const val VALUE     : Int = Diatomic.Static.LAST+2

        const val LAST      : Int = VALUE
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

    fun getKey() : Atom? {
        if (size()>0)
            return get(Static.KEY) as Atom
        return null
    }
    fun getValue() : Atom? {
        if (size()>1)
            return get(Static.VALUE) as Atom
        return null
    }
    private fun radiate() : String {
        return matterAntiMatter.getClassId()+
                super.emit().radiate()
    }
}