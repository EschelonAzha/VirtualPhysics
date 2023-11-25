package symmetrical.cosmic._physics.atomic.bonds.mixtures

import symmetrical.cosmic._physics.atomic.matter.Matter
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class Solution(
    private val fermion: ILuminescent = Luminescent(Solution::class),
) : Matter(),
    ILuminescent by fermion
{
    constructor() : this(
        Luminescent(Solution::class),
    )

    override fun getClassId() : String {
        return fermion.getClassId()
    }
}