package symmetrical.cosmic._physics.atomic.substance.metals

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Metal(
    private val antiMatter: IAntiMatter = AntiMatter(Metal::class, Metal::class),
) :
    IAntiMatter by antiMatter
{

    constructor() : this(
        AntiMatter(Metal::class, Metal::class),
    )
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}