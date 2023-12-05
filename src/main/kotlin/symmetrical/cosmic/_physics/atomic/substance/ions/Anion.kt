package symmetrical.cosmic._physics.atomic.substance.ions

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Anion(
    val antiMatter: IAntiMatter = AntiMatter(Anion::class, Anion::class),
) : Ion(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Anion::class, Anion::class),
    )
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    // Negative charge
}