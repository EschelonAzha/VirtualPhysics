package symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

// ORIGINAL VALUE
open class AntiRed (
    private val entanglement:IQuantumEntanglement
) : AntiColor(entanglement),
    IQuantumEntanglement by entanglement
{  // Byte
    constructor() : this(
        QuantumEntanglement()
    )

    init {
        color = ANTI_RED
    }


    private fun getLocalClassId() : String {
        return Absorber.getClassId(AntiRed::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : AntiRed {
        super.i()
        return this
    }
    override fun clone() : AntiRed {
        var result      = AntiRed()
        result.setValue(_value)
        return result
    }
}