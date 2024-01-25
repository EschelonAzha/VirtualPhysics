package symmetrical.cosmic.physics.subatomic.luminescent
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

import symmetrical.cosmic.absorber.Absorber
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.spacial.IParticleBeam
import symmetrical.cosmic.physics.subatomic.spacial.ParticleBeam
import kotlin.reflect.KClass
/*
https://en.wikipedia.org/wiki/Annihilation
 */
open class MatterAntiMatter: IMatterAntiMatter {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }

    private lateinit var classType   : KClass<*>


    override fun with(classType: KClass<*>) : IMatterAntiMatter{
        this.classType = classType
        return this
    }
    override fun annihilate() : Photon {
        return Photon()
    }
    override fun check(photon: Photon) : Photon {
        val classId = getClassId()

        val radiation = photon.radiate()
        if (radiation.startsWith(classId))
            return photon
        println("Radiation Leak in: "+this::class.simpleName);
        return photon
    }
    override fun getClassId() : String {
        return Absorber.getClassId(this.classType)
    }
    override fun getIlluminations() : IParticleBeam {
        return Illuminations.beam
    }

}