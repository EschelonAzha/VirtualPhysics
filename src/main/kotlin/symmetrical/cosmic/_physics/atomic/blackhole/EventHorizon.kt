package symmetrical.cosmic._physics.atomic.blackhole

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class EventHorizon (
    private val luminescent: ILuminescent = Luminescent(EventHorizon::class),
) :
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(EventHorizon::class),
    )

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    // Event horizon is the API to external libraries and frameworks
}