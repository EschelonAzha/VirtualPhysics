package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiLepton
import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.Fundamentals
import symmetrical.cosmic._physics._subatomic.luminescent.*

import symmetrical.cosmic._physics._subatomic.spacial.IParticleBeam

open class Lepton(
    private val matter: IMatter = Matter(Lepton::class, AntiLepton::class),
) : Particle(),
    IMatter by matter,
    IEmitter
{
    constructor() : this(
        Matter(Lepton::class, AntiLepton::class),
    )

    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);

        val (clone, remainder) = Absorber.materialize(photon.propagate())
        this.fundamentals = clone as Fundamentals
        return Photon(remainder)
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return matter.getClassId()+fundamentals.emit().radiate()
    }
    override fun getClassId() : String {
        return matter.getClassId()
    }
    open fun i() : Lepton {
        return this
    }
//    fun getValue() : Any? {
//        val wavelength:Wavelength = getWavelength()
//        return wavelength.wavelength()
//    }
    override fun getIlluminations() : IParticleBeam {
        return matter.getIlluminations()
    }



}