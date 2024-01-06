package symmetrical.cosmic.physics.subatomic.balanced
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

import symmetrical.cosmic.physics.dimensions.*
import symmetrical.cosmic.physics.subatomic.balanced.fundamentals.angularMomentum.AngularMomentum
import symmetrical.cosmic.physics.subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic.physics.subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic.physics.subatomic.bosons.Photon


/*
https://en.wikipedia.org/wiki/Particle
 */

interface IParticle {
    fun createUniqueId()                    : IParticle
    fun getUniqueId   ()                    : String
    fun getClassId    ()                    : String
    fun getSelf       ()                    : IParticle
    fun setSelf       (self: IParticle)     : IParticle

    fun getAngularMomentum() : AngularMomentum

    fun getTime() : Time
    fun getCharge() : Charge
    fun getSpace() : Space
    fun getMass() : Mass
    fun getTemperature() : Temperature

    fun getSpin() : Spin
    fun getWavelength() : Wavelength

    fun getPhoton() : Photon
    fun setAngularMomentum(angularMomentum:AngularMomentum) : IParticle
    fun setSpin(spin: Spin) : IParticle
    fun setWavelength(value:Any?) : IParticle
    fun spin() : Boolean
    fun wavelength() : Any?
    fun wavelengthStr() : String
}