package symmetrical.physics.subatomic.balanced
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

import symmetrical.physics.dimensions.*
import symmetrical.physics.subatomic.balanced.fundamentals.angular_momentum.AngularMomentum
import symmetrical.physics.subatomic.balanced.fundamentals.spin.Spin
import symmetrical.physics.subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.dimensions.*
import symmetrical.physics.subatomic.bosons.IEmitter


/*
https://en.wikipedia.org/wiki/Particle
 */

interface IParticle : IQuantum, IEmitter {
    fun createGalaxyId()                                        : IParticle
    fun createUniqueId()                                        : IParticle
    fun getClassId    ()                                        : String
    fun getGalaxyId   ()                                        : String
    fun getSelf       ()                                        : IParticle
    fun getUniqueId   ()                                        : String


    fun setSelf       (self: IParticle)                         : IParticle

    fun getAngularMomentum()                                    : AngularMomentum

    fun getTime()                                               : Time
    fun getCharge()                                             : Charge
    fun getSpace()                                              : Space
    fun getMass()                                               : Mass
    fun getTemperature()                                        : Temperature

    fun getSpin()                                               : Spin
    fun getWavelength()                                         : Wavelength

    fun getPhoton()                                             : Photon
    fun spin()                                                  : Boolean
}