package symmetrical.chemistry.polymer
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
   This is preliminary work.   More sophisticated query capability is coming soon
 */
import symmetrical.chemistry.monomer.IMonomer
import symmetrical.physics.atomic.atoms.Atom
import symmetrical.physics.atomic.substance.ions.Compound
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter

// For more information visit:    https://en.wikipedia.org/wiki/Polymer

open class Polymer(
    private val matterAntiMatter: IMatter = Matter().with(Polymer::class),
) : Compound(),
    IMatter by matterAntiMatter
{
    fun with(atom1: Atom, atom2: Atom) : Polymer {
        add(atom1)
        add(atom2)
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

    fun bind(monomer: IMonomer) : IMonomer {
        this.add(monomer)
        monomer.setPolymer(this)
        return monomer
    }

    override fun emit() : Photon {
        return Photon().with(radiate())
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }

    fun getMonomer(pos:Int) : IMonomer {
        return get(pos) as IMonomer
    }


    private fun radiate() : String {
        return matterAntiMatter.getClassId()+
                super.emit().radiate()
    }
}