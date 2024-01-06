package symmetrical.cosmic.physics.subatomic.matter.leptons

import symmetrical.cosmic.physics.subatomic.bosons.IEmitter
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.balanced.Particle

import symmetrical.cosmic.physics.subatomic.spacial.IParticleBeam
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_leptons.AntiLepton
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter

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