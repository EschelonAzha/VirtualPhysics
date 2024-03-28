package symmetrical.dictionary.absorber
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

import symmetrical.dictionary.quasiparticles.GalaxyId
import symmetrical.dictionary.quasiparticles.RemoteId
import symmetrical.physics.subatomic.bosons.IEmitter
import symmetrical.physics.subatomic.bosons.Photon
import kotlin.reflect.KClass

interface IAbsorber {
    fun addAll(group:ClassGroup)            : Absorber
    fun createInstance(id:String)           : Any?
    fun getClassId(classType: KClass<*>)    : String
    fun getGalaxyId()                       : String
    fun getRemoteId()                       : String
    fun initialize()                        : Absorber
    fun initialize(group:ClassGroup)        : Absorber

    fun isMonoGalactic()                        : Boolean
    fun materialize(emission:String)            : Pair<IEmitter?, String>
    fun materialize(photon: Photon)             : Pair<IEmitter?, String>
    fun newInstance(classType:KClass<*>)        : Any?

    fun setGalaxyId(galaxyId:GalaxyId)          : Unit

    fun setMonoGalactic(isMonoGalactic:Boolean) : IAbsorber
    fun setRemoteId(remoteId: RemoteId)         : Unit
}