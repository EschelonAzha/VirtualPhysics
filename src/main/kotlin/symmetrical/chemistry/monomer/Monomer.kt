package symmetrical.chemistry.monomer
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
import symmetrical.chemistry.catalysts.Catalyst
import symmetrical.chemistry.polymer.Polymer
import symmetrical.physics.atomic.atoms.Atom
import symmetrical.physics.atomic.substance.ions.Compound

// For more information visit:   https://en.wikipedia.org/wiki/Monomer
class Monomer() : IMonomer {
    private lateinit var polymer: Polymer
    private lateinit var self: Compound

    override fun filter(catalyst: Catalyst) : Boolean {
        for (i in 0 until catalyst.size()) {
            val criteria: Atom = catalyst.getAtom(i)
            val pos = self.findByType(criteria::class)
            if (pos == -1)
                return false
            val atom = self.getAtom(pos)
            if (!atom.getField().equals(criteria.getField()))
                return false
        }
        return true
    }
    override fun setPolymer(polymer: Polymer) : IMonomer {
        this.polymer = polymer
        return this
    }

    override fun setSelf(compound: Compound) : IMonomer {
        this.self = compound
        return this
    }


}