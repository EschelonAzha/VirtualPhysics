package symmetrical.cosmic._physics._dimensions.time

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class Time (
    private val luminescent: ILuminescent = Luminescent(Time::class),
) :
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Time::class),
    )

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    fun i() : symmetrical.cosmic._physics._dimensions.time.Time {
        return this
    }
}