package symmetrical.cosmic._physics._dimensions.time

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Time (
    private val antiMatter: IAntiMatter = AntiMatter(Time::class),
) :
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Time::class),
    )

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    fun i() : symmetrical.cosmic._physics._dimensions.time.Time {
        return this
    }
}