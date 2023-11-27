package symmetrical.cosmic._physics._dimensions.temperature

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Temperature (
    private val antiMatter: IAntiMatter = AntiMatter(Temperature::class),
) :
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Temperature::class),
    )

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    fun i() : Temperature {
        return this
    }
}