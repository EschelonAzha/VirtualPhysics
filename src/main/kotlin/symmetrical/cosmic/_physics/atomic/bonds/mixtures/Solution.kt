package symmetrical.cosmic._physics.atomic.bonds.mixtures

import symmetrical.cosmic._physics.atomic.matter.Matter
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Solution(
    private val antiMatter: IAntiMatter = AntiMatter(Solution::class),
) : Matter(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Solution::class),
    )

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}