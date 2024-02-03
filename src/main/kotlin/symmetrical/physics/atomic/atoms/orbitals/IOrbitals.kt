package symmetrical.physics.atomic.atoms.orbitals
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

import symmetrical.physics.subatomic.balanced.fundamentals.spin.Spin
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.matter.bosons.ZBoson
import symmetrical.physics.subatomic.matter.leptons.Electron
import symmetrical.physics.atomic.atoms.Atom
/*
https://en.wikipedia.org/wiki/Atomic_orbital
 */
interface IOrbitals {

    fun electronSpin            ()              : Boolean
    fun electronValue           ()              : Any?
    fun electronValueStr        ()              : String
    fun getClassId              ()              : String
    fun getElectronPhoton       ()              : Photon
    fun getElectronSpin         ()              : Spin
    fun getElectronValue        ()              : symmetrical.physics.subatomic.matter.leptons.Electron
    fun getElectronWavelength   ()              : Any?

    fun setAtom                 (atom: symmetrical.physics.atomic.atoms.Atom)    : symmetrical.physics.atomic.atoms.Atom
    fun setElectronSpin         (spin: Spin)    : symmetrical.physics.atomic.atoms.Atom
    fun setElectronValue        (value:Any?)    : symmetrical.physics.subatomic.matter.bosons.ZBoson

}