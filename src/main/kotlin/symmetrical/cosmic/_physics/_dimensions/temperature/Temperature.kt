package symmetrical.cosmic._physics._dimensions.temperature

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

class Temperature (
    private val fermion: IQuantumEntanglement = QuantumEntanglement(),
) :
    IQuantumEntanglement by fermion
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