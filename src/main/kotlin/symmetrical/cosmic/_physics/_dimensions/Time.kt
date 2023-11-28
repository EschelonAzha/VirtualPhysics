package symmetrical.cosmic._physics._dimensions

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

    var time:Long = 0

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    fun i() : Time {
        return this
    }
}