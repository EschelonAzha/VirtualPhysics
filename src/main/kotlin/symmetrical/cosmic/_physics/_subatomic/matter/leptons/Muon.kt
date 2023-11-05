package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

class Muon : Lepton {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    constructor() {
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Muon::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : Muon {
        super.i()
        return this
    }
}