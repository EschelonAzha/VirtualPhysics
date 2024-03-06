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

import asymmetrical.physics.machine.vm.Classes
import symmetrical.transpectors.transpectors.Keys
import symmetrical.physics.subatomic.balanced.fundamentals.angular_momentum.AngularMomentum
import symmetrical.physics.subatomic.balanced.fundamentals.spin.Spin
import symmetrical.physics.subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.physics.subatomic.bosons.IEmitter
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.spacial.IParticleBeam
import symmetrical.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.physics.subatomic.luminescent.MatterAntiMatter
import symmetrical.physics.subatomic.luminescent.QuasiParticle
import symmetrical.physics.dimensions.*


// For more information visit:   https://en.wikipedia.org/wiki/Particle


open class Particle(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter().with(Particle::class),
) :
    IMatterAntiMatter by matterAntiMatter,
    IParticle,
    IEmitter
{

    private lateinit var self       : IParticle
    private     var ptr_quantum     : IQuantum?   = null
    private     var uniqueId        : QuasiParticle         = QuasiParticle()

    private     val time            : Time                  = Time().withQuantum(this)
    private     val charge          : Charge                = Charge().withQuantum(this)
    private     val space           : Space                 = Space().withQuantum(this)
    private     val mass            : Mass                  = Mass().withQuantum(this)
    private     val temperature     : Temperature           = Temperature().withQuantum(this)

    private     val _wavelength     : Wavelength            = Wavelength().withQuantum(this)
    private     var spin            : Spin                  = Spin().withQuantum(this)
    private     var angularMomentum : AngularMomentum       = AngularMomentum().withQuantum(this)

    init {
        time.setContent(0)
    }

    object Static {
        public val debuggingOn :Boolean = false
    }
    override fun absorb(photon: Photon) : Photon {
        var remainder = photon.propagate()
        remainder = uniqueId.absorb(remainder)
        remainder = time.absorb(remainder)
        remainder = charge.absorb(remainder)
        remainder = mass.absorb(remainder)
        remainder = temperature.absorb(remainder)
        remainder = space.absorb(remainder)
        remainder = _wavelength.absorb(remainder)
        remainder = spin.absorb(remainder)
        remainder = angularMomentum.absorb(remainder)

        return remainder
    }
    fun breakpoint() : Unit {
        return
    }

    override fun getQuantum() : IQuantum? {
        return ptr_quantum
    }

    override fun getQuantumRoot() : IQuantum {
        if (ptr_quantum  == null)
            return this
        return ptr_quantum!!.getQuantumRoot()
    }
    fun getSimpleName() : String {
        return Classes.getSimpleName(this)
    }

    override fun emit() : Photon {
        return Photon().with(radiate())
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    override fun createUniqueId(): IParticle {
        uniqueId.setContent(getClassId()+ Keys.getUniqueId())
        return getSelf()
    }

    override fun getAngularMomentum() : AngularMomentum {
        return angularMomentum
    }
    override fun getCharge() : Charge {
        return charge
    }
    override fun getIlluminations() : IParticleBeam {
        return matterAntiMatter.getIlluminations()
    }

    override fun getMass() : Mass {
        return mass
    }
    override fun getPhoton() : Photon {
        return Photon()
    }

    override fun getSelf() : IParticle {
        if (::self.isInitialized)
            return self
        else return this
    }
    override fun getSpace() : Space {
        return space
    }
    override fun getSpin() : Spin {
        return spin
    }

    override fun getTemperature() : Temperature {
        return temperature
    }
    override fun getTime() : Time {
        return time
    }

    override fun getUniqueId(): String {
        return uniqueId.getContent() as String
    }

    override fun getWavelength() : Wavelength {
        return _wavelength
    }

    override fun setQuantum(quantum:IQuantum) : IQuantum {
        this.ptr_quantum = quantum
        return this
    }

    override fun setSelf(self: IParticle) : IParticle {
        this.self = self
        return getSelf()
    }
    fun setUniqueId(id:String) : IParticle {
        this.uniqueId.setContent(id)
        return getSelf()
    }

    override fun spin() : Boolean {
        return !getSpin().isZero()
    }

    private fun radiate() : String {
        if (Particle.Static.debuggingOn) {
            println("Particle")
        }
        val classId         : String = matterAntiMatter.getClassId()
        val uniqueId        : String = uniqueId.emit().radiate()
        val time            : String = time.emit().radiate()
        val charge          : String = charge.emit().radiate()
        val mass            : String = mass.emit().radiate()
        val temperature     : String = temperature.emit().radiate()
        val space           : String = space.emit().radiate()
        val wavelength      : String = _wavelength.emit().radiate()
        val spin            : String = spin.emit().radiate()
        val angularMomentum : String = angularMomentum.emit().radiate()

        return classId+uniqueId+time+charge+mass+temperature+space+wavelength+spin+angularMomentum
    }

}