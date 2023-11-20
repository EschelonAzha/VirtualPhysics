package symmetrical.cosmic._physics._dimensions.charge

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

class Charge (
    private val fermion: IQuantumEntanglement = QuantumEntanglement(),
) :
    IQuantumEntanglement by fermion
{
    constructor() : this(
        QuantumEntanglement()
    )

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Charge::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    fun i() : Charge {
        return this
    }
}