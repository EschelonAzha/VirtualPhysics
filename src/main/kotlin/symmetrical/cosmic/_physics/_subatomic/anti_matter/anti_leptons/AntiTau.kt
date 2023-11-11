package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.matter.leptons.Lepton
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam


class AntiTau  : AntiLepton {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    constructor() {

    }
    constructor(oldValue : Field) {
        fundamentals.getWavelength().setField(oldValue)
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(AntiTau::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : AntiTau {
        super.i()
        return this
    }
}