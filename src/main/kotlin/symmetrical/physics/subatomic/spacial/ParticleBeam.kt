package symmetrical.physics.subatomic.spacial
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
import symmetrical.dictionary.absorber.Absorber
import symmetrical.physics.subatomic.balanced.IParticle
import symmetrical.physics.subatomic.balanced.Particle
import symmetrical.transpectors.printable_characters.Base52
import symmetrical.transpectors.transpectors.Strings
import symmetrical.physics.subatomic.bosons.IEmitter
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.physics.subatomic.luminescent.MatterAntiMatter
import kotlin.reflect.KClass

// For more information visit:   https://en.wikipedia.org/wiki/Particle_beam

open class ParticleBeam(
    private   val matterAntiMatter : IMatterAntiMatter = MatterAntiMatter().with(ParticleBeam::class),
    protected val _beam            : Beam = Beam()
) : Particle(),
    IMatterAntiMatter by matterAntiMatter,
    IBeam by _beam,
    IParticleBeam,
    IEmitter
{

    open fun capacity(initialCapacity:Int=1) : ParticleBeam {
        _beam.capacity(initialCapacity)
        return this
    }

    object Static {
        const val LAST      : Int = -1
    }

    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        val particleRemainder : Photon = super.absorb(photon.propagate())
        val (size52:String, line:String)    = Strings.remainder(3, particleRemainder.radiate())
        val size:Int                        = Base52.toInt(size52)
        var remainder : String              = line
        
        for (i in 0 until size) {
            val (emitter, line) = Absorber.materialize(remainder)
            add(emitter)
            remainder = line
        }
        shrink()
        return Photon().with(remainder)
    }
    override fun add(particle: IEmitter) : IEmitter {
        return _beam.add(particle) as IEmitter
    }

    override fun emit() : Photon {
        return Photon().with(radiate())
    }
    fun find(particle: IParticle) : Int {
        return _beam.find(particle)
    }
    override fun find(item:Any) : Int {
        return _beam.find(item)
    }
    override fun findByType(classType: KClass<*>) : Int {
        return _beam.findByType(classType)
    }

    fun findByUniqueId(uniqueId:String) : Int {
        for (i in 0 until _beam.size()) {
            val particle:Particle = get(0) as Particle
            if (particle.getUniqueId()== uniqueId)
                return i
        }
        return -1
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    override operator fun get(pos:Int): IEmitter {
        val result = _beam.get(pos)
        return result as IEmitter
    }
    override fun getParticleCore() : Array<IEmitter> {
        return getCore() as Array<IEmitter>
    }
    override fun set(pos:Int, particle: IEmitter) : IEmitter {
        return _beam.set(pos, particle) as IEmitter
    }

    private fun radiate() : String {
        if (Particle.Static.debuggingOn) {
            println("ParticleBeam")
        }
        val classId     :String = matterAntiMatter.getClassId()
        val particle    :String = super.emit().radiate()
        if (size() > 140606) {
            println("ParticleBeam::radiate() ************************** MAXIMUM ARRAY SIZE EXCEEDED *********************")
            println("ParticleBeam::radiate() ************************** MAXIMUM ARRAY SIZE EXCEEDED *********************")
            println("ParticleBeam::radiate() ************************** MAXIMUM ARRAY SIZE EXCEEDED *********************")
        }
        val base52Size  :String = Base52.toFixedBase52(Config.getBase52ArraySize(), size())

        var emission = classId+particle+base52Size
        for (i:Int in 0 until size()) {
            val emitter: IEmitter = get(i) as IEmitter
            emission+=emitter.emit().radiate()
        }

        return emission
    }

}