package symmetrical.cosmic._physics.atomic.matter

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

open class Matter {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    public open fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Matter::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
}