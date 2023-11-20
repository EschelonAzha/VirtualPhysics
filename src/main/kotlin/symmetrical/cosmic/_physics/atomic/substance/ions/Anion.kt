package symmetrical.cosmic._physics.atomic.substance.ions

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

class Anion(
    val fermion: IQuantumEntanglement = QuantumEntanglement()
) : Ion(),
    IQuantumEntanglement by fermion
{
    constructor() : this(
        QuantumEntanglement()
    )
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Anion::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    // Negative charge
}