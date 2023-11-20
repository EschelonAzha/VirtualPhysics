package symmetrical.cosmic._physics._dimensions.time

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

class Time (
    private val fermion: IQuantumEntanglement = QuantumEntanglement(),
) :
    IQuantumEntanglement by fermion
{
    constructor() : this(
        QuantumEntanglement()
    )

    private fun getLocalClassId() : String {
        return Absorber.getClassId(symmetrical.cosmic._physics._dimensions.time.Time::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    fun i() : symmetrical.cosmic._physics._dimensions.time.Time {
        return this
    }
}