package symmetrical.cosmic._physics.atomic.blackhole

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Blackhole(
    private val antiMatter: IAntiMatter = AntiMatter(Blackhole::class),
) :
    IAntiMatter by antiMatter
{

    constructor() : this(
        AntiMatter(Blackhole::class),
    )
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    // black holes encompass all external libraries and frameworks
}