package symmetrical.cosmic._physics.atomic.blackhole

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

class Blackhole(
    private val entanglement: IQuantumEntanglement = QuantumEntanglement()
) :  IQuantumEntanglement by entanglement
{

    constructor() : this(
        QuantumEntanglement()
    )
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Blackhole::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    // black holes encompass all external libraries and frameworks
}