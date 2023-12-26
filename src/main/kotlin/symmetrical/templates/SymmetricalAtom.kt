package symmetrical.templates

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spacial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.spacial.IParticleBeam
import symmetrical.cosmic.wormholes.messaging.login.ReadyMSG

class SymmetricalAtom : Particle   {    // 3

    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    object Static {
        const val STATIC      : Int = 0
    }

    constructor() {
    }
    fun i() : SymmetricalAtom {
        return this
    }


    override fun absorb(photon: Photon) : Photon {
        check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    public override fun getIlluminations() : IParticleBeam {
        return Illuminations.beam
    }

    override fun getClassId() : String {
        return getLocalClassId()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(ReadyMSG::class)
    }
    private fun radiate() : String {
        return getLocalClassId()+super.emit().radiate()
    }
}