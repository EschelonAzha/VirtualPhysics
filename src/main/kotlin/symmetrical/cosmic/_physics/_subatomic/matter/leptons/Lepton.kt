package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.Fundamentals
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength

import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

open class Lepton(private val particle: Particle = Particle()) : IParticle by particle, Emitter {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }

    private var fundamentalParticleProperties: Fundamentals = Fundamentals()

    constructor() : this(Particle()) {
    }
    public open fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun check(photon: Photon) : Unit {
        val classId = getLocalClassId()

        val radiation = photon.radiate()
        if (radiation.startsWith(classId))
            return
        println("Radiation Leak in: "+this::class.simpleName)
        return;
    }
    override fun absorb(photon: Photon) : Photon {
        check(photon);

        val (clone, remainder) = Absorber.materialize(photon.propagate())
        this.fundamentalParticleProperties = clone as Fundamentals
        return Photon(remainder)
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return getLocalClassId()+fundamentalParticleProperties.emit().radiate()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Lepton::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    open fun i() : Lepton {
        return this
    }
//    fun getValue() : Any? {
//        val wavelength:Wavelength = getWavelength()
//        return wavelength.wavelength()
//    }
    fun getPhoton() : Photon {
        return fundamentalParticleProperties.getPhoton()
    }
    fun getSpin() : Spin {
        return fundamentalParticleProperties.getSpin()
    }
    fun getWavelength() : Wavelength {
        return fundamentalParticleProperties.getWavelength()
    }
    fun setSpin(spin: Spin) : Lepton {
        this.fundamentalParticleProperties.setSpin(spin)
        return this
    }
    fun setValue(value:Any?) : Lepton {
        this.setWavelength(value)
        return this
    }
    fun setWavelength(value:Any?) : Lepton {
        this.getWavelength().setWavelength(value)
        return this
    }
    fun spin() : String {
        return getSpin().format(getWavelength())
    }
    fun wavelength() : Any? {
        return getWavelength().wavelength()
    }
    fun wavelengthStr() : String {
        val result = wavelength() ?: return ""
        return result.toString()
    }



}