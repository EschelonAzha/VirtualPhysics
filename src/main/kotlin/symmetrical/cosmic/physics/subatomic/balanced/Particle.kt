package symmetrical.cosmic.physics.subatomic.balanced
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
import symmetrical.cosmic.transpectors.transpectors.Keys
import symmetrical.cosmic.physics.subatomic.balanced.fundamentals.angular_momentum.AngularMomentum
import symmetrical.cosmic.physics.subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic.physics.subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic.physics.subatomic.bosons.IEmitter
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.spacial.IParticleBeam
import symmetrical.cosmic.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.MatterAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.QuasiParticle
import symmetrical.cosmic.physics.dimensions.*

/*
https://en.wikipedia.org/wiki/Particle
 */

open class Particle(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(Particle::class),
) :
    IMatterAntiMatter by matterAntiMatter,
    IParticle,
    IEmitter
{
    constructor() : this(
        MatterAntiMatter(Particle::class),
    ) {
        time.setContent(200)
    }

    object Static {
        public val debuggingOn :Boolean = false
    }



    private lateinit var self   : IParticle

    private     var uniqueId        : QuasiParticle         = QuasiParticle()

    private     val time            : Time                  = Time()
    private     val charge          : Charge                = Charge()
    private     val space           : Space                 = Space()
    private     val mass            : Mass                  = Mass()
    private     val temperature     : Temperature           = Temperature()

    private     val _wavelength     :Wavelength             = Wavelength()
    private     var spin            :Spin                   = Spin()
    private     var angularMomentum : AngularMomentum = AngularMomentum()

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

    fun getSimpleName() : String {
        return Classes.getSimpleName(this)
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    override fun createUniqueId(): IParticle {
        uniqueId.setContent(getClassId()+Keys.getUniqueId())
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

    override fun setSelf(self: IParticle) : IParticle {
        this.self = self
        return getSelf()
    }
    override fun setSpin(spin:Spin) : IParticle {
        this.spin = spin
        return this
    }
    fun setUniqueId(id:String) : IParticle {
        this.uniqueId.setContent(id)
        return getSelf()
    }

    //  FUNDAMENTALS !!!!!!!!!!!!!!!!!!!!!!!

    override fun getPhoton() : Photon {
        return Photon()
    }


    override fun setAngularMomentum(angularMomentum: AngularMomentum) : IParticle {
        this.angularMomentum = angularMomentum
        return this;
    }


    override fun setWavelength(value:Any?) : IParticle {
        this.getWavelength().setContent(value)
        return this
    }
    override fun spin() : Boolean {
        return getSpin().isPlus()
    }
    override fun wavelength() : Any? {
        return getWavelength().getContent()
    }
    override fun wavelengthStr() : String {
        val result = wavelength() ?: return ""
        return result.toString()
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