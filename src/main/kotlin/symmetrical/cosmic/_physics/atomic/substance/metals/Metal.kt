package symmetrical.cosmic._physics.atomic.substance.metals

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

class Metal {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    public fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Metal::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
}