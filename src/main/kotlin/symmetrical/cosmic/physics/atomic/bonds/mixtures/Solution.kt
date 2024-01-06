package symmetrical.cosmic.physics.atomic.bonds.mixtures

import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
/*
https://en.wikipedia.org/wiki/Solution_(chemistry)
 */
class Solution(
    private val matter: IMatter = Matter(Solution::class, Solution::class),
) :
    IMatter by matter
{
    constructor() : this(
        Matter(Solution::class, Solution::class),
    )

    override fun getClassId() : String {
        return matter.getClassId()
    }
}