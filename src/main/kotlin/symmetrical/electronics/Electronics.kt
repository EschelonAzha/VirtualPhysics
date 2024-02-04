package symmetrical.electronics
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
import symmetrical.electronics.components.Capacitor
import symmetrical.electronics.components.Conductor
import symmetrical.electronics.components.Diode
import symmetrical.electronics.interfaces.ICapacitor
import symmetrical.electronics.interfaces.IConductor
import symmetrical.electronics.interfaces.IDiode


class Electronics(
    private val capacitor: ICapacitor   = Capacitor(),
    private val diode    : IDiode       = Diode(),
    private val conductor: IConductor   = Conductor()
) :
    ICapacitor  by capacitor,
    IDiode      by diode,
    IConductor  by conductor,
    IElectronics
{
    override fun setAtom(atom: Atom) : Atom {
        capacitor.setAtom(atom)
        conductor.setAtom(atom)
        diode.setAtom(atom)
        return atom
    }
}