package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam


class Tau : Lepton {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    constructor() {
    }
    constructor(newValue : Field) {
        fundamentals.getWavelength().setField(newValue)
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Tau::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : Tau {
        super.i()
        return this
    }
}