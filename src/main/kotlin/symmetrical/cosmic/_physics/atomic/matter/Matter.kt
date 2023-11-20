package symmetrical.cosmic._physics.atomic.matter

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

open class Matter(
    private val entanglement: IQuantumEntanglement = QuantumEntanglement()
) :
    IQuantumEntanglement by entanglement
{

    constructor() : this(
        QuantumEntanglement()
    )
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Matter::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
}