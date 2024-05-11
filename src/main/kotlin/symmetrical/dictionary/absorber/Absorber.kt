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
import symmetrical.chemistry.diatomics.KeyData
import symmetrical.dictionary.absorber.class_groups.*
import symmetrical.dictionary.quasiparticles.GalaxyId
import symmetrical.dictionary.quasiparticles.RemoteId
import symmetrical.physics.dimensions.Vacuum
import symmetrical.physics.subatomic.balanced.IParticle
import symmetrical.transpectors.transpectors.Strings
import symmetrical.physics.subatomic.bosons.IEmitter
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.transpectors.printable_characters.Base52
import kotlin.reflect.KClass

object Absorber : IAbsorber {
    private var monoGalactic    : Boolean           = true;
    private var galaxyId        : String            = "aaa"
    private var remoteId        : String            = "Aaa"
    private val beam            : ClassGroup        = ClassGroup()

    private val diatomics       : Diatomics         = Diatomics

    init {
        Absorber.beam.add(EntityId().with(Vacuum.getClassId(), Vacuum::class))
        Absorber.beam.addAll(AppClasses())
        Absorber.beam.addAll(Atoms())
        Absorber.beam.addAll(Dimensions())
        Absorber.beam.addAll(Charges())
        Absorber.beam.addAll(Compounds())
        Absorber.beam.addAll(Cosmic())
        Absorber.beam.addAll(DictionaryGroup())
        Absorber.beam.addAll(Elements())
        Absorber.beam.addAll(Encodings())
        Absorber.beam.addAll(FundamentalProperties())
        Absorber.beam.addAll(Hadrons())
        Absorber.beam.addAll(Ions())
        Absorber.beam.addAll(QuasiParticles())
        Absorber.beam.addAll(Leptons())
        Absorber.beam.addAll(Quarks())
        Absorber.beam.addAll(Spacial())

    }


    override fun addAll(group: ClassGroup) : Absorber {
        Absorber.beam.addAll(group)
        return this
    }
    override fun createInstance(classId:String) : Any? {
        for (i in 0 until Absorber.beam.size()) {
            val entityId = Absorber.beam.get(i) as EntityId
            if (entityId.classId == classId) {
                return Absorber.newInstance(entityId.classType)
            }
        }
        return null
    }
    override fun getClassId(classType: KClass<*>) : String {

        for (i in 0 until Absorber.beam.size()) {
            val entityId = Absorber.beam.get(i) as EntityId
            if (entityId.classType == classType)
                return entityId.classId
        }
        println("")
        println("!!!!!!!!!!!!!!!!!!!")
        println("Absorber::getClassId(classType:KClass could not find: $classType")
        println("!!!!!!!!!!!!!!!!!!!")
        println("")
        return ""
    }

    override fun getGalaxyId() : String {
        return galaxyId
    }
    override fun getRemoteId() : String {
        return remoteId
    }
    override fun initialize() : Absorber {
        Absorber.beam.print()
        return this
    }
    override fun initialize(group: ClassGroup) : Absorber {
        Absorber.beam.addAll(group)
        Absorber.beam.print()
        return this
    }
    override fun isMonoGalactic() : Boolean {
        return monoGalactic
    }
    override fun materialize(emission:String) : Pair<IEmitter?, String> {
        var (classId, remainder) = Strings.remainder(Config.getClassIdLth(), emission)
        val emitter = Absorber.createInstance(classId) as IEmitter?
        if (emitter == null) {
            println("!!!!!!! Absorber Materialize Failed !!!!!!!! :$emission")
            if (!Strings.isAlpha(classId)) {
                println("!!!!!!! ClassId not Alpha !!!!!!!!")
            }
            return Pair<IEmitter?, String>(emitter, Photon().with(emission).radiate())
        }
        val clone           : IEmitter  = emitter as IEmitter
        val remainderPhoton : Photon    = clone.absorb(Photon().with(emission))

        illuminate(clone)

        return Pair<IEmitter, String>(clone, remainderPhoton.radiate())
    }
    override fun materialize(photon: Photon) : Pair<IEmitter?, String> {
        return Absorber.materialize(photon.radiate())
    }

    override fun newInstance(classType:KClass<*>) : Any? {
        for (i:Int in 0 until Absorber.beam.size()) {
            val entityId: EntityId = Absorber.beam.get(i) as EntityId
            if (entityId.has(classType))
                return entityId.newInstance()
        }
        return null
    }

    override fun setGalaxyId(galaxyId:GalaxyId) : Unit {
        val id = galaxyId.toString()
        Absorber.galaxyId = id
    }

    override fun setMonoGalactic(isMonoGalactic:Boolean) : IAbsorber {
        this.monoGalactic = isMonoGalactic
        return this
    }
    override fun setRemoteId(remoteId: RemoteId) : Unit {
        val id = remoteId.toString()
        Absorber.remoteId = id
    }
    private fun illuminate(clone:IEmitter) : Unit {
        if (clone.isIlluminated())
            Diatomics.illuminate(clone as IParticle)
    }

}

