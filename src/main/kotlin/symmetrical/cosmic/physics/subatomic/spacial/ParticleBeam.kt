package symmetrical.cosmic.physics.subatomic.spacial
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
import symmetrical.cosmic.absorber.Absorber
import symmetrical.cosmic.physics.subatomic.balanced.IParticle
import symmetrical.cosmic.physics.subatomic.balanced.Particle
import symmetrical.cosmic.transpectors.printable_characters.Base52
import symmetrical.cosmic.transpectors.transpectors.Strings
import symmetrical.cosmic.physics.subatomic.bosons.IEmitter
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.MatterAntiMatter
import kotlin.reflect.KClass
/*
https://en.wikipedia.org/wiki/Particle_beam
 */
open class ParticleBeam(
    private   val matterAntiMatter : IMatterAntiMatter = MatterAntiMatter(ParticleBeam::class),
    protected val _beam            : Beam = Beam()
) : Particle(),
    IMatterAntiMatter by matterAntiMatter,
    IBeam by _beam,
    IParticleBeam,
    IEmitter
{
    constructor() : this(
        MatterAntiMatter(ParticleBeam::class),
        Beam()
    )
    init {
    }
    object Static {
        const val LAST      : Int = -1
    }

    open fun i() : ParticleBeam {
        _beam.i()
        return this
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
        return Photon(remainder)
    }
    override fun add(particle: IParticle) : IParticle {
        return _beam.add(particle) as IParticle
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    fun find(particle: IParticle) : Int {
        return _beam.find(particle)
    }
    override fun find(item:Any) : Int {
        return _beam.find(item)
    }
    override fun find(kClass: KClass<*>) : Int {
        return _beam.find(kClass)
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    override operator fun get(pos:Int): IParticle {
        val result = _beam.get(pos)
        return result as IParticle
    }
    override fun getParticleCore() : Array<IParticle> {
        return getCore() as Array<IParticle>
    }
    override fun set(pos:Int, particle: IParticle) : IParticle {
        return _beam.set(pos, particle) as IParticle
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