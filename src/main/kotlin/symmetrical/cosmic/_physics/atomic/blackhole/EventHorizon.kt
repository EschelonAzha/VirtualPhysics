package symmetrical.cosmic._physics.atomic.blackhole

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class EventHorizon (
    private val fermion: ILuminescent = Luminescent(EventHorizon::class),
) :
    ILuminescent by fermion
{
    constructor() : this(
        Luminescent(EventHorizon::class),
    )

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    // Event horizon is the API to external libraries and frameworks
}