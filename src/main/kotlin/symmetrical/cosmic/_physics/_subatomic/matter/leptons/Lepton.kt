package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiLepton
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.Positron
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.Fundamentals
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent
import symmetrical.cosmic._physics._subatomic.spatial.IParticleBeam

open class Lepton(
    private val luminescent: ILuminescent = Luminescent(Lepton::class),
) : Particle(),
    ILuminescent by luminescent,
    Emitter
{
    constructor() : this(
        Luminescent(Lepton::class),
    )
    init {
        setAntiMatter(AntiLepton::class)
    }

    protected var fundamentals: Fundamentals = Fundamentals()

    override fun absorb(photon: Photon) : Photon {
        luminescent.check(photon);

        val (clone, remainder) = Absorber.materialize(photon.propagate())
        this.fundamentals = clone as Fundamentals
        return Photon(remainder)
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return luminescent.getClassId()+fundamentals.emit().radiate()
    }
    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    open fun i() : Lepton {
        return this
    }
//    fun getValue() : Any? {
//        val wavelength:Wavelength = getWavelength()
//        return wavelength.wavelength()
//    }
    override fun getIlluminations() : IParticleBeam {
        return luminescent.getIlluminations()
    }
    fun getPhoton() : Photon {
        return fundamentals.getPhoton()
    }
    fun getSpin() : Spin {
        return fundamentals.getSpin()
    }
    fun getWavelength() : Wavelength {
        return fundamentals.getWavelength()
    }
    fun setSpin(spin: Spin) : Lepton {
        this.fundamentals.setSpin(spin)
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
    fun spin() : Boolean {
        return getSpin().isPlus()
    }
    fun wavelength() : Any? {
        return getWavelength().wavelength()
    }
    fun wavelengthStr() : String {
        val result = wavelength() ?: return ""
        return result.toString()
    }



}