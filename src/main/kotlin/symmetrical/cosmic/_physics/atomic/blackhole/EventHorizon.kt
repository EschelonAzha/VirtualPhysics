package symmetrical.cosmic._physics.atomic.blackhole

import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class EventHorizon (
    private val antiMatter: IAntiMatter = AntiMatter(EventHorizon::class),
) :
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(EventHorizon::class),
    )

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    // Event horizon is the API to external libraries and frameworks
}