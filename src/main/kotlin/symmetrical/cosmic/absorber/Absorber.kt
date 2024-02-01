package symmetrical.cosmic.absorber
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

import asymmetrical.physics.machine.config.Config
import symmetrical.cosmic.absorber.class_groups.*
import symmetrical.cosmic.transpectors.transpectors.Strings
import symmetrical.cosmic.physics.subatomic.bosons.IEmitter
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import kotlin.reflect.KClass

object Absorber : IAbsorber {
    val beam: ClassGroup = ClassGroup()
    init {
        beam.addAll(AppClasses())
        beam.addAll(Atoms())
        beam.addAll(Dimensions())
        beam.addAll(Charges())
        beam.addAll(Compounds())
        beam.addAll(Cosmic())
        beam.addAll(DictionaryGroup())
        beam.addAll(Elements())
        beam.addAll(Encodings())
        beam.addAll(FundamentalProperties())
        beam.addAll(Hadrons())
        beam.addAll(Ions())
        beam.addAll(Leptons())
        beam.addAll(Quarks())
        beam.addAll(Spacial())

    }


    override fun addAll(group:ClassGroup) : Absorber {
        beam.addAll(group)
        return this
    }
    override fun createInstance(classId:String) : Any? {
        for (i in 0 until beam.size()) {
            val entityId = beam.get(i) as EntityId
            if (entityId.classId == classId) {
                return newInstance(entityId.classType)
            }
        }
        return null
    }
    override fun getClassId(classType: KClass<*>) : String {

        for (i in 0 until beam.size()) {
            val entityId = beam.get(i) as EntityId
            if (entityId.classType == classType)
                return entityId.classId
        }
        println("")
        println("!!!!!!!!!!!!!!!!!!!")
        println("PhotonDetector::getClassId(classType:KClass could not find: $classType")
        println("!!!!!!!!!!!!!!!!!!!")
        println("")
        return ""
    }
    override fun initialize() : Absorber {
        beam.print()
        return this
    }
    override fun initialize(group:ClassGroup) : Absorber {
        beam.addAll(group)
        beam.print()
        return this
    }
    override fun materialize(emission:String) : Pair<IEmitter, String> {
        var (classId, remainder) = Strings.remainder(Config.getClassIdLth(), emission)
        val clone = createInstance(classId) as IEmitter
        val remainderPhoton: Photon = clone.absorb(Photon().with(emission))
        return Pair<IEmitter, String>(clone, remainderPhoton.radiate())
    }
    override fun materialize(photon: Photon) : Pair<IEmitter, String> {
        return materialize(photon.radiate())
    }

    override fun newInstance(classType:KClass<*>) : Any? {
        for (i:Int in 0 until beam.size()) {
            val entityId:EntityId = beam.get(i) as EntityId
            if (entityId.has(classType))
                return entityId.newInstance()
        }
        return null
    }

}

