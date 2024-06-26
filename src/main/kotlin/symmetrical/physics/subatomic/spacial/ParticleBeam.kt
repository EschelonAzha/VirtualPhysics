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
import symmetrical.physics.subatomic.forces.gravity.Gravity
import symmetrical.physics.subatomic.forces.gravity.IGravity
import symmetrical.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.physics.subatomic.luminescent.MatterAntiMatter
import kotlin.jvm.Synchronized
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

    var orbitting:Boolean = false

    open fun capacity(initialCapacity:Int=1) : ParticleBeam {
        _beam.capacity(initialCapacity)
        return this
    }

    object Static {
        const val LAST      : Int = -1
    }
    @Synchronized
    override fun add(particle: IEmitter) : IEmitter {
        if (orbitting) {
            if (particle is Particle) {
                particle.orbit(this)
            }
        }
        return _beam.add(particle) as IEmitter
    }
    @Synchronized
    override fun deorbit() : IGravity {
        super.deorbit()
        for (i in 0 until size()) {
            val particle:IEmitter = get(i) as IEmitter
            if (particle is Particle) {
                particle.deorbit()
            }
        }
        this.orbitting = false
        return this
    }
    @Synchronized
    fun find(particle: IParticle) : Int {
        return _beam.find(particle)
    }
    @Synchronized
    override fun find(item:Any) : Int {
        return _beam.find(item)
    }
    @Synchronized
    override fun findByType(classType: KClass<*>) : Int {
        return _beam.findByType(classType)
    }
    @Synchronized
    fun findByUniqueId(uniqueId:String?) : Int {
        if (uniqueId == null)
            return -1
        for (i in 0 until _beam.size()) {
            val particle:Particle = get(i) as Particle
            if (particle.getUniqueId()== uniqueId)
                return i
        }
        return -1
    }
    @Synchronized
    override operator fun get(pos:Int): IEmitter {
        val result = _beam.get(pos)
        return result as IEmitter
    }
    @Synchronized
    override fun getParticleCore() : Array<IEmitter> {
        return getCore() as Array<IEmitter>
    }
    @Synchronized
    override fun orbit(gravity: IGravity) : IGravity {
        super.orbit(gravity)
        for (i in 0 until size()) {
            val particle:Particle = get(i) as Particle
            particle.orbit(this)
        }
        this.orbitting = true
        return this
    }
    @Synchronized
    override fun set(pos:Int, particle: IEmitter) : IEmitter {
        return _beam.set(pos, particle) as IEmitter
    }
    @Synchronized
    override fun transfer(beam:IBeam) : IBeam {
        _beam.transfer(beam)
        return this
    }







    // ########################### EMISSIONS ###########################
    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);
        clear()

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
    override fun emit() : Photon {
        return Photon().with(radiate())
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
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
    // ########################### EMISSIONS ###########################

}