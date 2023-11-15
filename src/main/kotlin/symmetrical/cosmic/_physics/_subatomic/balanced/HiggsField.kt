package symmetrical.cosmic._physics._subatomic.balanced

import asymmetrical.machine.threads.Energy
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement


open class HiggsField(private val entanglement:QuantumEntanglement=QuantumEntanglement()) : Energy(), IQuantumEntanglement by entanglement {

    // Spin 0
    companion object {
        lateinit var higgsField : HiggsField

        fun setForce(higgs: HiggsField) : HiggsField {
            higgsField = higgs
            return higgs
        }
    }
    constructor() : this(QuantumEntanglement()) {
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