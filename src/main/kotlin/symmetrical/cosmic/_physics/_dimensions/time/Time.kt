package symmetrical.cosmic._physics._dimensions.time

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._creation.Universe
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

class Time {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    constructor() {
    }
    public fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(symmetrical.cosmic._physics._dimensions.time.Time::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    fun i() : symmetrical.cosmic._physics._dimensions.time.Time {
        return this
    }
}