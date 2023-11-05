package symmetrical.cosmic._physics.atomic.substance.ions

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

class Cation() : Ion() {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Cation::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    // plus
}