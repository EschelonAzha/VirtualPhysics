package symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

class CRLFTerminatedMomentum : AngularMomentum {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    constructor() {

    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(CRLFTerminatedMomentum::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun format(angularMomentum: AngularMomentum) : String {
        return Strings.crlfTerminated(angularMomentum.toString())
    }
}