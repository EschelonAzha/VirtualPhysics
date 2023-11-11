package symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

class AntiCharm : AntiQuark() {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(AntiCharm::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
}