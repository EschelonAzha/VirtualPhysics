package symmetrical.cosmic._physics._subatomic.balanced

import asymmetrical.machine.threads.Energy
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam


open class HiggsField : Energy {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    // Spin 0
    companion object {
        lateinit var higgsField : HiggsField

        fun setForce(higgs: HiggsField) : HiggsField {
            higgsField = higgs
            return higgs
        }
    }
    constructor() {
    }
    public fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(HiggsField::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    open fun materialize() : HiggsField {
        println("Higgs")
        return this
    }
}