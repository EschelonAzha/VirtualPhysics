package symmetrical.cosmic._physics.atomic.bonds.mixtures

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.matter.Matter

class Mixture : Matter() {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    // mixtures may be regular classes with all kinds of things
    // mixed together that are other classes but not Atoms or Molecules
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Mixture::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
}