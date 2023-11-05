package symmetrical.cosmic._physics._dimensions.charge

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._creation.Universe
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

class Charge {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    constructor() {
    }
    public fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(symmetrical.cosmic._physics._dimensions.charge.Charge::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    fun i() : symmetrical.cosmic._physics._dimensions.charge.Charge {
        return this
    }
}