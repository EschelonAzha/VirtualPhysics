package symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

// ORIGINAL VALUE
open class AntiGreen (private val entanglement:QuantumEntanglement=QuantumEntanglement()) : AntiColor(), IQuantumEntanglement by entanglement { // Char

    init {
        color = ANTI_GREEN
    }
    constructor() : this(QuantumEntanglement()) {
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(AntiGreen::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : AntiGreen {
        super.i()
        return this
    }
    override fun clone() : AntiGreen {
        var result      = AntiGreen()
        result.setValue(_value)
        return result
    }
}