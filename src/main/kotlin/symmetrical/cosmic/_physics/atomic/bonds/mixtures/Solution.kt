package symmetrical.cosmic._physics.atomic.bonds.mixtures

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

class Solution(
    private val matter: IMatter = Matter(Solution::class, Solution::class, true),
) :
    IMatter by matter
{
    constructor() : this(
        Matter(Solution::class, Solution::class, true),
    )

    override fun getClassId() : String {
        return matter.getClassId()
    }
}