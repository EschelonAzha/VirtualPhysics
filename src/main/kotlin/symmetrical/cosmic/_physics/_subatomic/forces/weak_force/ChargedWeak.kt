package symmetrical.cosmic._physics._subatomic.forces.weak_force

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

class ChargedWeak {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    // can emit a charged W Boson that can alter the charge of a Proton by
    // altering the structure of its quarks
    constructor() {
    }
    public fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(ChargedWeak::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    fun i() : ChargedWeak {
        return this
    }
}