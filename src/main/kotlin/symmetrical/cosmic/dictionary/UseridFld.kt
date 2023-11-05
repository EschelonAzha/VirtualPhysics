package symmetrical.cosmic.dictionary

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString

class UseridFld : QString {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    constructor() {

    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(UseridFld::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
}