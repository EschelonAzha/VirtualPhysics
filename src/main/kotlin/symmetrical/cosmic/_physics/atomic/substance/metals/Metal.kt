package symmetrical.cosmic._physics.atomic.substance.metals

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class Metal(
    private val luminescent: ILuminescent = Luminescent(Metal::class),
) :
    ILuminescent by luminescent
{

    constructor() : this(
        Luminescent(Metal::class),
    )
    override fun getClassId() : String {
        return luminescent.getClassId()
    }
}