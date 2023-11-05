package symmetrical.cosmic._physics.atomic.blackhole

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

class Blackhole {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    public fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Blackhole::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    // black holes encompass all external libraries and frameworks
}