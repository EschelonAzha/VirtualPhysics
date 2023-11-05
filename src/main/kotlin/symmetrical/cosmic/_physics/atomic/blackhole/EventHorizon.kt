package symmetrical.cosmic._physics.atomic.blackhole

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

class EventHorizon {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    public fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(EventHorizon::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    // Event horizon is the API to external libraries and frameworks
}