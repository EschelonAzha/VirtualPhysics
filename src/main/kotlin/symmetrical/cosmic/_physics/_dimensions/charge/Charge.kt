package symmetrical.cosmic._physics._dimensions.charge

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Charge (
    private val antiMatter: IAntiMatter = AntiMatter(Charge::class),
) :
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Charge::class),
    )

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    fun i() : Charge {
        return this
    }
}