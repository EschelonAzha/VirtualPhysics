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

import asymmetrical.physics.machine.config.Config
import symmetrical.dictionary.absorber.class_groups.*
import symmetrical.transpectors.transpectors.Strings
import symmetrical.physics.subatomic.bosons.IEmitter
import symmetrical.physics.subatomic.bosons.Photon
import kotlin.reflect.KClass

object Absorber : symmetrical.dictionary.absorber.IAbsorber {
    val beam: symmetrical.dictionary.absorber.ClassGroup = symmetrical.dictionary.absorber.ClassGroup()
    init {
        symmetrical.dictionary.absorber.Absorber.beam.addAll(AppClasses())
        symmetrical.dictionary.absorber.Absorber.beam.addAll(Atoms())
        symmetrical.dictionary.absorber.Absorber.beam.addAll(Dimensions())
        symmetrical.dictionary.absorber.Absorber.beam.addAll(Charges())
        symmetrical.dictionary.absorber.Absorber.beam.addAll(Compounds())
        symmetrical.dictionary.absorber.Absorber.beam.addAll(Cosmic())
        symmetrical.dictionary.absorber.Absorber.beam.addAll(DictionaryGroup())
        symmetrical.dictionary.absorber.Absorber.beam.addAll(Elements())
        symmetrical.dictionary.absorber.Absorber.beam.addAll(Encodings())
        symmetrical.dictionary.absorber.Absorber.beam.addAll(FundamentalProperties())
        symmetrical.dictionary.absorber.Absorber.beam.addAll(Hadrons())
        symmetrical.dictionary.absorber.Absorber.beam.addAll(Ions())
        symmetrical.dictionary.absorber.Absorber.beam.addAll(Leptons())
        symmetrical.dictionary.absorber.Absorber.beam.addAll(Quarks())
        symmetrical.dictionary.absorber.Absorber.beam.addAll(Spacial())

    }


    override fun addAll(group: symmetrical.dictionary.absorber.ClassGroup) : symmetrical.dictionary.absorber.Absorber {
        symmetrical.dictionary.absorber.Absorber.beam.addAll(group)
        return this
    }
    override fun createInstance(classId:String) : Any? {
        for (i in 0 until symmetrical.dictionary.absorber.Absorber.beam.size()) {
            val entityId = symmetrical.dictionary.absorber.Absorber.beam.get(i) as symmetrical.dictionary.absorber.EntityId
            if (entityId.classId == classId) {
                return symmetrical.dictionary.absorber.Absorber.newInstance(entityId.classType)
            }
        }
        return null
    }
    override fun getClassId(classType: KClass<*>) : String {

        for (i in 0 until symmetrical.dictionary.absorber.Absorber.beam.size()) {
            val entityId = symmetrical.dictionary.absorber.Absorber.beam.get(i) as symmetrical.dictionary.absorber.EntityId
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
    override fun initialize() : symmetrical.dictionary.absorber.Absorber {
        symmetrical.dictionary.absorber.Absorber.beam.print()
        return this
    }
    override fun initialize(group: symmetrical.dictionary.absorber.ClassGroup) : symmetrical.dictionary.absorber.Absorber {
        symmetrical.dictionary.absorber.Absorber.beam.addAll(group)
        symmetrical.dictionary.absorber.Absorber.beam.print()
        return this
    }
    override fun materialize(emission:String) : Pair<IEmitter, String> {
        var (classId, remainder) = Strings.remainder(Config.getClassIdLth(), emission)
        val clone = symmetrical.dictionary.absorber.Absorber.createInstance(classId) as IEmitter
        val remainderPhoton: Photon = clone.absorb(Photon().with(emission))
        return Pair<IEmitter, String>(clone, remainderPhoton.radiate())
    }
    override fun materialize(photon: Photon) : Pair<IEmitter, String> {
        return symmetrical.dictionary.absorber.Absorber.materialize(photon.radiate())
    }

    override fun newInstance(classType:KClass<*>) : Any? {
        for (i:Int in 0 until symmetrical.dictionary.absorber.Absorber.beam.size()) {
            val entityId: symmetrical.dictionary.absorber.EntityId = symmetrical.dictionary.absorber.Absorber.beam.get(i) as symmetrical.dictionary.absorber.EntityId
            if (entityId.has(classType))
                return entityId.newInstance()
        }
        return null
    }

}

