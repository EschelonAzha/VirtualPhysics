package symmetrical.cosmic._physics._subatomic.forces.weak_force.neutral

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

class ChargedWeakForce {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    constructor() {
    }
    public fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(ChargedWeakForce::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    fun i() : ChargedWeakForce {
        return this
    }
}