package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiLepton
import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.luminescent.*

import symmetrical.cosmic._physics._subatomic.spacial.IParticleBeam
/*
https://en.wikipedia.org/wiki/Lepton
 */
open class Lepton(
    private val matter: IMatter = Matter(Lepton::class, AntiLepton::class),
) : Particle(),
    IMatter by matter,
    IEmitter
{
    constructor() : this(
        Matter(Lepton::class, AntiLepton::class),
    )

    open fun i() : Lepton {
        return this
    }

    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }

//    fun getValue() : Any? {
//        val wavelength:Wavelength = getWavelength()
//        return wavelength.wavelength()
//    }
    override fun getIlluminations() : IParticleBeam {
        return matter.getIlluminations()
    }
    private fun radiate() : String {
        return matter.getClassId()+
                super.emit().radiate()
    }

}