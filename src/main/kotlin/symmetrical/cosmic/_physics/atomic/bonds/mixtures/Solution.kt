package symmetrical.cosmic._physics.atomic.bonds.mixtures

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics.atomic.matter.Matter
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Solution(
    private val fermion: IFermion = Fermion(Solution::class),
) : Matter(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(Solution::class),
    )

    override fun getClassId() : String {
        return fermion.getClassId()
    }
}