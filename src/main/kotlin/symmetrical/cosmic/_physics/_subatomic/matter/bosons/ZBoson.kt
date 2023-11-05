package symmetrical.cosmic._physics._subatomic.matter.bosons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.weak_force.Weak
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam


open class ZBoson : Weak {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    // Neutral Charge
    // Spin 1
    // This boson transfers its spin, momentum and energy

    var result:Any? = null
    constructor() {
    }
    public fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(ZBoson::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    fun i() : Weak {
        return this
    }
}