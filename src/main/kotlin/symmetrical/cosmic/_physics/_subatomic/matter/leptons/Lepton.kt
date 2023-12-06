package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiLepton
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.Fundamentals
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.QuantumPhotonicField
import symmetrical.cosmic._physics._subatomic.spacial.IParticleBeam

open class Lepton(
    private val antiMatter: IAntiMatter = AntiMatter(Lepton::class, AntiLepton::class),
) : Particle(),
    IAntiMatter by antiMatter,
    Emitter
{
    constructor() : this(
        AntiMatter(Lepton::class, AntiLepton::class),
    )



    override fun absorb(photon: Photon) : Photon {
        antiMatter.check(photon);

        val (clone, remainder) = Absorber.materialize(photon.propagate())
        this.fundamentals = clone as Fundamentals
        return Photon(remainder)
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return antiMatter.getClassId()+fundamentals.emit().radiate()
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    open fun i() : Lepton {
        return this
    }
//    fun getValue() : Any? {
//        val wavelength:Wavelength = getWavelength()
//        return wavelength.wavelength()
//    }
    override fun getIlluminations() : IParticleBeam {
        return antiMatter.getIlluminations()
    }
//    fun getPhoton() : Photon {
//        return fundamentals.getPhoton()
//    }
//    fun getSpin() : Spin {
//        return fundamentals.getSpin()
//    }
//    fun getWavelength() : QuantumPhotonicField {
//        return fundamentals.getWavelength()
//    }
//    fun setSpin(spin: Spin) : Lepton {
//        this.fundamentals.setSpin(spin)
//        return this
//    }
//    fun setValue(value:Any?) : Lepton {
//        this.setWavelength(value)
//        return this
//    }
//    fun setWavelength(value:Any?) : Lepton {
//        this.getWavelength().setValue(value)
//        return this
//    }
//    fun spin() : Boolean {
//        return getSpin().isPlus()
//    }
//    fun wavelength() : Any? {
//        return getWavelength().getValue()
//    }
//    fun wavelengthStr() : String {
//        val result = wavelength() ?: return ""
//        return result.toString()
//    }



}