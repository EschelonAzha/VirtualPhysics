package symmetrical.cosmic._physics._dimensions.temperature

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._creation.Universe
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

class Temperature (
    private val entanglement:IQuantumEntanglement
) :
    IQuantumEntanglement by entanglement
{
    constructor() : this(
        QuantumEntanglement()
    )

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Temperature::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    fun i() : Temperature {
        return this
    }
}