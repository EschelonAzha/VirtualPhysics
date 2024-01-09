package symmetrical.cosmic.chemistry.polymer
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

import symmetrical.cosmic.chemistry.monomer.IMonomer
import symmetrical.cosmic.chemistry.monomer.Monomer
import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.atomic.substance.ions.Compound
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter

/*
https://en.wikipedia.org/wiki/Diatomic_molecule
 */
open class Polymer(
    private val matter: IMatter = Matter(Polymer::class, Polymer::class),
) : Compound(),
    IMatter by matter
{
    constructor() : this(
        Matter(Polymer::class, Polymer::class),
    )
    object Static {
        const val LAST      : Int = -1
    }

    constructor(atom1: Atom, atom2: Atom) : this() {
        add(atom1)
        add(atom2)
    }


    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }

    fun bind(monomer: IMonomer) : IMonomer {
        this.add(monomer)
        monomer.setPolymer(this)
        return monomer
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }

    fun getMonomer(pos:Int) : IMonomer {
        return get(pos) as IMonomer
    }


    private fun radiate() : String {
        return matter.getClassId()+
                super.emit().radiate()
    }
}