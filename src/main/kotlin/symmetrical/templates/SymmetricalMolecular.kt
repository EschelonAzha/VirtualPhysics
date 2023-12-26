package symmetrical.templates

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spacial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.spacial.IParticleBeam
import symmetrical.cosmic._physics.atomic.bonds.covalent.Molecular
import symmetrical.cosmic.wormholes.messaging.login.ReadyMSG

class SymmetricalMolecular : Molecular {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    object Static {
        const val LAST      : Int = Molecular.Static.LAST
    }

    constructor() {
    }
    override fun i() : SymmetricalMolecular {
        return this
    }
    public override fun getIlluminations() : IParticleBeam {
        return Illuminations.beam
    }

    override fun absorb(photon: Photon) : Photon {
        check(photon);

        return super.absorb(photon.propagate())
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return getLocalClassId()+super.emit().radiate()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(ReadyMSG::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
}