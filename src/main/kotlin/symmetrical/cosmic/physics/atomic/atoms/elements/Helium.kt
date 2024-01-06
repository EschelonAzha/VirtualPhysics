package symmetrical.cosmic.physics.atomic.atoms.elements
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

import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter

/*
https://en.wikipedia.org/wiki/Helium
 */

class Helium(
    private val matter: IMatter = Matter(Helium::class, AntiHelium::class),
) :
    IMatter by matter
{
    constructor() : this(
        Matter(Helium::class, AntiHelium::class),
    )


    lateinit var atom : symmetrical.cosmic.physics.atomic.atoms.Atom


    fun i(atom: symmetrical.cosmic.physics.atomic.atoms.Atom) : symmetrical.cosmic.physics.atomic.atoms.elements.Helium {
        this.atom = atom
        atom.setAtomicNumber(2)
        return this
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }
}