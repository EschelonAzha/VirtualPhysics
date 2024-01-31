package symmetrical.electronics.components
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
import symmetrical.electronics.interfaces.IConductor

// for more information see:   https://en.wikipedia.org/wiki/Mixed_conductor
class Conductor : IConductor {

    private lateinit var atom:Atom

    override fun conductor_(atom: Atom, autoFlow:Boolean) : Atom {
        conductor(atom, autoFlow);
        return atom
    }
    override fun _conductor(atom: Atom, autoFlow:Boolean) : Atom {
        conductor(atom, autoFlow);
        return this.atom
    }
    override fun conductor(atom: Atom, autoFlow:Boolean) : Unit {
        this.atom.diode(atom, autoFlow)
        atom.diode(this.atom, autoFlow)
    }

    override fun setAtom(atom:Atom) : Atom {
        this.atom = atom
        return this.atom
    }
}