package symmetrical.cosmic._physics.atomic.matter

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

open class Matter(
    private val antiMatter: IAntiMatter = AntiMatter(Matter::class),
) :
    IAntiMatter by antiMatter
{

    constructor() : this(
        AntiMatter(Matter::class),
    )
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}