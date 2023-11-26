package symmetrical.cosmic._physics.atomic.substance.ions

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

open class Ion(
    private val luminescent: ILuminescent = Luminescent(Ion::class),
) :
    ILuminescent by luminescent
{

    constructor() : this(
        Luminescent(Ion::class),
    )
    override fun getClassId() : String {
        return luminescent.getClassId()
    }
}