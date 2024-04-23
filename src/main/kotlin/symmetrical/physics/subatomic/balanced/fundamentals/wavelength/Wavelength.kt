package symmetrical.physics.subatomic.balanced.fundamentals.wavelength
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

import symmetrical.dictionary.absorber.Absorber
import symmetrical.physics.subatomic.balanced.values.Field
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.matter.quarks.Quark
import symmetrical.physics.subatomic.luminescent.IQuasiParticle
import symmetrical.physics.subatomic.luminescent.QuasiParticle
import symmetrical.dictionary.protons.ValueProton
import symmetrical.physics.atomic.atoms.Atom
import symmetrical.physics.dimensions.Time
import symmetrical.physics.subatomic.balanced.IQuantum
import symmetrical.physics.subatomic.matter.hadrons.baryons.Proton
import kotlin.reflect.KClass

// For more information visit:   https://en.wikipedia.org/wiki/Wavelength

class Wavelength(
    private val _field: QuasiParticle = QuasiParticle()
) :
    IQuasiParticle by _field {


    fun withQuantum(quantum: IQuantum) : Wavelength {
        this._field.setQuantum(quantum)
        return this
    }

    fun getField() : Field {
        return _field.getField()
    }
    fun getQuantumField() : QuasiParticle {
        return _field
    }
//    fun setWavelength(value:Any?) : Any? {
//        return setContent(value)
//    }
    fun wavelength() : Any? {
        return _field.getContent()
    }





    // ########################### EMISSIONS ###########################
    override fun absorb(photon: Photon) : Photon {
        var remainder = photon.propagate()
        remainder = _field.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }
    public fun getClassId() : String {
        return getLocalClassId()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Wavelength::class)
    }
    private fun radiate() : String {
        return getLocalClassId()+
                _field.emit().radiate()
    }
    // ########################### EMISSIONS ###########################





}