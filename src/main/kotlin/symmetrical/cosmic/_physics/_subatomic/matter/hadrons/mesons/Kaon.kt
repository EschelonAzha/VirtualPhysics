package symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiUp
import symmetrical.cosmic._physics._subatomic.matter.quarks.Strange
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam


class Kaon {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    lateinit var quark      : Strange
    lateinit var antiQuark  : AntiUp
    public fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Kaon::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
}