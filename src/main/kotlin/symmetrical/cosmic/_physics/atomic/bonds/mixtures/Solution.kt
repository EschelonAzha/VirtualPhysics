package symmetrical.cosmic._physics.atomic.bonds.mixtures

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics.atomic.matter.Matter
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

class Solution(
    private val fermion: IQuantumEntanglement = QuantumEntanglement()
) : Matter(),
    IQuantumEntanglement by fermion
{
    constructor() : this(
        QuantumEntanglement()
    )

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Solution::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
}