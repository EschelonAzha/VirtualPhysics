package symmetrical.physics.subatomic.balanced.color
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

import symmetrical.physics.subatomic.matter.colors.Green
import symmetrical.physics.atomic.atoms.Atom
import symmetrical.cosmic.dictionary.protons.ValueProton

// For more information visit:   https://en.wikipedia.org/wiki/Color_charge

class ColorCharge() : IColorCharge {
    lateinit var atom     : symmetrical.physics.atomic.atoms.Atom


    override fun blue() : String {
        return atom._nucleons.getProton(ValueProton::class).blue() as String
    }
    override fun currentColor() : Any? {
        return atom._nucleons.getProton(ValueProton::class).currentColor()
    }
    override fun green() : String {
        return atom._nucleons.getProton(ValueProton::class).green() as String
    }
    override fun red() : Any {
        return ""
    }

    override fun setAtom(atom: symmetrical.physics.atomic.atoms.Atom) : symmetrical.physics.atomic.atoms.Atom {
        this.atom = atom
        return atom
    }
    override fun setGreen(green: symmetrical.physics.subatomic.matter.colors.Green) : symmetrical.physics.atomic.atoms.Atom {
        atom._nucleons.getProton(ValueProton::class).setGreen(green)
        return atom
    }
}