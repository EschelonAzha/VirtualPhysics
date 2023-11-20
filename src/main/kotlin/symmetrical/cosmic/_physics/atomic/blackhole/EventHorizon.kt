package symmetrical.cosmic._physics.atomic.blackhole

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

class EventHorizon (
    private val entanglement: IQuantumEntanglement = QuantumEntanglement()
) : IQuantumEntanglement by entanglement
{
    constructor() : this(
        QuantumEntanglement()
    )

    private fun getLocalClassId() : String {
        return Absorber.getClassId(EventHorizon::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    // Event horizon is the API to external libraries and frameworks
}