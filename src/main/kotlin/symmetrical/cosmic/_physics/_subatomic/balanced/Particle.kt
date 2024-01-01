package symmetrical.cosmic._physics._subatomic.balanced

import asymmetrical.machine.vm.Classes
import symmetrical.cosmic.__transpectors.transpectors.Keys
import symmetrical.cosmic._physics._dimensions.*
import symmetrical.cosmic._physics._subatomic.anti_matter.AntiParticle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.AngularMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.*
import symmetrical.cosmic._physics._subatomic.spacial.IParticleBeam
/*
https://en.wikipedia.org/wiki/Particle
 */

open class Particle(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(Particle::class, AntiParticle::class),
) :
    IMatterAntiMatter by matterAntiMatter,
    IParticle,
    IEmitter
{
    constructor() : this(
        MatterAntiMatter(Particle::class, AntiParticle::class),
    ) {
        time.setContent(200)
    }

    object Static {
        public val debuggingOn :Boolean = false
    }



    private lateinit var self   :IParticle

    private     var uniqueId        :QuasiParticle           = QuasiParticle()

    private     val time            :Time                   = Time()
    private     val charge          :Charge                 = Charge()
    private     val space           :Space                  = Space()
    private     val mass            :Mass                   = Mass()
    private     val temperature     :Temperature            = Temperature()

    private     val _wavelength     :Wavelength             = Wavelength()
    private     var spin            :Spin                   = Spin()
    private     var angularMomentum :AngularMomentum        = AngularMomentum()

    override fun absorb(photon:Photon) : Photon {
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


    override fun setAngularMomentum(angularMomentum:AngularMomentum) : IParticle {
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