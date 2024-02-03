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


import symmetrical.physics.atomic.atoms.Atom
import symmetrical.physics.subatomic.matter.hadrons.baryons.Proton
import symmetrical.electronics.interfaces.ICapacitor

// for more information see:   https://en.wikipedia.org/wiki/Capacitor

class Capacitor : ICapacitor {

    private lateinit var atom: symmetrical.physics.atomic.atoms.Atom

    override fun capacitor(atom: symmetrical.physics.atomic.atoms.Atom) : Unit {
        val me : symmetrical.physics.subatomic.matter.hadrons.baryons.Proton = this.atom.getValueProton()
        val you: symmetrical.physics.subatomic.matter.hadrons.baryons.Proton = atom.getValueProton()

        me.ionicBond(you)
    }

    override fun capacitor_(atom: symmetrical.physics.atomic.atoms.Atom) : symmetrical.physics.atomic.atoms.Atom {
        capacitor(atom);
        return atom
    }
    override fun _capacitor(atom: symmetrical.physics.atomic.atoms.Atom) : symmetrical.physics.atomic.atoms.Atom {
        capacitor(atom);
        return this.atom
    }

    override fun setAtom(atom: symmetrical.physics.atomic.atoms.Atom) : symmetrical.physics.atomic.atoms.Atom {
        this.atom = atom
        return this.atom
    }
}