package symmetrical.cosmic._physics.atomic.substance.ions

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class Cation(
    private val luminescent: ILuminescent = Luminescent(Cation::class),
) : Ion(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Cation::class),
    )
    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    // plus
}