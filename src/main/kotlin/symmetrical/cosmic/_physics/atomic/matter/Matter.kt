package symmetrical.cosmic._physics.atomic.matter

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

open class Matter(
    private val luminescent: ILuminescent = Luminescent(Matter::class),
) :
    ILuminescent by luminescent
{

    constructor() : this(
        Luminescent(Matter::class),
    )
    override fun getClassId() : String {
        return luminescent.getClassId()
    }
}