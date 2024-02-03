package symmetrical.chemistry.catalysts
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
import symmetrical.chemistry.monomer.IMonomer
import symmetrical.chemistry.polymer.Polymer
import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.atomic.substance.ions.Compound

open class Filter : Catalyst() {
    fun with(polymer: Polymer) : Filter {
        super.with(polymer)
        return this
    }

    fun where(atom: Atom) : Filter {
        add(atom)
        return this
    }

    override fun activate() : Compound {
        val result: Polymer = Polymer()
        for (i in 0 until getPolymer().size()) {
            val monomer: IMonomer = getPolymer().getMonomer(i)
            if (monomer.filter(this))
                result.bind(monomer)
        }
        result.shrink()
        return result
    }


    private fun getPolymer() : Polymer {
        return getCompound() as Polymer
    }
}