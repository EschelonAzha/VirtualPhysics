package symmetrical.cosmic._physics.atomic.substance.ions

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

open class Ion {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    public open fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Ion::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
}