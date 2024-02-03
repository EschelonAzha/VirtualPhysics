package symmetrical.physics.atomic.atoms

import symmetrical.cosmic.dictionary.protons.AccessLevelProton
import symmetrical.cosmic.dictionary.protons.FieldNameProton
import symmetrical.cosmic.dictionary.protons.ValueProton
import symmetrical.physics.atomic.atoms.elements.Hydrogen
import symmetrical.physics.subatomic.balanced.values.Field
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.matter.hadrons.baryons.Proton
import kotlin.reflect.KClass

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


/*
https://en.wikipedia.org/wiki/Chemical_element
 */

open class Element (
    private val matterAntiMatter: IMatter = Matter().with(symmetrical.physics.atomic.atoms.Element::class),
) : symmetrical.physics.atomic.atoms.Atom(),
    IMatter by matterAntiMatter
{
    override fun absorb(photon: Photon) : Photon {
        return super.absorb(matterAntiMatter.check(photon).propagate())
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }

    fun getAccessLevel() : Field {
        return getProtonField(AccessLevelProton::class)
    }
    fun getFieldName() : Field {
        return getProtonField(FieldNameProton::class)
    }
    fun getValue() : Field {
        return getProtonField(ValueProton::class)
    }

    private fun getProtonField(kClass: KClass<*>) : Field {
        val proton: symmetrical.physics.subatomic.matter.hadrons.baryons.Proton = getProton(kClass)
        return proton.getValueQuark().getWavelength().getField()
    }
    private fun radiate() : String {
        return matterAntiMatter.getClassId()+super.emit().radiate()
    }
}