package symmetrical.cosmic._physics.atomic.bonds.mixtures

import symmetrical.cosmic._physics.atomic.matter.Matter
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class Solution(
    private val luminescent: ILuminescent = Luminescent(Solution::class),
) : Matter(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Solution::class),
    )

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
}