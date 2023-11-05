package symmetrical.cosmic._physics._subatomic.balanced.pairs

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.matter.leptons.Lepton
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

open class LeptonPair {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }

    var leptons : Array<Particle?> = arrayOfNulls<Particle>(2)
    constructor() {
    }
    public open fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(LeptonPair::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
}