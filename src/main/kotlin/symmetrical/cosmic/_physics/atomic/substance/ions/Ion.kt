package symmetrical.cosmic._physics.atomic.substance.ions

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

open class Ion(
    private val antiMatter: IAntiMatter = AntiMatter(Ion::class),
) :
    IAntiMatter by antiMatter
{

    constructor() : this(
        AntiMatter(Ion::class),
    )
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}