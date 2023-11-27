package symmetrical.cosmic._physics.atomic.substance.ions

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Cation(
    private val antiMatter: IAntiMatter = AntiMatter(Cation::class),
) : Ion(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Cation::class),
    )
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    // plus
}