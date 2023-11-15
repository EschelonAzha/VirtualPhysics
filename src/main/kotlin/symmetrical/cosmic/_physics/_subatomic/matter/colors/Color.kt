package symmetrical.cosmic._physics._subatomic.matter.colors

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.color.ChromoCharge
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

open class Color(private val entanglement: QuantumEntanglement = QuantumEntanglement()): ChromoCharge(), IQuantumEntanglement by entanglement {

    constructor() : this(QuantumEntanglement()) {
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Color::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : Color {
        super.i()
        return this
    }
}